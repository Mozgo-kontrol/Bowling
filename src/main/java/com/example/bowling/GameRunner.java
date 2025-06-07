package com.example.bowling;

public class GameRunner {
    public static void main(String[] args) {

        // test data 1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6 -> 133
        int [] input = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};

        Game game = new Game();
        for (int j : input) {
            game.roll(j);
        }

        System.out.println("Game result: " + game.getScore());
    }
}