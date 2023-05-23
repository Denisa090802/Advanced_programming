package org.lab10.server;

public class Board {
    private static final int SIZE = 15;
    private static final char EMPTY = '-';
    private static final char PLAYER_1_SYMBOL = 'X';
    private static final char PLAYER_2_SYMBOL = 'O';
    private static final int WINNING_STONES = 5;

    private char[][] board;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public synchronized boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    public synchronized void makeMove(char symbol, int row, int col) {
        board[row][col] = symbol;
    }

    public synchronized boolean isWinningBoard() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private synchronized boolean checkRows() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - WINNING_STONES; j++) {
                char symbol = board[i][j];
                if (symbol != EMPTY) {
                    boolean foundWin = true;
                    for (int k = 1; k < WINNING_STONES; k++) {
                        if (board[i][j + k] != symbol) {
                            foundWin = false;
                            break;
                        }
                    }
                    if (foundWin) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private synchronized boolean checkColumns() {
        for (int i = 0; i <= SIZE - WINNING_STONES; i++) {
            for (int j = 0; j < SIZE; j++) {
                char symbol = board[i][j];
                if (symbol != EMPTY) {
                    boolean foundWin = true;
                    for (int k = 1; k < WINNING_STONES; k++) {
                        if (board[i + k][j] != symbol) {
                            foundWin = false;
                            break;
                        }
                    }
                    if (foundWin) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private synchronized boolean checkDiagonals() {
        // Check main diagonals
        for (int i = 0; i <= SIZE - WINNING_STONES; i++) {
            for (int j = 0; j <= SIZE - WINNING_STONES; j++) {
                char symbol = board[i][j];
                if (symbol != EMPTY) {
                    boolean foundWin = true;
                    for (int k = 1; k < WINNING_STONES; k++) {
                        if (board[i + k][j + k] != symbol) {
                            foundWin = false;
                            break;
                        }
                    }
                    if (foundWin) {
                        return true;
                    }
                }
            }
        }

        // Check anti-diagonals
        for (int i = WINNING_STONES - 1; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - WINNING_STONES; j++) {
                char symbol = board[i][j];
                if (symbol != EMPTY) {
                    boolean foundWin = true;
                    for (int k = 1; k < WINNING_STONES; k++) {
                        if (board[i - k][j + k] != symbol) {
                            foundWin = false;
                            break;
                        }
                    }
                    if (foundWin) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public String toString(int index) {
        String result = new String();
        int line = index + 1;
        result += line;
        if (line < 10) {
            result += ' ';
            result += ' ';
        } else {
            result += ' ';
        }
        for (int i = 0; i < SIZE-1; i++) {
            result += board[index][i];
            result += '|';
        }
        result += board[index][SIZE-1];
        return result;
    }


}
