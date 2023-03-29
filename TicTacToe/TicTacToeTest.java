package TicTacToe;

import static org.junit.Assert.assertTrue;
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

    @DisplayName("Should returns true when there are three marks in line on board")
    @Test
    void testIfWin() {
        // given
        TicTacToe ttt = new TicTacToe();
        char[][] marks1 = {{'X', 'X', 'X'}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        // when
        TicTacToe.setBoard(marks1);
        // then
        assertTrue(ttt.ifWin());

        // given
        char[][] marks2 = {{'X', ' ', ' '}, {'X', ' ', ' '}, {'X', ' ', ' '}};
        // when
        TicTacToe.setBoard(marks2);
        // then
        assertTrue(ttt.ifWin());

        // given
        char[][] marks3 = {{'X', ' ', ' '}, {' ', 'X', ' '}, {' ', ' ', 'X'}};
        // when
        TicTacToe.setBoard(marks3);
        // then
        assertTrue(ttt.ifWin());
    }
}
