package com.example.bowling;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎳 Welcome to Bowling Game Scorer!");
        System.out.println("Enter your rolls (0–10). Type ENTER with no input to finish.");

        while (true) {
            if (game.isFinished()) {
               System.out.println("🎯 All 10 frames completed.");
                break;
            }
            // test data 1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6 -> 133

            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;

            String[] tokens = input.split("\\s+");
            for (String token : tokens) {
                try {
                    int pins = Integer.parseInt(token);
                    if (pins < 0 || pins > 10) {
                        System.out.println("⚠️ Invalid pin count: " + pins);
                    } else {
                        game.roll(pins);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input: '" + token + "'");
                }
            }
            game.printFrameScores();
        }

        System.out.println("🏁 Final Score: " + game.getScore());








        // test data 1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6 -> 133
        int [] input = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};

       // Game game = new Game();
       // for (int j : input) {
      //      game.roll(j);
     //   }

       // System.out.println("Game result: " + game.getScore());
    }
}