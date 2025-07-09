package com.example.bowling;

import java.util.List;

public class StrikeFrame extends Frame {

    @Override
    public int getScore(List<Integer> rolls, int rollIndex) {
        return 10 + FrameResolver.strikeBonus(rolls, rollIndex);
    }

    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex) {
        return rolls.get(rollIndex) == 10 ? 1 : 2;
    }
}
