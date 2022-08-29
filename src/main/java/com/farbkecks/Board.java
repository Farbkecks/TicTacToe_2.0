package com.farbkecks;

import java.util.Arrays;

public class Board {

    Player[] board;

    public Board() {
        this.board = new Player[9];
        Arrays.fill(board, Player.NULL);
    }

    static char PlayerToChar(Player player) {
        switch (player) {
            case X:
                return 'X';
            case O:
                return 'O';
            default:
                return ' ';
        }
    }

    public void show() {
        for (int i = 0; i < 7; i += 3) {
            System.out.print(PlayerToChar(board[i]));
            System.out.print("|");
            System.out.print(PlayerToChar(board[i + 1]));
            System.out.print("|");
            System.out.print(PlayerToChar(board[i + 2]));
            System.out.println();
            if (i != 6) {
                System.out.println("-----");
            }
        }
    }

    public void insert(int pos, Player player) {
        this.board[pos - 1] = player;
    }

}
