package com.example.bowling;

import java.util.List;

public class Tools {
    public static int getSafe(List<Integer> rolls, int index) {
        return (index < rolls.size()) ? rolls.get(index) : 0;
    }
    public static boolean isStrike(List<Integer> rolls, int i) {
        return i < rolls.size() && rolls.get(i) == 10;
    }

    public static boolean isSpare(List<Integer> rolls, int i) {
        return i + 1 < rolls.size() && rolls.get(i) + rolls.get(i + 1) == 10;
    }
}
