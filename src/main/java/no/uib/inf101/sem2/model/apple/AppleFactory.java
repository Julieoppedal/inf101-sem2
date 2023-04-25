package no.uib.inf101.sem2.model.apple;

import no.uib.inf101.sem2.grid.Grid;

public interface AppleFactory  {

    Apple getApple(Grid<?> grid);
    
}
