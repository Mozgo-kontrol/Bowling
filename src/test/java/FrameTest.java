import com.example.bowling.Frame;
import com.example.bowling.Game;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {
    private final Frame frame = new Frame();

    @Test
    void testStrikeScore() {
        List<Integer> rolls = List.of(10, 5, 3);
        assertEquals(18, frame.getScore(rolls, 0));
        assertEquals(1, frame.getAdvance(rolls, 0));
    }

    @Test
    void testSpareScore() {
        List<Integer> rolls = List.of(6, 4, 7);
        assertEquals(17, frame.getScore(rolls, 0));
        assertEquals(2, frame.getAdvance(rolls, 0));
    }

    @Test
    void testNormalScore() {
        List<Integer> rolls = List.of(4, 2);
        assertEquals(6, frame.getScore(rolls, 0));
        assertEquals(2, frame.getAdvance(rolls, 0));
    }
}
