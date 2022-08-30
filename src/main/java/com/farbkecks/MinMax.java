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

    static Board minmax(Board boardAbove, Player player) {
        var boards = getAllBoards(boardAbove, player);
        for (Board i : boards) {
            if (i.checkForEve()) {
                i.rating = 0;
            } else if (i.checkForWin()) {
                if (Player.O == player) {
                    i.rating = -1;
                } else if (Player.X == player) {
                    i.rating = 1;
                }
            } else {
                var resulte = minmax(new Board(i.list), App.changePlayer(player));
                i.rating = resulte.rating;
            }
        }
        int index = 0;
        int direction = 1;
        if (player == Player.X) {
            direction = 1;
        }
        if (player == Player.O) {
            direction = -1;
        }
        int highst = boards.get(0).rating * direction;
        for (int i = 1; i < boards.size(); i++) {
            if ((boards.get(i).rating * direction) < highst) {
                highst = boards.get(i).rating * direction;
                index = i;
            }
        }
        return boards.get(index);
    }
}