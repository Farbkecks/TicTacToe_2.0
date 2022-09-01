package com.farbkecks;

import java.util.ArrayList;
import java.util.Arrays;

public class MinMax {

    // generats every board that is with the next move possible
    static ArrayList<Board> getAllBoards(char[] listAbove, char player, boolean color) {
        var boards = new ArrayList<Board>();
        for (int i = 0; i < 9; i++) {
            if (listAbove[i] == ' ') {
                var newBoard = new Board(listAbove, color);
                newBoard.list[i] = player;
                boards.add(newBoard);
            }
        }
        return boards;
    }

    // starts the minmax function and converts the board to an index
    static int startMinMax(char[] list, char player, boolean color) {
        var board = minmax(list, player, 0, color);
        for (int i = 0; i < list.length; i++) {
            if (list[i] != board.list[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    // depth is only for debugging reasons
    static Board minmax(char[] listAbove, char player, int depth, boolean color) {
        var boards = getAllBoards(listAbove, player, color);

        // rats the board if win or even and if it es better for x
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

                // runs minmax with the board to get all boards that are possible from this
                // point on
                var newList = Arrays.copyOf(i.list, i.list.length);
                var resulted = minmax(newList, App.changePlayer(player), depth + 1, color);
                i.rating = resulted.rating;
            }
        }

        int index = 0;
        int direction = 1; // changes if it is a min or an max
        if (player == 'X') {
            direction = 1;
        }
        if (player == 'O') {
            direction = -1;
        }
        int hights = boards.get(0).rating * direction; // get a start
        for (int i = 1; i < boards.size(); i++) {
            if ((boards.get(i).rating * direction) > hights) {
                hights = boards.get(i).rating * direction;
                index = i;
            }
        }
        return boards.get(index); // returns the board with the hight rating
    }
}