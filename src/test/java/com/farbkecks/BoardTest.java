package com.farbkecks;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    static char[] getTestBoard(String input) {
        var testBoard = new char[9];
        char[] charInput = input.toCharArray();
        for (int i = 0; i < testBoard.length; i++) {
            testBoard[i] = charInput[i];
        }
        return testBoard;

    }

    @Test
    public void testEven() {
        var board = new Board();
        for (int i = 1; i < 9; i++) {
            board.insert(i, 'X');
        }
        assertEquals(false, board.checkForEve());
        board.insert(9, 'X');
        assertTrue(board.checkForEve());
    }

    @Test
    public void testInsert() {
        var testBoard = new Board();
        testBoard.insert(2, 'X');
        assertArrayEquals(getTestBoard(" X       "), testBoard.list);
        testBoard.insert(1, 'O');
        assertArrayEquals(getTestBoard("OX       "), testBoard.list);
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
        board.insert(1, 'X');
        board.insert(5, 'X');
        board.insert(9, 'X');
        assertTrue(board.checkForWin());
        board.clearBoard();

        board.insert(3, 'X');
        board.insert(5, 'X');
        board.insert(7, 'X');
        assertTrue(board.checkForWin());
        board.clearBoard();

        board.insert(1, 'X');
        board.insert(5, 'X');
        board.insert(7, 'X');
        assertEquals(false, board.checkForWin());
        board.clearBoard();

        board.insert(2, 'X');
        board.insert(5, 'X');
        board.insert(8, 'X');
        assertTrue(board.checkForWin());
        board.clearBoard();

        board.insert(3, 'X');
        board.insert(6, 'X');
        board.insert(9, 'X');
        assertTrue(board.checkForWin());
        board.clearBoard();

        board.insert(7, 'X');
        board.insert(8, 'X');
        board.insert(9, 'X');
        assertTrue(board.checkForWin());
        board.clearBoard();

    }
}
