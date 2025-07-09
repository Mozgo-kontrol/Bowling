package com.example.bowling;

import java.util.List;

public class NormalFrame extends Frame {

    @Override
    public int getScore(List<Integer> rolls, int rollIndex) {
        int first = rolls.get(rollIndex);
        int second = FrameResolver.getSafe(rolls, rollIndex +1);
        return first + second;
    }


    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex) {
        return rolls.get(rollIndex) == 10 ? 1 : 2;
    }
}
