package com.example.bowling;

import java.util.List;

public class Frame implements FrameScoreable {

    @Override
    public int getScore(List<Integer> rolls, int rollIndex) {
        int first = rolls.get(rollIndex);
        int second = FrameResolver.getSafe(rolls, rollIndex +1);

        if (FrameResolver.isStrike(rolls, rollIndex)) {
            // When Strike then add score 1 and score 2 from next Frame
            return 10 + FrameResolver.strikeBonus(rolls, rollIndex);

        } else if (FrameResolver.isSpare(rolls, rollIndex)) {
            // Spare get only first score from next Frame
            return 10 + FrameResolver.spareBonus(rolls, rollIndex);

        } else {
            //no bonus get scores
            return first + second;
        }
    }

    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex) {
        return rolls.get(rollIndex) == 10 ? 1 : 2;
    }
}
