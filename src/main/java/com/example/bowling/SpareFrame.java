package com.example.bowling;

import java.util.List;

public class SpareFrame extends Frame{

    public SpareFrame(){
        super.setName("Spare");
    }

    @Override
    public void calculateScore(List<Integer> rolls, int rollIndex) {
        int score = 10 + Tools.getSafe(rolls, rollIndex + 2);
        super.setScore(score);
    }
}
