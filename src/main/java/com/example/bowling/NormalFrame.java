package com.example.bowling;

import java.util.List;

public class NormalFrame extends Frame {

    public NormalFrame(){
        super.setName("Normal");
    }
    @Override
    public void calculateScore(List<Integer> rolls, int rollIndex) {
        int first = rolls.get(rollIndex);
        int second = Tools.getSafe(rolls, rollIndex + 1);
        super.setScore(first + second);
    }
}
