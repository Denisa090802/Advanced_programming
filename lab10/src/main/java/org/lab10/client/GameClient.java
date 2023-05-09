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
                    break;
                }

                String response = reader.readLine();
                System.out.println(response);
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


