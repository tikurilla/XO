package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getPlayerName() throws Exception {
        final String expectedName = "Timur";
        final Player player = new Player("Timur", null);
        final String actualValue = player.getPlayerName();
        assertEquals(expectedName, actualValue);
    }

    @Test
    public void getPlayerFigure() throws Exception {
        final Figure expectedValue = Figure.O;
        final Player player = new Player(null, Figure.O);
        final Figure actualValue = player.getPlayerFigure();
        assertEquals(expectedValue, actualValue);
    }
}