package no.uib.inf101.sem2.controller;

import java.awt.event.KeyEvent;

import no.uib.inf101.sem2.model.Direction;
import no.uib.inf101.sem2.model.GameState;
import no.uib.inf101.sem2.view.SnakeView;
import javax.swing.Timer;
import java.awt.event.ActionEvent; 


/**

The SnakeController class controls the game logic for the Snake game and handles input from the user.
*/

public class SnakeController implements java.awt.event.KeyListener {

    private final ControllableSnake consol;
    private final SnakeView snakeView;
    private final Timer timer;


/**

Constructs a SnakeController object with the specified ControllableSnake and SnakeView objects.
@param consol the ControllableSnake object that this controller controls
@param snakeView the SnakeView object that displays the game
*/
    public SnakeController(ControllableSnake consol, SnakeView snakeView) {
        this.snakeView = snakeView;
        this.consol = consol;

        // Initialize timer
        this.timer = new Timer(consol.getTimeBetweenTicks(), this::clockTick);
        this.timer.setInitialDelay(0);
        this.timer.start();

        

        this.snakeView.setFocusable(true);
        this.snakeView.addKeyListener(this); 

    }

/**

Responds to a key press event and updates the snake's direction or restarts the game if the game is over.
@param e the KeyEvent that occurred
*/

    @Override
    public void keyPressed(KeyEvent e){
        if (consol.getGameState() == GameState.GAME_OVER && e.getKeyCode() != KeyEvent.VK_ENTER) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            consol.rotateSnake(Direction.LEFT);;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            consol.rotateSnake(Direction.RIGHT);;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            consol.rotateSnake(Direction.DOWN);;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            consol.rotateSnake(Direction.UP);;
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            consol.restartGame();
        }
        snakeView.repaint();
    }

/**

This method is not used.
@param e the KeyEvent that occurred.
*/
    @Override
    public void keyTyped(KeyEvent e) {

    }
/**

This method is not used.
@param e the KeyEvent that occurred.
*/

    @Override
    public void keyReleased(KeyEvent e) {

    }

/**

Moves the snake and updates the game state on a clock tick event.
@param e the ActionEvent that occurred
*/

    public void clockTick(ActionEvent e) {
        consol.moveSnake();
        consol.clockTick();
        snakeView.repaint();
    }
}
