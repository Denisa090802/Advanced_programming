package org.lab10.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private Socket clientSocket;

    private List<Game> games = new ArrayList<>();

    private GameServer gameServer;

    private Game game;

    private Player player;


    public ClientThread(Socket clientSocket, List<Game> games, GameServer gameServer) {
        this.clientSocket = clientSocket;
        this.games = games;
        this.gameServer = gameServer;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while (true) {
                inputLine = input.readLine();

                if (inputLine.equals("stop")) {
                    output.println("Server stopped");
                    break;
                } else if (inputLine.equals("create game")) {
                    if (game == null) {
                        // cream un joc si conectam clientii
                        game = new Game();
                        game.setCode(gameServer.generateValidCode());
                        player = new Player("Player1",'X',clientSocket);
                        games.add(game);
                        game.addPlayer(player);
                        output.println("Game created: " + game.getCode());
                    } else {
                        output.println("You are already in a game.");
                    }
                } else if (inputLine.startsWith("join game")) {
                    if (game == null) {
                        String codeString = inputLine.substring(10);
                        int code = Integer.parseInt(codeString);
                        int gameFound = 0;
                        for (Game game : games) {
                            if (code == game.getCode()) {
                                if (game.isFull()) {
                                    output.println("This game is full");
                                } else {
                                    output.println("Connected succesfully");
                                    player = new Player("Player2", 'O',clientSocket);
                                    game.addPlayer(player);
                                    this.game = game;
                                }
                                gameFound = 1;
                            }
                        }
                        if (gameFound == 0) {
                            output.println("Game not found");
                        }
                    } else {
                        output.println("You are already in a game.");
                    }
                } else if (inputLine.startsWith("move") && game != null) {
                    // verificam daca mutarea e buna
                    System.out.println(inputLine.substring(5));
                    int row = Integer.parseInt(inputLine.substring(6)) - 1;
                    System.out.println(inputLine.substring(5,6));
                    char ch = inputLine.substring(5,6).charAt(0);
                    int col = (int) ch - 65;
                    if ((inputLine.substring(5).matches("[A-O]1[0-5]") || inputLine.substring(5).matches("[A-O][1-9]")) &&
                            game.getBoard().isValidMove(row,col) &&
                            game.isPlayerTurn(player) &&
                            game.isFull() &&
                            !game.isGameOver()) {
                        output.println("Valid move");
                        game.makeMove(player,row,col);
                        output.println("   A|B|C|D|E|F|G|H|I|J|K|L|M|N|O");
                        for (int i = 0; i < 15; i++) {
                            output.println(game.getBoard().toString(i));
                        }
                    } else {
                        if (game == null) {
                            output.println("You are not in a game.");
                        } else if (!game.isFull()) {
                            output.println("The game didn't started yet.");
                        } else if (game.isGameOver()) {
                            output.println("Game over.");
                        } else if (!game.isPlayerTurn(player)) {
                            output.println("Is not your turn!");
                        } else if (!game.getBoard().isValidMove(row, col)) {
                            output.println("Invalid move");
                        }
                    }
                } else {
                    output.println("Unknown command");
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
