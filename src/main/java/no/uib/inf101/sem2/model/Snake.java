package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;

import java.util.ArrayList;

/**

The Snake class represents a snake in a game. It is defined by its body, direction, and alive status.
*/
public class Snake {
    private ArrayList<GridCell<Character>> body; 
    private Direction direction; 
    private boolean isAlive; 
    
/**

Constructs a new Snake object with an initial body, direction, and alive status.
*/
    public Snake() {
        body = new ArrayList<GridCell<Character>>();
        body.add(new GridCell<>(new CellPosition(10, 14), 'I'));
        body.add(new GridCell<>(new CellPosition(10, 13),'I'));
        body.add(new GridCell<>(new CellPosition(10, 12),'I'));
        body.add(new GridCell<>(new CellPosition(10, 11),'I'));
        this.direction = Direction.RIGHT;
        isAlive = true;
    }
    
/**

Returns the current body of the snake.
@return the current body of the snake
*/
    public ArrayList<GridCell<Character>> getBody() {
        return this.body;
    }

/**

Returns the current direction of the snake.
@return the current direction of the snake
*/
    public Direction getDirection() {
        return this.direction;
    }
/**

Returns the current alive status of the snake.
@return the current alive status of the snake
*/
    public boolean isAlive() {
        return isAlive;
    }
/**

Sets the direction of the snake.
@param direction the new direction of the snake
*/
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
/**

Moves the snake one step in its current direction.
*/
    public void move() {
        GridCell<Character> currentHead = body.get(0);
        CellPosition headPosition = currentHead.pos();
 
        CellPosition newHeadPosition = new CellPosition(headPosition.row() + direction.dx, headPosition.col() + direction.dy);
        GridCell<Character> newHead = new GridCell<>(newHeadPosition, 'I');
    
        body.remove(body.size() - 1);
        body.add(0, newHead);
    }

/**

Checks if the snake has collided with the wall or itself, and updates its alive status accordingly.
@param width the width of the game board
@param height the height of the game board
*/
    public void checkCollision(int width, int height) {
        GridCell<Character> currentHead = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (currentHead.equals(body.get(i))) {
                isAlive = false;
                return;
            }
        }
        
        CellPosition headPosition = currentHead.pos();
        if (headPosition.row() < 0 || headPosition.row() >= height ||
                headPosition.col() < 0 || headPosition.col() >= width) {
            isAlive = false;
            return;
        }
    }

/**

Increases the length of the snake by one unit, by adding a new cell to the end of its body.
*/
    public void grow() {
        GridCell<Character> currentTail = body.get(body.size() - 1);
        CellPosition tailPosition = currentTail.pos();
        
        int newRow = tailPosition.row() - direction.dx;
        int newCol = tailPosition.col() - direction.dy;
        CellPosition newTailPosition = new CellPosition(newRow, newCol);
        
        GridCell<Character> newTail = new GridCell<>(newTailPosition, 'I');
        body.add(newTail);
    }


}