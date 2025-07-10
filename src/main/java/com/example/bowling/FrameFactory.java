package com.example.bowling;

import java.util.List;

public class FrameFactory {

    public Frame getFrame(List<Integer> rolls, int rollIndex, boolean isLastRoll) {
        if(isLastRoll) {
            return new Last();
        }
        else if (Tools.isStrike(rolls, rollIndex)) {
            // When Strike then add score 1 and score 2 from next Frame
            return new Strike();

        } else if (Tools.isSpare(rolls, rollIndex)) {
            // Spare get only first score from next Frame
            return new Spare();

        } else {
            //no bonus get scores
            return new Regular();
        }
    }
}
