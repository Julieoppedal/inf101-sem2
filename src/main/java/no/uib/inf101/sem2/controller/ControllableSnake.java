package no.uib.inf101.sem2.controller;

import no.uib.inf101.sem2.model.Direction;
import no.uib.inf101.sem2.model.GameState;

public interface ControllableSnake {

    boolean moveSnake();
    
    GameState getGameState();

    void restartGame();

    int getScore();

    int getTimeBetweenTicks();

    void clockTick();

    void rotateSnake(Direction dir);
    
}
