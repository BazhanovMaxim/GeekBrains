package prev;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как

    public EchoServer() {

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");

            clientSocket = serverSocket.accept();
            System.out.printf("Клиент подключился, %s\n", clientSocket.getLocalSocketAddress());

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Принимаем сообщение
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); // Отдаём сообщение

            Thread getMessage = new Thread(new ReadMessageThread(clientSocket, in, reader));
            Thread sendMessage = new Thread(new SendMessageThread(out, reader));

            getMessage.start();
            sendMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}