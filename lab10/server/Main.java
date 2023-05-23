package org.lab10.server;

public class Main {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer(1234);
        gameServer.start();
    }
}