package com.example.bowling;

import java.util.List;

public abstract class Frame implements FrameScoreable, Parameterizable{
   private String name;
   private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore(){
        return  score;
    }
    public void setScore(int score){
        this.score = score;
    }

    public int getAdvance(List<Integer> rolls, int rollIndex){
        return rolls.get(rollIndex) == 10 ? 1 : 2;
    }
}
