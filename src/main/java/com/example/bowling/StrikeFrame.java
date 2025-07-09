package com.example.bowling;

import java.util.List;

public class StrikeFrame extends Frame {

    public StrikeFrame(){
        super.setName("Strike");
    }

    @Override
    public void calculateScore(List<Integer> rolls, int rollIndex) {
        int score = 10 + Tools.getSafe(rolls, rollIndex + 1) + Tools.getSafe(rolls, rollIndex + 2);
        super.setScore(score);
    }
}
