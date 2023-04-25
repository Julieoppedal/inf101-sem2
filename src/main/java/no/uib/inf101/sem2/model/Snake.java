package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;

import java.util.ArrayList;

public class Snake {
    private ArrayList<GridCell<Character>> body; // list of points representing the snake's body
    private Direction direction; // current direction of the snake
    private boolean isAlive; // whether the snake is alive or dead
    
    // Constructor
    public Snake() {
        body = new ArrayList<GridCell<Character>>();
        // initialize the body with the starting position and length
        body.add(new GridCell<>(new CellPosition(10, 11), 'I'));
        body.add(new GridCell<>(new CellPosition(10, 12),'I'));
        body.add(new GridCell<>(new CellPosition(10, 13),'I'));
        body.add(new GridCell<>(new CellPosition(10, 14),'I'));
        this.direction = Direction.RIGHT;
        isAlive = true;
    }
    
    // Methods for getting and setting variables
    public ArrayList<GridCell<Character>> getBody() {
        return this.body;
    }
    
    public Direction getDirection() {
        return this.direction;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void move() {
        // get the current head and its position
        GridCell<Character> currentHead = body.get(0);
        CellPosition headPosition = currentHead.pos();
    
        // create a new head based on the current direction
        CellPosition newHeadPosition = new CellPosition(headPosition.row() + direction.dx, headPosition.col() + direction.dy);
        GridCell<Character> newHead = new GridCell<>(newHeadPosition, 'I');
    
        // remove the tail and add the new head to the front
        body.remove(body.size() - 1);
        body.add(0, newHead);
    }
    
    public void checkCollision(int width, int height) {
        // check if the head has collided with the body
        GridCell<Character> currentHead = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (currentHead.equals(body.get(i))) {
                isAlive = false;
                return;
            }
        }
        
        // check if the head is outside the grid boundaries
        CellPosition headPosition = currentHead.pos();
        if (headPosition.row() < 0 || headPosition.row() >= height ||
                headPosition.col() < 0 || headPosition.col() >= width) {
            isAlive = false;
            return;
        }
    }
    
    // Method for adding a new segment to the end of the snake
    public void grow() {
        // get the current tail and its position
        GridCell<Character> currentTail = body.get(body.size() - 1);
        CellPosition tailPosition = currentTail.pos();
        
        // calculate the position of the new tail based on the direction of the snake
        int newRow = tailPosition.row() - direction.dx;
        int newCol = tailPosition.col() - direction.dy;
        CellPosition newTailPosition = new CellPosition(newRow, newCol);
        
        // create a new tail and add it to the end of the body
        GridCell<Character> newTail = new GridCell<>(newTailPosition, 'I');
        body.add(newTail);
    }


}