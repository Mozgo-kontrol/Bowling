package com.example.bowling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCalculator {
    private final Map<Integer, Scoreable> cachedFrames = new HashMap<>(10);
    private final FrameFactory frameFactory;

    public ScoreCalculator(FrameFactory frameFactory) {
        this.frameFactory = frameFactory;
    }

    public Map<Integer, Scoreable> calculateFramesScore(List<Integer> rolls) {
        int rollIndex = 0;
        for (int frame = 1; frame <= 10 &&rollIndex < rolls.size(); frame++) {
            boolean isLastRoll = frame == 10;
            Scoreable frameObj = frameFactory.getFrame(rolls, rollIndex, isLastRoll);
            frameObj.calculateScore(rolls, rollIndex);
            rollIndex += frameObj.getAdvance(rolls, rollIndex);
            cachedFrames.put(frame, frameObj);
        }

        return cachedFrames;
    }

    public int calculateTotalScore(List<Integer> rolls) {
        return calculateFramesScore(rolls).values().stream()
                .map(Scoreable::getScore)
                .reduce(0, Integer::sum);

    }

}