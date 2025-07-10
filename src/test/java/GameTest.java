import com.example.bowling.FrameFactory;
import com.example.bowling.Game;
import com.example.bowling.ScoreCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    void testPerfectGame() {
        FrameFactory frameFactory = new FrameFactory();
        ScoreCalculator calculator = new ScoreCalculator(frameFactory);
        Game game = new Game(calculator);
        rollMany(game, 12, 10); // 12 Strikes
        assertEquals(300, game.getScore());
    }

    @Test
    void testAllOnes() {
        FrameFactory frameFactory = new FrameFactory();
        ScoreCalculator calculator = new ScoreCalculator(frameFactory);
        Game game = new Game(calculator);
        rollMany(game, 20, 1); // 20 Rolls, each 1 pin
        assertEquals(20, game.getScore());
    }

    @Test
    void testAllSparesWithFinalFive() {
        FrameFactory frameFactory = new FrameFactory();
        ScoreCalculator calculator = new ScoreCalculator(frameFactory);
        Game game = new Game(calculator);
        for (int i = 0; i < 10; i++) {
            game.roll(5);
            game.roll(5); // Spare
        }
        game.roll(5); // Bonus roll
        assertEquals(150, game.getScore());
    }

    @Test
    void testStrikeThenThreeAndFour() {
        FrameFactory frameFactory = new FrameFactory();
        ScoreCalculator calculator = new ScoreCalculator(frameFactory);
        Game game = new Game(calculator);
        game.roll(10); // Strike
        game.roll(3);
        game.roll(4);
        rollMany(game, 16, 0); // rest are gutter balls
        assertEquals(24, game.getScore());
    }

    @Test
    void testExampleInputOne() {
        FrameFactory frameFactory = new FrameFactory();
        ScoreCalculator calculator = new ScoreCalculator(frameFactory);
        Game game = new Game(calculator);
        int[] rolls = {10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9, 0, 8, 2, 9, 1, 10};
        for (int roll : rolls) {
            game.roll(roll);
        }
        assertEquals(187, game.getScore());
    }

    @Test
    void testExampleInputTwo() {
        FrameFactory frameFactory = new FrameFactory();
        ScoreCalculator calculator = new ScoreCalculator(frameFactory);
        Game game = new Game(calculator);
        int[] rolls = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
        for (int roll : rolls) {
            game.roll(roll);
        }
        assertEquals(133, game.getScore());
    }

    private void rollMany(Game game, int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
