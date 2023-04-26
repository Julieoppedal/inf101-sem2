package no.uib.inf101.sem2.model.apple;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppleTest {

    @Test
    public void testGetX() {
        Apple apple = new Apple(5, 10);
        assertEquals(apple.getX(), 5, "Apple should have x-coordinate 5");
    }

    @Test
    public void testGetY() {
        Apple apple = new Apple(5, 10);
        assertEquals(apple.getY(), 10, "Apple should have y-coordinate 10");
    }

}