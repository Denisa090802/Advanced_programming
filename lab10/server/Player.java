package org.lab10.server;

import java.net.Socket;

public class Player {
    private Socket clientSocket;
    private String name;
    private char symbol;

    private long lastMoveTime;

    private long remainingTime;

    public Player(String name, char symbol, Socket clientSocket) {
        this.name = name;
        this.symbol = symbol;
        this.remainingTime = 500_000;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public String getName() {
        return this.name;
    }
    public char getSymbol() {
        return this.symbol;
    }
    public synchronized void updateLastMoveTime() {
        lastMoveTime = System.currentTimeMillis();
    }
    public synchronized long getLastMoveTime() {
        return lastMoveTime;
    }
    public synchronized long getRemainingTime() {
        return this.remainingTime;
    }
    public synchronized  void updateRemainingTime() {
        System.out.println(remainingTime);
        remainingTime = remainingTime - (System.currentTimeMillis() - getLastMoveTime());
    }
}
