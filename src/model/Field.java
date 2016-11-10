package model;

import java.util.Arrays;

public class Field {
    private static final int FIELD_SIZE = 3;

    public String[][] figures = new String[FIELD_SIZE][FIELD_SIZE];

    public int getSize () {

        return FIELD_SIZE;

    }

    public String getFigure (Point point) {

        return figures[point.x][point.y];

    }

    public void setFigure (Point point, String figure) {

        figures[point.x][point.y] = figure;

    }



}