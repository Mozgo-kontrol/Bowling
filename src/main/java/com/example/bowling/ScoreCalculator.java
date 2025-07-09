package com.example.bowling;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCalculator {
    private final Map<Integer, FrameScoreable> framesMap = new HashMap<>(10);
    private final FrameFactory frameFactory;

    public ScoreCalculator(FrameFactory frameFactory) {
        this.frameFactory = frameFactory;
    }

    public Map<Integer, FrameScoreable> calculateFramesScore(List<Integer> rolls) {
        int rollIndex = 0;
        int currentScore = 0;
        for (int frame = 1; frame <= 10 &&rollIndex < rolls.size(); frame++) {
            FrameScoreable frameObj = (frame == 10) ? new LastFrame() : frameFactory.getFrame(rolls, rollIndex);
            frameObj.calculateScore(rolls, rollIndex);
            rollIndex += frameObj.getAdvance(rolls, rollIndex);
            framesMap.put(frame, frameObj);
        }

        return framesMap;
    }

    public int calculateTotalScore(List<Integer> rolls) {
        return calculateFramesScore(rolls).values().stream()
                .map(frame -> (Parameterizable) frame)
                .map(Parameterizable::getScore).reduce(0, Integer::sum);
    }

}