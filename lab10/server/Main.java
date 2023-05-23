package org.lab10.server;

public class Main {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer(12345);
        gameServer.start();
    }
}