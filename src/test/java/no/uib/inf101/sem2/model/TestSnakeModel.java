package no.uib.inf101.sem2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.model.apple.AppleFactory;
import no.uib.inf101.sem2.model.apple.RandomAppleFactory;

public class TestSnakeModel {

    @Test
    public void testGetDimension() {
        SnakeBoard board = new SnakeBoard(20, 20);
        AppleFactory factory = new RandomAppleFactory();
        Snake snake = new Snake();
        SnakeModel model = new SnakeModel(board, factory, snake);
    
        GridDimension dim = model.getDimension();
    
        assertEquals(20, dim.rows());
        assertEquals(20, dim.cols());
    }


    @Test
    public void testMoveSnake() {
        SnakeBoard board = new SnakeBoard(20, 20);
        AppleFactory factory = new RandomAppleFactory();
        Snake snake = new Snake();
        SnakeModel model = new SnakeModel(board, factory, snake);
            
        for(int i = 0; i < 21; i++) {
            model.moveSnake();
        }
        
        assertEquals(GameState.GAME_OVER, model.getGameState());
        assertFalse(model.moveSnake());;
    }

    
    @Test
    public void testCheckApple() {
        SnakeBoard board = new SnakeBoard(20, 20);
        AppleFactory factory = new RandomAppleFactory();
        Snake snake = new Snake();
        SnakeModel model = new SnakeModel(board, factory, snake);

        //Apple apple = new Apple(5, 5);
        
        snake.getBody().add(new GridCell<>(new CellPosition(5, 5), 'S'));
        snake.getBody().add(new GridCell<>(new CellPosition(6, 5), 'S'));
        

        model.checkApple();
    
        snake.move();
        assertTrue(model.getSnake().getBody().size() == 4); // The apple has been reached
        
    }
   
    
}

