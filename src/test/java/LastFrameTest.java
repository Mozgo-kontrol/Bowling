import com.example.bowling.LastFrame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastFrameTest {
    private final LastFrame lastFrame = new LastFrame();

    @Test
    void testStrikeInLastFrame() {
        List<Integer> rolls = List.of(10, 10, 10);
        assertEquals(30, lastFrame.getScore(rolls, 0));
        assertEquals(3, lastFrame.getAdvance(rolls, 0));
    }

    @Test
    void testSpareInLastFrame() {
        List<Integer> rolls = List.of(6, 4, 5);
        assertEquals(15, lastFrame.getScore(rolls, 0));
        assertEquals(3, lastFrame.getAdvance(rolls, 0));
    }

    @Test
    void testOpenLastFrame() {
        List<Integer> rolls = List.of(5, 3); // 8 total, no bonus
        assertEquals(8, lastFrame.getScore(rolls, 0));
        assertEquals(2, lastFrame.getAdvance(rolls, 0));
    }
}
