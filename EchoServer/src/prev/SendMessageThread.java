package prev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class SendMessageThread implements Runnable {

    private volatile boolean running = true;
    private BufferedWriter out; // поток записи в сокет
    private BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как

    public SendMessageThread(BufferedWriter out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            while (running) {
                String message = reader.readLine();
                if (message.equalsIgnoreCase("/end")){
                    out.write(message + "Соединение закрыто.\n");
                    closeConnection();
                    break;
                }
                out.write(message + "\n");
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Соединение закрыто.");
        }
    }

    private void closeConnection(){
        try {
            out.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
