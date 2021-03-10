package prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ReadMessageThread implements Runnable {

    private volatile boolean running = true;
    private Socket clientSocket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как

    public ReadMessageThread(Socket clientSocket, BufferedReader in, BufferedReader reader) {
        this.clientSocket = clientSocket;
        this.in = in;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            while (running) {
                String userMessage = in.readLine();
                if (userMessage.equalsIgnoreCase("/end")) {
                    System.out.printf("%s : %s\n", clientSocket.getLocalSocketAddress(), userMessage);
                    closeConnection();
                    break;
                }
                System.out.printf("%s : %s\n", clientSocket.getLocalSocketAddress(), userMessage);
            }
        } catch (IOException e) {
            System.out.println("Соединение закрыто.");
        }
    }


    private void closeConnection(){
        try {
            clientSocket.close();
            in.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
