package com.example.bowling;

import java.util.List;

public class SpareFrame extends Frame{

    @Override
    public int getScore(List<Integer> rolls, int rollIndex) {
        return  10 + FrameResolver.spareBonus(rolls, rollIndex);
    }

    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex) {
        return  rolls.get(rollIndex) == 10 ? 1 : 2;
    }
}
