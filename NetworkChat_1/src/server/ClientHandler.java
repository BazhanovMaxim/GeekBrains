package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private AuthService.Record record;
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

            new Thread(new Runnable() {
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
            })
                    .start();
        } catch (IOException e) {
            System.out.println("Client Handler не был создан.");
        }
    }

    /**
     * Получение данных о пользователе
     *
     * @return record (пользователь)
     */
    public AuthService.Record getRecord() {
        return record;
    }

    /**
     * Авторизация пользователя
     *
     * @throws IOException чтение
     */
    public void doAuth() throws IOException {
        while (true) {
            String message = in.readUTF();
            if (message.startsWith("/auth")) {
                String[] credentials = message.split("\\s");
                AuthService.Record possibleRecord = server.getAuthService().findRecord(credentials[1], credentials[2]);
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
                    sendMessage(String.format("Пользователь не был найден"));
                }
            }
        }
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