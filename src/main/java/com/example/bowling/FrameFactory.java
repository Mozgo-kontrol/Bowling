package com.example.bowling;

import java.util.List;

public class FrameFactory {

    public Frame getFrame(List<Integer> rolls, int rollIndex) {

        if (FrameResolver.isStrike(rolls, rollIndex)) {
            // When Strike then add score 1 and score 2 from next Frame
            return new StrikeFrame();

        } else if (FrameResolver.isSpare(rolls, rollIndex)) {
            // Spare get only first score from next Frame
            return new SpareFrame();

        } else {
            //no bonus get scores
            return new NormalFrame();
        }
    }
}
