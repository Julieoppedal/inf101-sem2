package no.uib.inf101.sem2.model.apple;

import java.util.Random;

import no.uib.inf101.sem2.grid.Grid;

public class RandomAppleFactory<E> implements AppleFactory<E> {

    private final Random random = new Random();


    @Override
    public Apple getApple(Grid<E> grid) {
        int rows = grid.rows();
        int cols = grid.cols();
        int x = random.nextInt(cols);
        int y = random.nextInt(rows);
        return new Apple(x,y);
    }

}
