package com.example.bowling;

import java.util.Map;

public class ScorePrinter {
    public void print(Map<Integer, Scoreable> frames) {
        frames.forEach((frameNumber, frame) -> {
            System.out.println("Frame "+ frameNumber + " : " + frame.getName()+ " : " +frame.getScore()+" points");
        });
    }
}
