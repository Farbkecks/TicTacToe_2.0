package com.farbkecks;

public class PrivateTesting {
    static Player CharToPlayer(char cha) {
        switch (cha) {
            case 'X':
                return Player.X;
            case 'O':
                return Player.O;
            default:
                return Player.NULL;
        }
    }

    static Player[] getTestBoard(String input) {
        var testBoard = new Player[9];
        char[] charInput = input.toCharArray();
        for (int i = 0; i < testBoard.length; i++) {
            testBoard[i] = CharToPlayer(charInput[i]);
        }
        return testBoard;

    }

    public static void main(String[] args) {
        var board = new Board(getTestBoard("XOO X X O"));
        board.show();
        System.out.println("-----------------");
        var x = MinMax.minmax(board, Player.X);
        x.show();
    }
}
