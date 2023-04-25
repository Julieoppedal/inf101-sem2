package no.uib.inf101.sem2.model.apple;

import no.uib.inf101.sem2.grid.Grid;

public interface AppleFactory<E>  {

    Apple getApple(Grid<E> grid);
    
}
