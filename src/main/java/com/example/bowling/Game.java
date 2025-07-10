package com.example.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    private final List<Integer> rolls = new ArrayList<>();
    private final ScoreCalculator calculator;

    public Game(ScoreCalculator calculator){
        this.calculator = calculator;
    }
    public void roll(int pins) {
        rolls.add(pins);
    }

    public void printFramesWithScores() {
        Map<Integer, Scoreable> frames = calculator.calculateFramesScore(rolls);
        printFrameScores(frames);
    }

    private void printFrameScores(Map<Integer, Scoreable> frames){
        new ScorePrinter().print(frames);
    }

    public int getScore() {
        return calculator.calculateTotalScore(rolls);
    }

    public boolean isFinished() {
        return calculator.calculateFramesScore(rolls).size() == 10;
    }

}
