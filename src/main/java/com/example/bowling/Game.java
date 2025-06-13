package com.example.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> rolls = new ArrayList<>();
    private final ScoreCalculator calculator = new ScoreCalculator();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public void printFrameScores() {
        List<Integer> scores = calculator.calculateFrameScores(rolls);
        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Frame " + (i + 1) + ": " + scores.get(i) + " points");
        }
    }

    public int getScore() {
        return calculator.calculateTotalScore(rolls);
    }

    public boolean isFinished() {
        return calculator.calculateFrameScores(rolls).size() == 10;
    }

}
