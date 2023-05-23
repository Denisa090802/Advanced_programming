package org.lab10.client;

import java.io.*;
import java.net.*;

public class GameClient {
    private String host;
    private int port;

    public GameClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try {
            Socket socket = new Socket(host, port);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                output.println(inputLine);

                if (inputLine.equals("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }
                String result = new String();
                if (inputLine.startsWith("move")) {
                    inputLine = reader.readLine();
                    if (inputLine.equals("Valid move")) {
                        System.out.println(inputLine);
                        for (int i = 0; i < 16; i++) {
                            inputLine = reader.readLine();
                            System.out.println(inputLine);
                        }
                    } else {
                        System.out.println(inputLine);
                    }
                } else {
                    inputLine = reader.readLine();
                    System.out.println(inputLine);
                }
                if (result.equals("Server stopped")) {
                    break;
                }
            }

            input.close();
            output.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


