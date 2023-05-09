package org.lab10.server;

import java.io.*;
import java.net.*;

public class GameServer {
    private ServerSocket serverSocket;
    private int port;

    public GameServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected with " + clientSocket.getInetAddress());

                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

