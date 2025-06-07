package com.example.bowling;

import java.util.List;

public class Frame implements Scoreable {

    @Override
    public int getScore(List<Integer> rolls, int rollIndex) {
        int first = rolls.get(rollIndex);
        int second = rolls.get(rollIndex + 1);

        if (first == 10) {
            // When Strike then add score 1 and score 2 from next Frame
            return 10 + rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);

        } else if (first + second == 10) {

            // Spare get only first score from next Frame
            return 10 + rolls.get(rollIndex + 2);

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
