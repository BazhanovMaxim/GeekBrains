package prev;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private static BufferedReader reader; // Читаем консоль
    private static BufferedReader in; // Чтение записи-ответа (Сервера)
    private static BufferedWriter out; // Запись в поток

    public Client() {
        openConnection();
    }

    private void openConnection() {
        try {
            clientSocket = new Socket("localhost", 8189);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("Вы подключились, напишите сообщение: ");

            Thread sendMessage = new Thread(new SendMessageThread(out, reader));
            Thread getMessage = new Thread(new ReadMessageThread(clientSocket, in, reader));

            sendMessage.start();
            getMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
