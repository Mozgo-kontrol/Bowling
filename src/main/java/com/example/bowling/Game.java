package com.example.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int getScore() {
        int total = 0;
        int rollIndex = 0;
        for (int frame = 1; frame <= 10; frame++) {
            Scoreable frameLogic = (frame == 10) ? new LastFrame() : new Frame();
            total += frameLogic.getScore(rolls, rollIndex);
            rollIndex += frameLogic.getAdvance(rolls, rollIndex);
        }
        return total;
    }

}
