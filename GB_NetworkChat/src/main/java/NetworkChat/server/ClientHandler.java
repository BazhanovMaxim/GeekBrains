package NetworkChat.server;

import NetworkChat.client.Record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Record record;
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    /**
     * Прослушка пользователей
     *
     * @param server сервер, к которому подключены
     * @param socket сокет пользователя
     */
    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Server.executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        doAuth();
                        readMessage();
                    } catch (IOException e) {
                        System.out.println("Чтение клиента заверешено");
                    } finally {
                        closeConnection();
                    }
                }
            });

            //new Thread(new Runnable() {
            //    @Override
            //    public void run() {
            //        try {
            //            doAuth();
            //            readMessage();
            //        } catch (IOException e) {
            //            System.out.println("Чтение клиента заверешено");
            //        } finally {
            //            closeConnection();
            //        }
            //    }
            //})
            //        .start();
        } catch (IOException e) {
            System.out.println("Client Handler не был создан.");
        }
    }


    /**
     * Авторизация пользователя.
     * Со стороны пользователя отправляются login и пароль с текстом: '/auth', если
     * пользователь найден, то сервер отправляет - authok и пользователь может пользоваться чатом,
     * иначе - пользователь не найден.
     *
     * @throws IOException чтение-запись файлов
     */
    public void doAuth() throws IOException {
        while (true) {
            String message = in.readUTF();
            if (message.startsWith("/auth")) {
                String[] userCredentials = message.split("\\s");
                // Отправка в бд запрос для поиска клиента, возвращаем
                Record possibleRecord = server.getRecordInDataBase(userCredentials[1], userCredentials[2]);
                // Если вернулся пользователь, то проверяем, что нет занятого
                if (possibleRecord != null) {
                    if (!server.isOccupied(possibleRecord)) {
                        record = possibleRecord;
                        sendMessage(String.format("%s, %s", "/authok", record.getName()));
                        server.sendMessage(record.getName(), "Подключился к чату " + record.getName());
                        server.subscribe(this);
                        break;
                    } else {
                        sendMessage(String.format("Пользователь[%s] уже есть", possibleRecord.getName()));
                    }
                } else {
                    sendMessage("Пользователь не был найден");
                }
            } else if (message.startsWith("/registration")) {
                String[] userCredentials = message.split("\\s");
                if (server.registrationUser(userCredentials[1], userCredentials[2], userCredentials[3])) {
                    sendMessage("/registrationok");
                    break;
                }
            }
        }
    }

    /**
     * Получение данных о пользователе
     *
     * @return record (пользователь)
     */
    public Record getRecord() {
        return record;
    }

    /**
     * Отправка сообщение
     *
     * @param message сообщение
     */
    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            System.out.printf("Сокет клиента был закрыт. , %s", e);
        }
    }

    /**
     * Чтение сообщений
     *
     * @throws IOException чтение сообщения
     */
    public void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();
            if (message.equals("/end")) {
                return;
            }
            server.sendMessage(record.getName(), message);
        }
    }

    /**
     * Закрываем все подключения пользователей
     */
    public void closeConnection() {
        server.unsubscribe(this);
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Чтение заверешено. ");
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Отправка сообщений от сервера закрыта.");
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Сокет закрыт.");
        }
    }
}