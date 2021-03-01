package NetworkChat.server;

import NetworkChat.DataBase.BaseAuthService;
import NetworkChat.client.Record;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final int PORT = 8585;
    public static final ExecutorService executorService = Executors.newFixedThreadPool(1);      //Создание статического ExecutorService
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

            clientHandlers = new HashSet<>();

            System.out.println("Сервер запущен. Ожидание подключения пользователей... ");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.printf("Клиент[%s] подключен \n", socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            System.out.printf("Сервер не удалось создать, %s", e);
        }
    }

    /**
     * Отправка в бд данные о пользователе
     *
     * @param userLogin    логин пользователя
     * @param userPassword пароль пользователя
     * @return возвращает обьект класса Record (если пользователь найден, иначе null)
     */
    public Record getRecordInDataBase(String userLogin, String userPassword) {
        return new BaseAuthService().findUserByLoginAndPassword(userLogin, userPassword);
    }

    public boolean registrationUser(String userName, String userLogin, String userPassword) {
        return new BaseAuthService().userRegistration(userName, userLogin, userPassword);
    }

    /**
     * Проверка на то, чтобы пользователь ранее не был авторизаон
     *
     * @param record данные пользователя
     * @return boolean
     */
    public synchronized boolean isOccupied(Record record) {
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