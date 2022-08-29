package com.farbkecks;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BoardTest {
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

    @Test
    public void testInsert() {
        var testBoard = new Board();
        testBoard.insert(1, Player.X);
        assertArrayEquals(getTestBoard("0X00000000"), testBoard.board);
        testBoard.insert(0, Player.O);
        assertArrayEquals(getTestBoard("OX00000000"), testBoard.board);
    }
}
