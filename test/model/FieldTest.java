package model;

import exceptions.AlreadyOccupiedException;
import exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zaibatsu on 20.03.2017.
 */
public class FieldTest {
    @Test
    public void getSize() throws Exception {
        final int expectedValue = 3;
        final Field field = new Field();
        final int actualValue = field.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final  Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint, inputFigure);
        final  Figure actualFigure = field.getFigure(inputPoint);
        assertNotNull(actualFigure);
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;
        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void setFigureWhenXLessLowLimit() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        }
        catch (InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenXMoreHighLimit() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,0);
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        }
        catch (InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenYLessLowLimit() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        }
        catch (InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenYMoreHighLimit() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        }
        catch (InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenPointIsOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure1 = Figure.X;
        final Figure inputFigure2 = Figure.O;
        field.setFigure(inputPoint, inputFigure1);
        try {
            field.setFigure(inputPoint, inputFigure2);
            fail();
        }
        catch (AlreadyOccupiedException e) {}
    }

    @Test
    public void fieldIsFull() throws Exception {

    }

}