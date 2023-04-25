package no.uib.inf101.sem2.controller;

import java.awt.event.KeyEvent;

import no.uib.inf101.sem2.view.SnakeView;
import javax.swing.Timer;
import java.awt.event.ActionEvent; 

/**

The TetrisController class is responsible for handling user input and updating the model and view accordingly.

It implements the java.awt.event.KeyListener interface and listens for key events from the TetrisView.
*/



public class SnakeController implements java.awt.event.KeyListener {

    private final ControllableSnake consol;
    private final SnakeView snakeView;
   // private final Timer timer;

    /**

Constructs a new TetrisController with the specified ControllableTetrisModel and TetrisView.
@param consol the ControllableTetrisModel to use.
@param tetrisView the TetrisView to use.
*/

    public SnakeController(ControllableSnake consol, SnakeView snakeView) {
        this.snakeView = snakeView;
        this.consol = consol;

        // Initialize timer
        //this.timer = new Timer(consol.getTimeBetweenTicks(), this::clockTick);
        //this.timer.setInitialDelay(0);
        //this.timer.start();

        

        this.snakeView.setFocusable(true); // make TetrisView focusable
        this.snakeView.addKeyListener(this); // add the key listener to TetrisView

    }

/**

Responds to key pressed events from the TetrisView and updates the model and view accordingly.
@param e the KeyEvent that occurred.
*/

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            consol.moveSnake(0,-1);
            // Left arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            consol.moveSnake(0,1);

            // Right arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            consol.moveSnake(1,0);
            // Down arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            consol.moveSnake(-1,0);
            // Up arrow was pressed
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

Updates the model and view when the timer goes.
@param e the ActionEvent that occurred.
*/

    /*public void clockTick(ActionEvent e) {
        consol.clockTick();
        snakeView.repaint();
    }*/
}