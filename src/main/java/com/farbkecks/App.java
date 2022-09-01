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

        var towPlayer = false; // change for two or one player
        var color = true; // show board with color
        // doesn't work with some terminals

        var board = new Board(color);
        var player = 'X';
        var computerPlaysNot = true;
        while (board.checkForEve() == false && board.checkForWin() == false) { // ends gameloop when even or a win
            // gameloop if the player plays
            if (computerPlaysNot) {
                board.show();
                board.insert(player);
                player = changePlayer(player);
                if (towPlayer == false) {
                    computerPlaysNot = false;
                }
            } else { // gameloop if the pc plays
                var index = MinMax.startMinMax(board.list, player, color);
                board.insert(index, player);
                player = changePlayer(player);
                computerPlaysNot = true;
            }
        }
        board.show();
        player = changePlayer(player);
        if (board.checkForWin()) {
            System.out.print(player);
            System.out.println(" hatt gewonne");
        } else {
            System.out.println("keiner hat Gewonnen");
        }
    }
}
