package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;

import no.uib.inf101.sem2.controller.ControllableSnake;
import no.uib.inf101.sem2.view.ViewableSnakeModel;
import no.uib.inf101.sem2.model.apple.Apple;
import no.uib.inf101.sem2.model.apple.AppleFactory;

/**

SnakeModel represents the logic of the game, and implements the ViewableSnakeModel and ControllableSnake interfaces.

It contains information about the game state, the snake, the apple, and the score, and handles the movements and

collisions of the snake, as well as the spawning and removal of apples.
*/

public class SnakeModel implements ViewableSnakeModel, ControllableSnake {

    private final SnakeBoard board;
    private final AppleFactory appleFactory;
    private GameState state;
    private Snake snake;
    private Apple apple;
    private int score;


/**

Constructs a new SnakeModel object with the given board, apple factory, and initial snake.
@param board the SnakeBoard representing the game board
@param appleFactory the AppleFactory for spawning apples on the board
@param snake the initial Snake object
*/

    public SnakeModel(SnakeBoard board, AppleFactory appleFactory, Snake snake) {
        this.board = board;
        this.appleFactory = appleFactory;
        this.apple = this.appleFactory.getApple(this.board);
        this.snake = new Snake();
        this.score = 0;
        this.state = GameState.ACTIVE_GAME;   
    }

/**

Gets the GridDimension of the game board.
@return the GridDimension object representing the size of the board
*/
    @Override
    public GridDimension getDimension() {
        return this.board;
    }

/**

Gets an Iterable of GridCell objects representing the tiles on the game board.
@return the Iterable of GridCell objects
*/
    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return this.board;
    }

/**

Gets the current GameState of the game.
@return the current GameState
*/
    @Override
    public GameState getGameState() {
        return this.state;
    }

/**

Gets the Snake object representing the snake in the game.
@return the Snake object
*/
    @Override
    public Snake getSnake() {
        return this.snake;
    }

/**

Gets the position of the apple on the game board.
@return the Apple object representing the apple position
*/
    @Override
    public Apple getPostition() {
        return new Apple(apple.getX(), apple.getY());
    }

/**

Checks if the snake has collided with an apple and updates the score, removes the apple from the board,
and spawns a new apple in a random position on the board if necessary.
*/
    @Override
    public void checkApple() {
        GridCell<Character> headPosition = this.snake.getBody().get(0);
        int headRow = headPosition.pos().row();
        int headCol = headPosition.pos().col();
        
        if (headRow == this.apple.getX() && headCol == this.apple.getY()) {
            this.score += 10;
            // remove the apple from the board
            this.board.removeObject(this.apple.getX(), this.apple.getY());
            
            // get a new apple and update its position
            this.apple = this.appleFactory.getApple(this.board);
            
            // increase the length of the snake by one
            this.snake.grow();
        }
    }

/**

Rotates the direction of the snake's movement.
@param dir the direction to rotate the snake
*/
    @Override
    public void rotateSnake(Direction dir) {
        this.snake.setDirection(dir);
    }

/**

Moves the snake one step in its current direction, checks for collisions, and updates the game state and score.
@return true if the snake is still alive and the game is ongoing, false if the snake has collided and the game is over
*/
    @Override
    public boolean moveSnake() {
        this.snake.move();
        
        checkApple();
        
        this.snake.checkCollision(board.rows(), board.cols());
        if (!this.snake.isAlive()) {
            state = GameState.GAME_OVER;
            return false;
        }
    
        return true;
    }

/**

Gets the current score of the game.
@return the current score
*/
    @Override
    public int getScore() {
        return this.score;
    }

/**

Restarts the game by resetting the snake, apple, and score to their initial values, and setting the game state to
ACTIVE_GAME.
*/
    @Override
    public void restartGame() {
        this.snake = new Snake();
        this.apple = this.appleFactory.getApple(this.board);
        this.score = 0;
        this.state = GameState.ACTIVE_GAME;
    }

/**

Gets the time between clock ticks for the game.
@return the time in milliseconds
*/
    @Override
    public int getTimeBetweenTicks() {
        return 100;
    }

/**

Not implemented in this version of the game.
*/
    @Override
    public void clockTick() {

    }

}
