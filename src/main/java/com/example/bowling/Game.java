package com.example.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
private final FrameFactory frameFactory = new FrameFactory();
    private final List<Integer> rolls = new ArrayList<>();
    private final ScoreCalculator calculator = new ScoreCalculator(frameFactory);

    public void roll(int pins) {
        rolls.add(pins);
    }

    public void printFrameScores() {
        List<Integer> scores = calculator.calculateFrameScores(rolls);
        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Frame " + (i + 1) + ": " + scores.get(i) + " points");
        }
    }

    public void printFramesWithScores() {
        Map<Integer, FrameScoreable> frames = calculator.calculateAndPrintFrameScores(rolls);
        printFrameScores(frames);
    }

    private void printFrameScores(Map<Integer, FrameScoreable> framesMap){
        framesMap.forEach((frameNumber, frame) -> {
            Parameterizable parameterizable = (Parameterizable) frame;
           System.out.println("Frame "+ frameNumber + " : " + parameterizable.getName()+ " : " + parameterizable.getScore()+" points");
        });
    }

    public int getScore() {
        return calculator.calculateTotalScore(rolls);
    }

    public boolean isFinished() {
        return calculator.calculateFrameScores(rolls).size() == 10;
    }

}
