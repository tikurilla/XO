package model;
import exceptions.AlreadyOccupiedException;
import exceptions.InvalidPointException;

public class Field {
    private final int MIN_COORDINATE = 0;

    private int fieldSize;

    private Figure[][] figures;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        figures = new Figure[fieldSize][fieldSize];
    }

    public int getSize () {
        return fieldSize;
    }

    public Figure getFigure (Point point) throws InvalidPointException {
        if (!checkCoordinate(point.getX()) || !checkCoordinate(point.getY()))
            throw new InvalidPointException();
        return figures[point.getX()][point.getY()];
    }

    public void setFigure (Point point, Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkCoordinate(point.getX()) || !checkCoordinate(point.getY())) {
            throw new InvalidPointException();
        }
        if (getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        figures[point.getX()][point.getY()] = figure;
    }

    public boolean fieldIsFull() {
        int emptySpacesAmount = 0;
        for(int x = 0; x < this.getSize(); x++) {
            for(int y = 0; y < this.getSize(); y++) {
                if(figures[x][y]==null)
                    emptySpacesAmount++;
            }
        }
        return emptySpacesAmount==0;
    }

    private boolean checkCoordinate(final int value) {
        return !(value < MIN_COORDINATE || value > this.fieldSize);
    }
}