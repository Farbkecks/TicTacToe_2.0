package com.farbkecks;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    Player[] list;
    int rating;
    final static Scanner scanner = new Scanner(System.in);

    public Board() {
        this.list = new Player[9];
        Arrays.fill(list, Player.NULL);
    }

    public Board(Player[] oldList) {
        this.rating = 0;
        var list = Arrays.copyOf(oldList, oldList.length);
        this.list = list;
    }

    void clearBoard() {
        Arrays.fill(list, Player.NULL);
    }

    boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (list[0 + i] == list[3 + i] && list[3 + i] == list[6 + i]) {
                if (list[0 + i] != Player.NULL) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 7; i += 3) {
            if (list[0 + i] == list[1 + i] && list[1 + i] == list[2 + i]) {
                if (list[0 + i] != Player.NULL) {
                    return true;
                }
            }
        }
        if (list[0] == list[4] && list[4] == list[8]) {
            if (list[0] != Player.NULL) {
                return true;
            }
        }
        if (list[6] == list[4] && list[4] == list[2]) {
            if (list[6] != Player.NULL) {
                return true;
            }
        }

        return false;
    }

    boolean checkForEve() {
        for (Player i : list) {
            if (i == Player.NULL) {
                return false;
            }
        }
        return true;
    }

    private char PlayerToChar(Player player) {
        switch (player) {
            case X:
                return 'X';
            case O:
                return 'O';
            default:
                return ' ';
        }
    }

    private int userInput(Player player) {
        var input = -1;
        do {
            System.out.print("Spieler ");
            System.out.print(player);
            System.out.println(" ist dran");
            System.out.println("An welche Position soll das Zeichen? ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                System.out.println("Nur Zahlen eingeben");
                scanner.nextLine();
                continue;
            }
            if (input <= 0 || input > 9) {
                System.out.println("Nur Zahlen zwischen 1 und 9 eingeben");
                continue;
            }
            if (list[input - 1] != Player.NULL) {
                System.out.println("Der Platz ist schon belegt");
                continue;
            }
            break;

        } while (true);
        return input;
    }

    // void show() {
    // var index = 1;
    // for (int i = 0; i < 7; i += 3) {
    // for (int y = 0; y < 3; y++) {
    // var mark = PlayerToChar(list[i + y]);
    // if (mark == ' ') {
    // mark = (char) (index + '0'); // int to char
    // }
    // index++;
    // System.out.print(mark);
    // if (y < 2) {
    // System.out.print("|");
    // }

    // }
    // System.out.println();
    // if (i != 6) {
    // System.out.println("-----");
    // }
    // }
    // }

    void show() {
        for (int i = 0; i < 7; i += 3) {
            System.out.print(PlayerToChar(list[i]));
            System.out.print("|");
            System.out.print(PlayerToChar(list[i + 1]));
            System.out.print("|");
            System.out.print(PlayerToChar(list[i + 2]));
            System.out.println();
            if (i != 6) {
                System.out.println("-----");
            }
        }
    }

    void insert(int pos, Player player) {
        this.list[pos - 1] = player;
    }

    void insert(Player player) {
        insert(userInput(player), player);
    }

}
