package com.example.bowling;

import java.util.List;

public class LastFrame implements Scoreable{

    @Override
    public int getScore(List<Integer> rolls, int rollIndex) {

        int score = rolls.get(rollIndex) + rolls.get(rollIndex + 1);
        // add bonus roll only if Spare oder Strike
        if (rollIndex + 2 < rolls.size() && (rolls.get(rollIndex) == 10 || rolls.get(rollIndex) + rolls.get(rollIndex + 1) == 10)) {
            score += rolls.get(rollIndex + 2);
        }

        return score;
    }

    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex) {
        // Always consume 2 rolls
        // Add 1 more if strike or spare
        if (rolls.get(rollIndex) == 10 || rolls.get(rollIndex) + rolls.get(rollIndex + 1) == 10) {
            return 3;
        }
        return 2;
    }
}
