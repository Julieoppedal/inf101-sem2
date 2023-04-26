package no.uib.inf101.sem2.view;

import java.awt.Color;

/**

The DefaultColorTheme class implements the ColorTheme interface and defines the default color

scheme used in the Snake game.
*/

public class DefaultColorTheme implements ColorTheme{
 
/**

Returns the color associated with a particular character.
@param c The character to get the color for.
@return The color associated with the character.
@throws IllegalArgumentException if no color is available for the given character.
*/
    @Override
    public Color getCellColor(Character c) {
        Color color = switch(c) {
            case 'r' -> Color.RED;
            case 'g' -> Color.GREEN;
            case 'I' -> Color.CYAN;
            case '-' -> Color.DARK_GRAY;
            default -> throw new IllegalArgumentException(
                "No available color for '" + c + "'");
        };
        return color;
    }

/**

Returns the color of the frame around the Snake game board.
@return The color of the frame.
*/
    @Override
    public Color getFrameColor() {
        return Color.BLACK;
    }

/**

Returns the color of the background behind the Snake game board.
@return The color of the background.
*/
    @Override
    public Color getBackgroundColor() {
        return Color.BLACK;
    }

/**

Returns the color used to indicate that the game is over.
@return The color used to indicate game over.
*/
    @Override
    public Color getGameOverColor() {
        return new Color(0, 0, 0, 128);
    }

/**

Returns the color of the text displayed when the game is over.
@return The color of the game over text.
*/
    @Override
    public Color getGameOverText() {
        return Color.WHITE;
    }

/**

Returns the color of the apple in the Snake game.
@return The color of the apple.
*/
    @Override
    public Color getAppleColor() {
        return Color.RED;
    }   

/**

Returns the color of the Snake's head in the game.
@return The color of the Snake's head.
*/
    @Override
    public Color getSnakeHeadColor() {
        return Color.GREEN;
    }
    
    
}