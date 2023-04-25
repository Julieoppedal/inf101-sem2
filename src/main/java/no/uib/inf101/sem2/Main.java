package no.uib.inf101.sem2;



import javax.swing.JFrame;

import no.uib.inf101.sem2.controller.SnakeController;
import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.model.SnakeBoard;
import no.uib.inf101.sem2.model.SnakeModel;
import no.uib.inf101.sem2.model.apple.AppleFactory;
import no.uib.inf101.sem2.model.apple.RandomAppleFactory;
import no.uib.inf101.sem2.view.SnakeView;

public class Main {

  public static final String WINDOW_TITLE = "Snake";

  public static void main(String[] args) {
    
    SnakeBoard board = new SnakeBoard(20, 20);
    board.set(new CellPosition(0, 0), 'g');
    board.set(new CellPosition(0, 9), 'y');
    board.set(new CellPosition(19, 0), 'r');
    board.set(new CellPosition(19, 9), 'b');

    AppleFactory factory = new RandomAppleFactory();
    
    SnakeModel model = new SnakeModel(board, factory);

    SnakeView view = new SnakeView(model);

    new SnakeController(model, view);


    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setTitle("Snake");
    frame.setContentPane(view);

    frame.pack();
    frame.setVisible(true);

  }
}
