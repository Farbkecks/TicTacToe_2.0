package com.farbkecks;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testEven() {
        var board = new Board();
        for (int i = 1; i < 9; i++) {
            board.insert(i, Player.X);
        }
        assertEquals(false, board.checkForEve());
        board.insert(9, Player.X);
        assertTrue(board.checkForEve());
    }

    @Test
    public void testInsert() {
        var testBoard = new Board();
        testBoard.insert(2, Player.X);
        assertArrayEquals(getTestBoard("0X00000000"), testBoard.list);
        testBoard.insert(1, Player.O);
        assertArrayEquals(getTestBoard("OX00000000"), testBoard.list);
    }

    /*
     * 1 | 2 | 3
     * ---------
     * 4 | 5 | 6
     * ---------
     * 7 | 8 | 9
     */

    @Test
    public void testCheckWin() {
        var board = new Board();
        board.insert(1, Player.X);
        board.insert(5, Player.X);
        board.insert(9, Player.X);
        assertTrue(board.checkForWin());
        board.clearBoard();

        board.insert(3, Player.X);
        board.insert(5, Player.X);
        board.insert(7, Player.X);
        assertTrue(board.checkForWin());
        board.clearBoard();

        board.insert(1, Player.X);
        board.insert(5, Player.X);
        board.insert(7, Player.X);
        assertEquals(false, board.checkForWin());
        board.clearBoard();

        board.insert(2, Player.X);
        board.insert(5, Player.X);
        board.insert(8, Player.X);
        assertTrue(board.checkForWin());
        board.clearBoard();

        board.insert(7, Player.X);
        board.insert(8, Player.X);
        board.insert(9, Player.X);
        assertTrue(board.checkForWin());
        board.clearBoard();

    }
}
