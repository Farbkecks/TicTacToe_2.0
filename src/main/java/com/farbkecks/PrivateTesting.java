package com.farbkecks;

public class PrivateTesting {

    static char[] getTestBoardFromString(String input) {
        var testBoard = new char[9];
        char[] charInput = input.toCharArray();
        for (int i = 0; i < testBoard.length; i++) {
            testBoard[i] = charInput[i];
        }
        return testBoard;

    }

    // testing the MinMax function
    public static void main(String[] args) {
        var board = new Board(getTestBoardFromString("XOXOOX X "));
        board.show();
        System.out.println("-----------------");
        var x = MinMax.minmax(board.list, 'O', 1);
        x.show();
    }
}
