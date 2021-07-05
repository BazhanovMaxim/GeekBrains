package client;

import server.ChatFrame;
import server.MessageListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp {

    private int port;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ChatFrame chatFrame;
    private String logPass;
    private String userName;

    public ClientApp(int port, String logPass) {
        this.port = port;
        this.logPass = logPass;
        String[] getName = logPass.split(" ", 3);
        userName = getName[2];
    }

    /**
     * Инициализация, отправка
     *
     * @throws IOException
     */
    private synchronized void init() throws IOException {
        socket = new Socket("localhost", port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        chatFrame = new ChatFrame("Клиент чата " + userName,
                new MessageListener() {
                    @Override
                    public void messagePerformed(String message) {
                        try {
                            System.out.println("Пользователь подключился");
                            out.writeUTF(message);
                        } catch (IOException e) {
                            System.out.printf("Ошибка в отправке сообщение, %s", e);
                        }
                    }
                });
    }

    /**
     * Запуск потоков с клиентами и приложениями
     *
     * @throws IOException ошибка запуска потока
     */
    public void start() throws IOException {
        init();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doAuthorization();
                    while (true) {
                        String message = in.readUTF();
                        if (message.equals("/end")) {
                            System.out.println("Сессия прекращена.");
                            break;
                        }
                        chatFrame.sendMessage(message);
                    }
                } catch (IOException e) {
                    System.out.printf("Клиента не получилось запустить, либо сервер был выключен, %s", e);
                }

            }
        });
        thread.start();
    }

    /**
     * Авторизация клиента, отправка данных (лог, пасс, ник)
     *
     * @throws IOException чтение и запись
     */
    private synchronized void doAuthorization() throws IOException {
        out.writeUTF("/auth " + logPass);
        while (true) {
            String message = in.readUTF();
            if (message.startsWith("/authok")) {
                System.out.printf("Авторизация пользователя[%s] прошла успешно\n", userName);
                break;
            }
        }
    }
}