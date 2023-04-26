package no.uib.inf101.sem2.model.apple;

/**

The Apple class represents an apple object in the Snake game.

An Apple object has a fixed position in the game board, represented by its x and y coordinates.
*/

public class Apple {

/**

Constructs a new Apple object with the specified x and y coordinates.
@param x the x-coordinate of the Apple object
@param y the y-coordinate of the Apple object
*/
    private final int x;
    private final int y;

    public Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }


/**

Returns the x-coordinate of the Apple object.
@return the x-coordinate of the Apple object
*/
    public int getX() {
        return x;
    }

/**

Returns the y-coordinate of the Apple object.
@return the y-coordinate of the Apple object
*/
    public int getY() {
        return y;
    }

    
}
