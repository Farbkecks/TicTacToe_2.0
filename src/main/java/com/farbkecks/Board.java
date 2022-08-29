package com.farbkecks;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    Player[] board;
    final static Scanner scanner = new Scanner(System.in);

    public Board() {
        this.board = new Player[9];
        Arrays.fill(board, Player.NULL);
    }

    void clearBoard() {
        Arrays.fill(board, Player.NULL);
    }

    boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[0 + i] == board[3 + i] && board[3 + i] == board[6 + i]) {
                if (board[0 + i] != Player.NULL) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 7; i += 3) {
            if (board[0 + i] == board[1 + i] && board[1 + i] == board[2 + i]) {
                if (board[0 + i] != Player.NULL) {
                    return true;
                }
            }
        }
        if (board[0] == board[4] && board[4] == board[8]) {
            if (board[0] != Player.NULL) {
                return true;
            }
        }
        if (board[6] == board[4] && board[4] == board[2]) {
            if (board[6] != Player.NULL) {
                return true;
            }
        }

        return false;
    }

    boolean checkForEve() {
        for (Player i : board) {
            if (i == Player.NULL) {
                return false;
            }
        }
        return true;
    }

    private char PlayerToChar(Player player) {
        switch (player) {
            case X:
                return 'X';
            case O:
                return 'O';
            default:
                return ' ';
        }
    }

    private int userInput(Player player) {
        var input = -1;
        do {
            System.out.println("An welche Position soll das Zeichen? ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                System.out.println("Nur Zahlen eingeben");
                scanner.nextLine();
                continue;
            }
            if (input <= 0 || input > 9) {
                System.out.println("Nur Zahlen zwischen 1 und 9 eingeben");
                continue;
            }
            if (board[input - 1] != Player.NULL) {
                System.out.println("Der Platz ist schon belegt");
                continue;
            }
            break;

        } while (true);
        return input;
    }

    void show() {
        var index = 1;
        for (int i = 0; i < 7; i += 3) {
            for (int y = 0; y < 3; y++) {
                var mark = PlayerToChar(board[i + y]);
                if (mark == ' ') {
                    mark = (char) (index + '0'); // int to char
                }
                index++;
                System.out.print(mark);
                if (y < 2) {
                    System.out.print("|");
                }

            }
            System.out.println();
            if (i != 6) {
                System.out.println("-----");
            }
        }
    }

    void insert(int pos, Player player) {
        this.board[pos - 1] = player;
    }

    void insert(Player player) {
        insert(userInput(player), player);
    }

}
