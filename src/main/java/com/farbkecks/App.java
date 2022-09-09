package com.farbkecks;

public class App {

    static char changePlayer(char player) {
        switch (player) {
            case 'X':
                return 'O';
            case 'O':
                return 'X';
            default:
                return ' ';
        }
    }

    private static void gameloopOnePlayer(Board board, char player) {
        while (true) {
            board.show();
            board.insert(player);
            if (board.checkForEve() || board.checkForWin()) {
                break;
            }
            player = changePlayer(player);
            var index = MinMax.startMinMax(board.list, player);
            board.insert(index, player);
            if (board.checkForEve() || board.checkForWin()) {
                break;
            }
            player = changePlayer(player);
        }
    }

    private static void gameloopTwoPlayer(Board board, char player) {
        while (true) {
            board.show();
            board.insert(player);
            if (board.checkForEve() || board.checkForWin()) {
                break;
            }
            player = changePlayer(player);
        }
    }

    public static void main(String[] args) {
        var towPlayer = false; // change for two or one player
        var color = true; // show board with color
        // doesn't work with some terminals

        // get the info from the args
        for (String i : args) {
            if (i.equals("color")) {
                color = false;
            } else if (i.equals("two")) {
                towPlayer = true;
            } else {
                System.out.println("color - disables the color on the board");
                System.out.println("two - enables the input from two players");
                System.out.println();
                break;
            }
        }

        var board = new Board(color);
        var player = 'X';

        if (towPlayer) {
            gameloopTwoPlayer(board, player);
        } else {
            gameloopOnePlayer(board, player);
        }
        player = changePlayer(player);
        board.show();
        if (board.checkForWin()) {
            System.out.println(player + " hatt gewonne");
        } else {
            System.out.println("keiner hat Gewonnen");
        }
    }
}
