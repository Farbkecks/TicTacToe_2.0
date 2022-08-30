package com.farbkecks;

import java.util.ArrayList;
import java.util.Arrays;

public class MinMax {

    static ArrayList<Board> getAllBoards(char[] listAbove, char player) {
        var boards = new ArrayList<Board>();
        for (int i = 0; i < 9; i++) {
            if (listAbove[i] == ' ') {
                var newBoard = new Board(listAbove);
                newBoard.list[i] = player;
                boards.add(newBoard);
            }
        }
        return boards;
    }

    static int startMinMax(char[] list, char player) {
        var board = minmax(list, player, 0);
        for (int i = 0; i < list.length; i++) {
            if (list[i] != board.list[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    static Board minmax(char[] listAbove, char player, int depth) {
        var boards = getAllBoards(listAbove, player);
        for (Board i : boards) {
            if (i.checkForWin()) {
                if ('O' == player) {
                    i.rating = -1;
                } else if ('X' == player) {
                    i.rating = 1;
                }
            } else if (i.checkForEve()) {
                i.rating = 0;
            } else {
                var newList = Arrays.copyOf(i.list, i.list.length);
                var resulte = minmax(newList, App.changePlayer(player), depth + 1);
                i.rating = resulte.rating;
            }
        }

        int index = 0;
        int direction = 1;
        if (player == 'X') {
            direction = 1;
        }
        if (player == 'O') {
            direction = -1;
        }
        int highst = boards.get(0).rating * direction;
        for (int i = 1; i < boards.size(); i++) {
            if ((boards.get(i).rating * direction) > highst) {
                highst = boards.get(i).rating * direction;
                index = i;
            }
        }
        return boards.get(index);
    }
}