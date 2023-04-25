package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;


public class SnakeBoard extends Grid<Character> {

    public SnakeBoard(int rows, int cols) {
        super(rows, cols, '-');

    }

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

    public void removeObject(int x, int y) {
        set(new CellPosition(x, y), '-');
    }

    
}
