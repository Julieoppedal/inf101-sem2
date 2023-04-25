package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.controller.ControllableSnake;
import no.uib.inf101.sem2.view.ViewableSnakeModel;
import no.uib.inf101.sem2.model.GameState;
import no.uib.inf101.sem2.model.apple.Apple;
import no.uib.inf101.sem2.model.apple.AppleFactory;


public class SnakeModel implements ViewableSnakeModel, ControllableSnake {

    private final SnakeBoard board;
    private final AppleFactory appleFactory;
    private GameState state;
    private Snake snake;
    private Apple apple;
    private int applesEaten;
    private int score;



    public SnakeModel(SnakeBoard board, AppleFactory appleFactory) {
        this.board = board;
        this.appleFactory = appleFactory;
        this.apple = this.appleFactory.getApple(this.board);
        this.snake = new Snake();
        this.applesEaten = 0;
        this.score = 0;
        this.state = GameState.ACTIVE_GAME;   
    }

    @Override
    public GridDimension getDimension() {
        return this.board;
    }

    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return this.board;
    }


    @Override
    public GameState getGameState() {
        return this.state;
    }

    @Override
    public Snake getSnake() {
        return this.snake;
    }

    @Override
    public Apple getPostition() {
        return new Apple(apple.getX(), apple.getY());
    }
    

    @Override
    public boolean moveSnake(int deltaRow, int deltaCol) {
        // set the direction of the snake based on the deltaRow and deltaCol values
        if (deltaRow == 1) {
            this.snake.setDirection(Direction.DOWN);
        } else if (deltaRow == -1) {
            this.snake.setDirection(Direction.UP);
        } else if (deltaCol == 1) {
            this.snake.setDirection(Direction.RIGHT);
        } else if (deltaCol == -1) {
            this.snake.setDirection(Direction.LEFT);
        }
        
        // move the snake
        this.snake.move();
        
        // check if the snake has eaten an apple
        if (this.snake.hasEatenApple(this.apple)) {
            // update the score and number of apples eaten
            this.score += 10;
            this.applesEaten++;
            // get a new apple and update its position
            this.apple = this.appleFactory.getApple(this.board);
        }
        
        // check for collisions
        this.snake.checkCollision(board.rows(), board.cols());
        if (!this.snake.isAlive()) {
            state = GameState.GAME_OVER;
            return false;
        }
    
        return true;
    }

     

}
