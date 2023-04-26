package no.uib.inf101.sem2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;

public class TestSnake {

    @Test
    public void testMove() {
    // Create a new snake facing right
    Snake snake = new Snake();
    
    // Save the initial position of the head
    GridCell<Character> headBefore = snake.getBody().get(0);
    CellPosition posBefore = headBefore.pos();
    
    // Move the snake once
    snake.move();
    
    // Save the new position of the head
    GridCell<Character> headAfter = snake.getBody().get(0);
    CellPosition posAfter = headAfter.pos();
    
    // Check that the head has moved one step to the right
    assertEquals(posBefore.row(), posAfter.row());
    assertEquals(posBefore.col() + 1, posAfter.col());
    }
    

    @Test
    public void testCheckCollisionWithWall() {
    // Create a new snake
    Snake snake = new Snake();

    // Test with a grid of width 10 and height 10
    snake.checkCollision(10, 10);
    assertFalse(snake.isAlive());

    // Test with a grid of width 10 and height 20
    snake = new Snake();
    snake.checkCollision(10, 20);
    assertFalse(snake.isAlive());

    // Test with a grid of width 20 and height 10
    snake = new Snake();
    snake.checkCollision(20, 10);
    assertFalse(snake.isAlive());

    // Test with a grid of width 20 and height 20
    snake = new Snake();
    snake.checkCollision(20, 20);
    assertTrue(snake.isAlive());
    }


    @Test
    public void testCheckCollisionWithSelf() {
    // Create a new snake
    Snake snake = new Snake();
    
    // Add some body segments that will collide with each other
    ArrayList<GridCell<Character>> body = snake.getBody();
    body.remove(0);
    body.add(new GridCell<>(new CellPosition(10, 13),'I'));
    
    // Check collision with self
    snake.checkCollision(20, 20);
    
    // Verify that the snake is not alive
    assertFalse(snake.isAlive());
    }


    @Test
    public void testGrow() {
    Snake snake = new Snake();
    ArrayList<GridCell<Character>> body = snake.getBody();
    int initialSize = body.size();
    GridCell<Character> currentTail = body.get(body.size() - 1);
    CellPosition tailPosition = currentTail.pos();
    
    snake.grow();
    
    GridCell<Character> newTail = body.get(body.size() - 1);
    CellPosition newTailPosition = newTail.pos();
    
    // Check that the new tail position is correct
    assertEquals(newTailPosition, new CellPosition(tailPosition.row() - snake.getDirection().dx, tailPosition.col() - snake.getDirection().dy));
    
    // Check that the size of the body has increased by 1
    assertEquals(initialSize + 1, body.size());
    }


    
}
