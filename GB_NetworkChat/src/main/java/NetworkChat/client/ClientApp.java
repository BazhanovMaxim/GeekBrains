package NetworkChat.client;

import NetworkChat.GUI.ChatFrame;
import NetworkChat.server.MessageListener;
import NetworkChat.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp {

    private final int port = Server.PORT;
    private final String userLogin;
    private final String userPassword;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ChatFrame chatFrame;

    /**
     * Пользователь обращется уже с логином и паролем
     *
     * @param userLogin    логин пользователя
     * @param userPassword пароль пользователя
     */
    public ClientApp(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    /**
     * Инициализация, отправка
     *
     * @throws IOException чтения-записи
     */
    private synchronized void init() throws IOException {
        socket = new Socket("localhost", port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        chatFrame = new ChatFrame("Клиент чата ",
                new MessageListener() {
                    @Override
                    public void messagePerformed(String message) {
                        try {
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
     * @throws IOException чтения-записи
     */
    public void start() throws IOException {
        init();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doAuthorization(userLogin, userPassword);
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
    private synchronized void doAuthorization(String userLogin, String userPassword) throws IOException {
        out.writeUTF("/auth " + userLogin + " " + userPassword);
        while (true) {
            String message = in.readUTF();
            if (message.startsWith("/authok")) {
                String[] userCredentials = message.split("\\s");
                System.out.printf("Авторизация пользователя[%s] прошла успешно\n", userCredentials[1]);
                break;
            }
        }
    }
}