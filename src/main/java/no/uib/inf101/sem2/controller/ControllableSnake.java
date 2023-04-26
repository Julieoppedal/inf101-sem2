package no.uib.inf101.sem2.controller;

import no.uib.inf101.sem2.model.Direction;
import no.uib.inf101.sem2.model.GameState;

/**

The ControllableSnake interface represents a controllable game of Snake. It provides methods to move the snake, restart the game,

get the current game state, get the score, get the time between ticks, update the game clock, and rotate the snake in a given direction.
*/

public interface ControllableSnake {

/**

Attempts to move the snake one step in its current direction. Returns true if the move is successful and false if it is not.
@return true if the move is successful and false if it is not.
*/
    boolean moveSnake();
    
/**

Returns the current game state.
@return the current game state.
*/
    GameState getGameState();

/**

Restarts the game by resetting the score, resetting the game clock, and resetting the snake to its starting position.
*/
    void restartGame();

/**

Returns the current score.
@return the current score.
*/
    int getScore();

/**

Returns the time between ticks in milliseconds.
@return the time between ticks in milliseconds.
*/
    int getTimeBetweenTicks();

/**

Updates the game clock by one tick.
*/
    void clockTick();

/**

Rotates the snake in the given direction.
@param dir the direction to rotate the snake.
*/
    void rotateSnake(Direction dir);
    
}
