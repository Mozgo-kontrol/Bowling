package com.example.bowling;

import java.util.List;

public interface FrameScoreable {
    void calculateScore(List<Integer> rolls, int rollIndex);
    int getAdvance(List<Integer> rolls, int rollIndex);
}
