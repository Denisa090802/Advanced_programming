package org.lab10.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameServer {

    private static final int GAME_TIME_LIMIT = 300;
    private ServerSocket serverSocket;

    private int port;

    private static List<Game> games = new ArrayList<>();

    public GameServer(int port) {
        this.port = port;
    }

    public synchronized int generateValidCode() {
        Random random = new Random();
        int ok = 1;
        int code;
        do {
            code = (int) ((Math.random() * (999 - 100)) + 100);
            for (Game game : games) {
                if (game.getCode() == code) {
                    ok = 0;
                }
            }
        } while (ok == 0);
        return code;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected with " + clientSocket.getInetAddress());

                ClientThread clientThread = new ClientThread(clientSocket, games, this);
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

