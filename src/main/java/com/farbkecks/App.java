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
        var computerPlaysNot = true;
        while (board.checkForEve() == false && board.checkForWin() == false) {
            if (computerPlaysNot) {
                board.show();
                board.insert(player);
                player = changePlayer(player);
                computerPlaysNot = false;
            } else {
                var index = MinMax.startMinMax(board.list, player);
                board.insert(index, player);
                player = changePlayer(player);
                computerPlaysNot = true;
            }
        }
        board.show();
        player = changePlayer(player);
        System.out.print(player);
        System.out.println(" hatt gewonne");
    }
}
