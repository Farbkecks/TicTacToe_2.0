package com.farbkecks;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    char[] list;
    int rating;
    final static Scanner scanner = new Scanner(System.in);

    public Board() {
        this.list = new char[9];
        Arrays.fill(list, ' ');
        System.out.println("sdfsdf");
    }

    public Board(char[] oldList) {
        this.rating = 0;
        char[] list = new char[9];
        System.arraycopy(oldList, 0, list, 0, oldList.length);
        this.list = list;
    }

    void clearBoard() {
        Arrays.fill(list, ' ');
    }

    boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (list[0 + i] == list[3 + i] && list[3 + i] == list[6 + i]) {
                if (list[0 + i] != ' ') {
                    return true;
                }
            }
        }
        for (int i = 0; i < 7; i += 3) {
            if (list[0 + i] == list[1 + i] && list[1 + i] == list[2 + i]) {
                if (list[0 + i] != ' ') {
                    return true;
                }
            }
        }
        if (list[0] == list[4] && list[4] == list[8]) {
            if (list[0] != ' ') {
                return true;
            }
        }
        if (list[6] == list[4] && list[4] == list[2]) {
            if (list[6] != ' ') {
                return true;
            }
        }

        return false;
    }

    boolean checkForEve() {
        for (char i : list) {
            if (i == ' ') {
                return false;
            }
        }
        return true;
    }

    private int userInput(char player) {
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
            if (list[input - 1] == 'X' || list[input - 1] == 'O') {
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
            System.out.print(list[i]);
            System.out.print("|");
            System.out.print(list[i + 1]);
            System.out.print("|");
            System.out.print(list[i + 2]);
            System.out.println();
            if (i != 6) {
                System.out.println("-----");
            }
        }
    }

    void insert(int pos, char player) {
        this.list[pos - 1] = player;
    }

    void insert(char player) {
        insert(userInput(player), player);
    }

}
