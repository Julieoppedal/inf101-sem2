package no.uib.inf101.sem2.controller;

import no.uib.inf101.sem2.model.GameState;

public interface ControllableSnake {

    boolean moveSnake(int deltaRow, int deltaCol);
    
    GameState getGameState();

    // void restartGame();

    //int getScore();

    //int getTimeBetweenTicks();

    //void clockTick();
    
}
