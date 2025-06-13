package com.example.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreCalculator {

    public List<Integer> calculateFrameScores(List<Integer> rolls) {
        List<Integer> frameScores = new ArrayList<>();

        int rollIndex = 0;
        int currentScore = 0;
        for (int frame = 1; frame <= 10 &&rollIndex < rolls.size(); frame++) {
            FrameScoreable frameLogic = (frame == 10) ? new LastFrame() : new Frame();
            currentScore = frameLogic.getScore(rolls, rollIndex);
            rollIndex += frameLogic.getAdvance(rolls, rollIndex);
            frameScores.add(currentScore);
        }

        return frameScores;
    }

    public int calculateTotalScore(List<Integer> rolls) {
        List<Integer> frames = calculateFrameScores(rolls);
        return frames.isEmpty() ? 0 : frames.stream().reduce(0, Integer::sum);
    }
}