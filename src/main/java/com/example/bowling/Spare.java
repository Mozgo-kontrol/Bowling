package com.example.bowling;

import java.util.List;

public class Spare extends Frame{

    public Spare(){
        super.setName("Spare");
    }

    @Override
    public void calculateScore(List<Integer> rolls, int rollIndex) {
        int score = 10 + Tools.getSafe(rolls, rollIndex + 2);
        super.setScore(score);
    }
    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex){
        return rolls.get(rollIndex) == 10 ? 1 : 2;
    }
}
