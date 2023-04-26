package no.uib.inf101.sem2.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import no.uib.inf101.sem2.view.ColorTheme;
//import no.uib.inf101.sem2.view.DefaultColorTheme;
import java.awt.Color;

import org.junit.jupiter.api.Test;

public class TestDefaultColorTheme {
    
@Test
public void sanityTestDefaultColorTheme() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(Color.BLACK, colors.getBackgroundColor());
    assertEquals(Color.BLACK, colors.getFrameColor());
    assertEquals(Color.DARK_GRAY, colors.getCellColor('-'));
    assertEquals(Color.RED, colors.getCellColor('r'));
    assertThrows(IllegalArgumentException.class, () -> colors.getCellColor('\n'));
}

    
}
