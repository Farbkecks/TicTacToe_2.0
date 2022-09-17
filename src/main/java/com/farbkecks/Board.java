package com.farbkecks;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";
    /*
     * the board is saved in an 9 char array
     * there are only 'X', 'O', ' '
     */
    char[] list;
    int rating; // rates the board in dem MinMax algorithm
    String color1, color2, colorReset;
    final static Scanner scanner = new Scanner(System.in);

    private void setColor(boolean color) {
        if (color) {
            this.color1 = ANSI_BLUE;
            this.color2 = ANSI_RED;
            this.colorReset = ANSI_RESET;
        } else {
            this.color1 = "";
            this.color2 = "";
            this.colorReset = "";
        }
    }

    public Board(boolean color) {
        this.list = new char[9];
        Arrays.fill(list, ' ');
        setColor(color);
    }

    public Board(char[] oldList, boolean color) {
        setColor(color);
        char[] list = new char[9];
        System.arraycopy(oldList, 0, list, 0, oldList.length); // to get a deep copy of the list
        this.list = list;
    }

    void clearBoard() {
        Arrays.fill(list, ' '); // only used for testing
    }

    boolean checkForWin() {
        for (int i = 0; i < 3; i++) { // tests the 3 vertical lines
            if (list[0 + i] == list[3 + i] && list[3 + i] == list[6 + i]) {// tests if the symbols on the line are the
                                                                           // same
                if (list[0 + i] != ' ') {// tests if the lines is not only empty
                    return true;
                }
            }
        }
        for (int i = 0; i < 7; i += 3) { // tests the 3 horizontal lines
            if (list[0 + i] == list[1 + i] && list[1 + i] == list[2 + i]) {
                if (list[0 + i] != ' ') {
                    return true;
                }
            }
        }

        // tests the not straight lines
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
        int input;
        do {
            System.out.print("Spieler ");
            if (player == 'X') {
                System.out.print(color2 + player + colorReset);
            } else if (player == 'O') {
                System.out.print(color1 + player + colorReset);
            }
            System.out.println(" ist dran");

            System.out.println("An welche Position soll das Zeichen? ");
            if (scanner.hasNextInt()) { // scannes if it is an int
                input = scanner.nextInt();
            } else {
                System.out.println("Nur Zahlen eingeben"); // return if it check fails
                scanner.nextLine();
                continue;
            }
            if (input <= 0 || input > 9) { // checks if the int is on the board
                System.out.println("Nur Zahlen zwischen 1 und 9 eingeben");
                continue;
            }
            if (list[input - 1] == 'X' || list[input - 1] == 'O') { // checks if the place is free
                System.out.println("Der Platz ist schon belegt");
                continue;
            }
            break;

        } while (true);
        return input;
    }

    void show() {
        var index = 1; // for printing the numbers on the board
        for (int i = 0; i < 7; i += 3) { // the loob that goes horizontal
            for (int y = 0; y < 3; y++) { // the vertical loop
                var mark = list[i + y]; // get the char on this position
                if (mark == ' ') { // changes the char to the index if blank
                    mark = (char) (index + '0'); // int to char
                }
                index++;
                if (mark == 'X') {
                    System.out.print(color2 + mark + colorReset);
                } else if (mark == 'O') {
                    System.out.print(color1 + mark + colorReset);
                } else {
                    System.out.print(mark);
                }

                if (y < 2) { // puts the line only between the numbers
                    System.out.print("|");
                }

            }
            System.out.println();
            if (i != 6) { // puts the line only between the rows
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
