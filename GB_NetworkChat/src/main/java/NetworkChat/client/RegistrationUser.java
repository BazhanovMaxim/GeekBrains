package NetworkChat.client;

import NetworkChat.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RegistrationUser {
    private final int port = Server.PORT;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    /**
     * Нужен для регистрации пользователя
     *
     * @param userName     имя пользователя
     * @param userLogin    логин пользователя
     * @param userPassword пароль пользователя
     * @throws IOException исключение чтения-записи
     */
    public boolean RegistrationUser(String userName, String userLogin, String userPassword) throws IOException {
        socket = new Socket("localhost", port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        return doRegistration(userName, userLogin, userPassword);
    }

    /**
     * Регистрация пользователя, отправляем запрос в бд на создание пользователя, ждём ответ от бд
     *
     * @throws IOException чтение и запись
     */
    private synchronized boolean doRegistration(String userName, String userLogin, String userPassword) throws IOException {
        out.writeUTF("/registration " + userName + " " + userLogin + " " + userPassword);
        while (true) {
            String message = in.readUTF();
            if (message.startsWith("/registrationok")) {
                socket.close();
                in.close();
                out.close();
                return true;
            }
        }
    }
}
