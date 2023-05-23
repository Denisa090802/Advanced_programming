package org.lab10.server;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private int gameTimeLimit;

    private int gameCode;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.gameTimeLimit = 600;
    }
    public Board getBoard() {
        return board;
    }
    public int getCode() {
        return gameCode;
    }
    public void setCode(int code) {
        this.gameCode = code;
    }
    public synchronized  void addPlayer(Player player) {
        players.add(player);
    }
    public synchronized boolean isFull() {
        return players.size() == 2;
    }
    public synchronized  boolean isPlayerTurn(Player player) {
        return players.indexOf(player) == currentPlayerIndex;
    }
    public synchronized void makeMove(Player player, int row, int col) {
        if (isPlayerTurn(player)) {
            if (board.isValidMove(row, col)) {
                board.makeMove(player.getSymbol(),row,col);
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
                player.updateLastMoveTime();
            }
        }
    }

    public synchronized boolean isGameOver() {
        return board.isWinningBoard() || isTimeUp();
    }

    private synchronized  boolean isTimeUp() {
        //   int elapsedTime = (int) ((System.currentTimeMillis() - players.get(0).getLastMoveTime()) / 1_000);
        //  return elapsedTime >= gameTimeLimit;
        return false;
    }

}