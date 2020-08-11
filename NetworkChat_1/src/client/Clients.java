package client;

import server.Server;

import java.io.IOException;

public class Clients {
    public static void main(String[] args) {
        ClientApp[] clients = {
                new ClientApp(Server.PORT, "bazhanov.login BAZH Maxim"),
                new ClientApp(Server.PORT, "anton.login ANTON Anton"),
                new ClientApp(Server.PORT, "gerald.login GERALD Gerald")
        };

        for (ClientApp client : clients) {
            try {
                client.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}