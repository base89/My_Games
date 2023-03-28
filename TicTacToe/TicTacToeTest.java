package TicTacToe;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    @DisplayName("Should returns board fiels from string")
    @Test
    void testConvertStrToField() {
        // given
        int[] marks = {0, 2};
        // when
        int[] strMarks = TicTacToe.convertStrToField("02");
        // then
        assertArrayEquals(marks, strMarks);
    }
}
