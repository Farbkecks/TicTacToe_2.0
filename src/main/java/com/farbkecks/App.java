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

    public static void main(String[] args) {
        var board = new Board();
        var player = 'X';
        while (board.checkForEve() == false && board.checkForWin() == false) {
            board.show();
            board.insert(player);
            player = changePlayer(player);
        }
        board.show();
        player = changePlayer(player);
        System.out.print(player);
        System.out.println(" hatt gewonne");
    }
}
