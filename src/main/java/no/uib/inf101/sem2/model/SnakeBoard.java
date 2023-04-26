package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;

/**

Represents the game board for the Snake game, which is a grid of characters.

Extends the Grid class to inherit its methods and functionality.
*/

public class SnakeBoard extends Grid<Character> {

/**

Constructor that initializes a new SnakeBoard with the given number of rows and columns.
Each cell is initially filled with the '-' character.
@param rows the number of rows in the grid
@param cols the number of columns in the grid
*/

    public SnakeBoard(int rows, int cols) {
        super(rows, cols, '-');

    }

/**

Returns a string representation of the grid where each character is separated by a space.

Each row is separated by a newline character.

@return a string representation of the grid
*/

    public String prettyString() {
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                sb.append(get(new CellPosition(i, j)));
            }
            if (i < rows() - 1) { // Sjekker om vi er på den siste raden
                sb.append("\n");
            }
        }
    
        return sb.toString();
    }

/**

Sets the character at the specified position to the '-' character, effectively removing any object at that position.
@param x the row index of the position to remove
@param y the column index of the position to remove
*/

    public void removeObject(int x, int y) {
        set(new CellPosition(x, y), '-');
    }

    
}
