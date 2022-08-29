package com.farbkecks;

import java.util.Scanner;

enum Player {
    X,
    O,
    NULL
}

public class App {

    private static int getUserInputAsInt() {
        var scanner = new Scanner(System.in);
        var input = -1;

        do {
            System.out.println("An welche Position soll das Zeichen? ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                System.out.println("Nur Zahlen eingeben");
                scanner.nextLine();
                continue;
            }
            if (input >= 0 && input < 9) {
                break;
            }
            System.out.println("Nur Zahlen zwischen 1 und 9 eingeben");

        } while (true);
        scanner.close();
        return input;
    }

    private static Player changePlayer(Player player) {
        switch (player) {
            case X:
                return Player.O;
            case O:
                return Player.X;
            default:
                return Player.NULL;
        }
    }

    public static void main(String[] args) {
        var board = new Board();
        board.insert(2, Player.X);
        board.insert(5, Player.X);
        board.insert(9, Player.X);
        board.show();
        System.out.println(board.checkForWin());
    }
}
