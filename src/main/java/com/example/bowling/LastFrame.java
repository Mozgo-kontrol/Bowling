package com.example.bowling;

import java.util.List;

public class LastFrame implements FrameScoreable, Parameterizable {
     private String name;
     private int score;

     public LastFrame(){
         this.name = "Last";
     }

    @Override
    public void calculateScore(List<Integer> rolls, int rollIndex) {
        int score = rolls.get(rollIndex) + rolls.get(rollIndex + 1);
        // add bonus roll only if Spare oder Strike
        if ((Tools.isStrike(rolls,rollIndex) || Tools.isSpare(rolls,rollIndex))) {
            score += rolls.get(rollIndex + 2);
        }
        this.score = score;
    }

    @Override
    public int getAdvance(List<Integer> rolls, int rollIndex) {
        // Always consume 2 rolls
        // Add 1 more if strike or spare
        if (Tools.isStrike(rolls, rollIndex) || Tools.isSpare(rolls, rollIndex)) {
            return 3;
        }
        return 2;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {

    }
}
