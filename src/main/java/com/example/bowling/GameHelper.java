package com.example.bowling;

import java.util.List;

public class GameHelper {

    public static boolean isStrike(List<Integer> rolls, int i) {
        return i < rolls.size() && rolls.get(i) == 10;
    }

    public static boolean isSpare(List<Integer> rolls, int i) {
        return i + 1 < rolls.size() && rolls.get(i) + rolls.get(i + 1) == 10;
    }
    public static int spareBonus(List<Integer> rolls, int i) {
        return getSafe(rolls, i + 2);
    }
    public static int strikeBonus(List<Integer> rolls, int i) {
        return getSafe(rolls, i + 1) + getSafe(rolls, i + 2);
    }

    private static int getSafe(List<Integer> rolls, int index) {
        return (index < rolls.size()) ? rolls.get(index) : 0;
    }
}
