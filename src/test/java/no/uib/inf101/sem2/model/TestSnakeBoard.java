package no.uib.inf101.sem2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.uib.inf101.sem2.grid.CellPosition;

public class TestSnakeBoard {

    @Test
    public void testPrettyString() {
    SnakeBoard board = new SnakeBoard(3, 4);
    board.set(new CellPosition(0, 0), 'g');
    board.set(new CellPosition(0, 3), 'y');
    board.set(new CellPosition(2, 0), 'r');
    board.set(new CellPosition(2, 3), 'b');
    String expected = String.join("\n", new String[] {
        "g--y",
        "----",
        "r--b"
    });
    assertEquals(expected, board.prettyString());
    }

    @Test
    public void testRemoveObject() {
        SnakeBoard board = new SnakeBoard(3, 4);
        board.set(new CellPosition(0, 0), 'g');
        board.set(new CellPosition(0, 3), 'y');
        board.set(new CellPosition(2, 0), 'r');
        board.set(new CellPosition(2, 3), 'b');
        board.removeObject(0, 0);
        board.removeObject(2, 3);
        String expected = String.join("\n", new String[] {
            "---y",
            "----",
            "r---"
        });
        assertEquals(expected, board.prettyString());
    }
    
}
