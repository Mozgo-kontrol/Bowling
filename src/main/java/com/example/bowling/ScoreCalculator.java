package com.example.bowling;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCalculator {
    private final Map<Integer, FrameScoreable> framesMap = new HashMap<>(10);
    private final FrameFactory frameFactory;
    public ScoreCalculator(FrameFactory frameFactory) {
        this.frameFactory = frameFactory;
    }

    public List<Integer> calculateFrameScores(List<Integer> rolls) {
        List<Integer> frameScores = new ArrayList<>();

        int rollIndex = 0;
        int currentScore = 0;
        for (int frame = 1; frame <= 10 &&rollIndex < rolls.size(); frame++) {
            FrameScoreable frameObj = (frame == 10) ? new LastFrame() : frameFactory.getFrame(rolls, rollIndex);
            currentScore = frameObj.getScore(rolls, rollIndex);
            rollIndex += frameObj.getAdvance(rolls, rollIndex);
            frameScores.add(currentScore);

            ((Parameterizable) frameObj).setName(initFrameName(frameObj));
            ((Parameterizable) frameObj).setScore(currentScore);
            framesMap.put(frame, frameObj);
        }

        return frameScores;
    }

    public Map<Integer, FrameScoreable> calculateAndPrintFrameScores(List<Integer> rolls) {
        List<Integer> frameScores = new ArrayList<>();

        int rollIndex = 0;
        int currentScore = 0;
        for (int frame = 1; frame <= 10 &&rollIndex < rolls.size(); frame++) {
            FrameScoreable frameObj = (frame == 10) ? new LastFrame() : frameFactory.getFrame(rolls, rollIndex);
            currentScore = frameObj.getScore(rolls, rollIndex);
            rollIndex += frameObj.getAdvance(rolls, rollIndex);
            frameScores.add(currentScore);

            ((Parameterizable) frameObj).setName(initFrameName(frameObj));
            ((Parameterizable) frameObj).setScore(currentScore);
            framesMap.put(frame, frameObj);
        }

        return framesMap;
    }


    public String initFrameName(FrameScoreable frame){
        return  switch (frame){
            case StrikeFrame ignored ->  "Strike" ;
            case SpareFrame ignored ->  "Spare" ;
            case LastFrame ignored -> "Last";
            default -> "Normal";
        };
    }

    public int calculateTotalScore(List<Integer> rolls) {
        List<Integer> frames = calculateFrameScores(rolls);
        System.out.println("Frames : "+frames.toString());
        System.out.println("Frames Types: "+framesMap);

        framesMap.forEach((frameNumber, frame) -> {
            Parameterizable parameterizable = (Parameterizable) frame;
            System.out.println("Frame "+ frameNumber + " : " + parameterizable.getName()+ " : " + parameterizable.getScore());
        });

        return frames.isEmpty() ? 0 : frames.stream().reduce(0, Integer::sum);
    }
}