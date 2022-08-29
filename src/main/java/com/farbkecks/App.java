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

    public static void main(String[] args) {
        var board = new Board();
        board.show();
        board.insert(getUserInputAsInt(), Player.X);
        board.show();
    }
}
