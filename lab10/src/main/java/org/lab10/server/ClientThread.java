package org.lab10.server;

import java.io.*;
import java.net.*;

public class ClientThread extends Thread {
    private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                if (inputLine.equals("stop")) {
                    output.println("Server stopped");
                    System.exit(0);
                    break;
                } else {
                    output.println("Server received the request");
                }
            }

            input.close();
            output.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
