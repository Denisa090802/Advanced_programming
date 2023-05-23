package org.lab10.client;

public class Main {
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GameClient gameClient = new GameClient("localhost", 1234);
        gameClient.start();
    }
}