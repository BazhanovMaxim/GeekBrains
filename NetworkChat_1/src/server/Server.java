package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {
    public static final int PORT = 8585;

    private AuthService authService;
    private Set<ClientHandler> clientHandlers;

    public Server() {
        this(PORT);
    }

    /**
     * Создание сервера
     *
     * @param port Порт сервера для подключения клиентов
     */
    public Server(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            authService = new BasicAuthService();

            clientHandlers = new HashSet<>();

            System.out.println("Ожидание подключения пользователей... ");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.printf("Клиент[%s] подключен \n", socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            System.out.printf("Сервер не удалось создать, %s", e);
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isOccupied(AuthService.Record record) {
        for (ClientHandler ch : clientHandlers) {
            if (ch.getRecord().equals(record)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler ch) {
        clientHandlers.add(ch);
    }

    public synchronized void unsubscribe(ClientHandler ch) {
        clientHandlers.remove(ch);
    }

    public synchronized void sendMessage(String name, String message) {
        broadcastMessage(name, message);
    }

    private void broadcastMessage(String name, String message) {
        for (ClientHandler ch : clientHandlers) {
            ch.sendMessage(String.format("%s: %s", name, message));
        }
    }
}