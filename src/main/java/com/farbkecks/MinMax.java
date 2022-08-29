package com.farbkecks;

import java.util.ArrayList;

public class MinMax {

    static ArrayList<Board> getAllBoards(Board boardAbove, Player player) {
        var boards = new ArrayList<Board>();
        for (int i = 0; i < 9; i++) {
            if (boardAbove.list[i] == Player.NULL) {
                var newBoard = new Board(boardAbove.list);
                newBoard.list[i] = player;
                boards.add(newBoard);
            }
        }
        return boards;
    }

    static void minmax(Board boardAbove, Player player) {
        var boards = getAllBoards(boardAbove, player);
        System.out.print("sdjkflsdf");
    }
}