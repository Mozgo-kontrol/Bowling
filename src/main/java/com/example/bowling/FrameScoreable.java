package com.example.bowling;

import java.util.List;

public interface FrameScoreable {
    int getScore(List<Integer> rolls, int rollIndex);
    int getAdvance(List<Integer> rolls, int rollIndex);
}
