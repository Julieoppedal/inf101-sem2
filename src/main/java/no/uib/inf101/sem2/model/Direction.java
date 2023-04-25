package no.uib.inf101.sem2.model;

public enum Direction {
    UP(-1, -0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);
    
    public final int dx, dy;
    
    private Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}