package model;

public class Field {
    private static final int FIELD_SIZE = 3;

    public Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize () {

        return FIELD_SIZE;

    }

    public Figure getFigure (Point point) {

        return figures[point.getX()][point.getY()];

    }

    public void setFigure (Point point, Figure figure) {

        figures[point.getX()][point.getY()] = figure;

    }
}