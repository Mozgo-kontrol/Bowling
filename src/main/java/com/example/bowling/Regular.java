package com.example.bowling;

import java.util.List;

public class Regular extends Frame {

    public Regular(){
        this.setName("Normal");
    }
    @Override
    public void calculateScore(List<Integer> rolls, int rollIndex) {
        int first = rolls.get(rollIndex);
        int second = Tools.getSafe(rolls, rollIndex + 1);
        super.setScore(first + second);
    }

    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex){
        return rolls.get(rollIndex) == 10 ? 1 : 2;
    }
}
