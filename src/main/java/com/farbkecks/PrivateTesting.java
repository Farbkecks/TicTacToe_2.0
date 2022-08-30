package com.farbkecks;

public class PrivateTesting {

    static char[] getTestBoard(String input) {
        var testBoard = new char[9];
        char[] charInput = input.toCharArray();
        for (int i = 0; i < testBoard.length; i++) {
            testBoard[i] = charInput[i];
        }
        return testBoard;

    }

    public static void main(String[] args) {
        var board = new Board(getTestBoard("XOO X X O"));
        board.show();
        System.out.println("-----------------");
        var x = MinMax.minmax(board, 'X');
        x.show();
    }
}
