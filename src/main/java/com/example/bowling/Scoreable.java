package com.example.bowling;

import java.util.List;

public interface Scoreable {
    void setName(String name);
    void setScore(int score);
    int getScore();
    String getName();
    void calculateScore(List<Integer> rolls, int rollIndex);
    int getAdvance(List<Integer> rolls, int rollIndex);
}
