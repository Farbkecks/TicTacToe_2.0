package com.farbkecks;

enum Player {
    X,
    O,
    NULL
}

public class App {

    private static Player changePlayer(Player player) {
        switch (player) {
            case X:
                return Player.O;
            case O:
                return Player.X;
            default:
                return Player.NULL;
        }
    }

    public static void main(String[] args) {
        var board = new Board();
        var player = Player.X;
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
