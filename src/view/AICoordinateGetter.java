package view;

import exceptions.InvalidPointException;
import model.Field;
import model.Figure;
import model.Point;

public class AICoordinateGetter {

    private final int FIRST_POSITION = 1;

    public Point getMoveCoordinate(final Field field) {
        int firstPosition = field.getSize()/2;
        if (isEmptyField(field)==true) {
            return new Point(firstPosition, firstPosition);
        }
        else if (getOneOfThreeInRow(field)!=null) {
            return getOneOfThreeInRow(field);
        }
        else if (getOneOfThreeInColumn(field)!=null) {
            return getOneOfThreeInColumn(field);
        }
        else if (getOneOfThreeInStraightDiagonal(field)!=null) {
            return getOneOfThreeInStraightDiagonal(field);
        }
        else if (getOneOfThreeInReverseDiagonal(field)!=null) {
            return getOneOfThreeInReverseDiagonal(field);
        }
        else {
            RandomCoordinateGetter randomCoordinateGetter = new RandomCoordinateGetter();
            return randomCoordinateGetter.getMoveCoordinate(field);
        }
    }

    private Point getOneOfThreeInRow(final Field field) {
        // finding two same figures in row
        for (int y = 0; y < field.getSize(); y = y + 1) {
            for (int x = 0; x < field.getSize() - 1; x = x + 1) {
                Point p1 = new Point(x, y);
                Point p2 = new Point(getLimitedPosition(0, field.getSize() - 1 , x + 1), y);
                Point p3 = new Point(getLimitedPosition(0, field.getSize() - 1 , x + 2), y);
                Point pFree;
                if (sameFigures(field, p1, p2)) {
                    pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , x + 2), y);
                    try {
                        if (field.getFigure(pFree)==null)
                            return pFree;
                    }
                    catch (InvalidPointException e) {
                        e.printStackTrace();
                    }
                }
                if (sameFigures(field, p1, p3)) {
                    pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , x + 1), y);
                    try {
                        if (field.getFigure(pFree)==null)
                            return pFree;
                    }
                    catch (InvalidPointException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private Point getOneOfThreeInColumn(final Field field) {
        // finding two same figures in column
        for (int x = 0; x < field.getSize(); x = x + 1) {
            for (int y = 0; y < field.getSize() - 1; y = y + 1) {
                Point p1 = new Point(x, y);
                Point p2 = new Point(x, getLimitedPosition(0, field.getSize() - 1 , y + 1));
                Point p3 = new Point(x, getLimitedPosition(0, field.getSize() - 1 , y + 2));
                Point pFree;
                if (sameFigures(field, p1, p2)) {
                    pFree = new Point(x, getLimitedPosition(0, field.getSize() - 1 , y + 2));
                    try {
                        if (field.getFigure(pFree)==null)
                            return pFree;
                    }
                    catch (InvalidPointException e) {
                        e.printStackTrace();
                    }
                }
                if (sameFigures(field, p1, p3)) {
                    pFree = new Point(x, getLimitedPosition(0, field.getSize() - 1 , y + 1));
                    try {
                        if (field.getFigure(pFree)==null)
                            return pFree;
                    }
                    catch (InvalidPointException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private Point getOneOfThreeInStraightDiagonal(final Field field) {
        // finding two same figures in straight diagonal
        for (int i = 0; i < field.getSize(); i = i + 1) {
            Point p1 = new Point(i, i);
            Point p2 = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 1),
                                 getLimitedPosition(0, field.getSize() - 1 , i + 1));
            Point p3 = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 2),
                                 getLimitedPosition(0, field.getSize() - 1 , i + 2));
            Point pFree;
            if (sameFigures(field, p1, p2)) {
                pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 2),
                                  getLimitedPosition(0, field.getSize() - 1 , i + 2));
                try {
                    if (field.getFigure(pFree)==null)
                        return pFree;
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
            if (sameFigures(field, p1, p3)) {
                pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 1),
                                  getLimitedPosition(0, field.getSize() - 1 , i + 1));
                try {
                    if (field.getFigure(pFree)==null)
                        return pFree;
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private Point getOneOfThreeInReverseDiagonal(final Field field) {
        // finding two same figures in straight diagonal
        for (int i = 0; i < field.getSize(); i = i + 1) {
            Point p1 = new Point(i, getLimitedPosition(0, field.getSize() - 1 , i + 2));
            Point p2 = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 1),
                                 getLimitedPosition(0, field.getSize() - 1 , i + 1));
            Point p3 = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 2), i);
            Point pFree;
            if (sameFigures(field, p1, p2)) {
                pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 2), i);
                try {
                    if (field.getFigure(pFree)==null)
                        return pFree;
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
            if (sameFigures(field, p1, p3)) {
                pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 1),
                            getLimitedPosition(0, field.getSize() - 1 , i + 1));
                try {
                    if (field.getFigure(pFree)==null)
                        return pFree;
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
            if (sameFigures(field, p2, p3)) {
                pFree = new Point(i, getLimitedPosition(0, field.getSize() - 1 , i + 2));
                try {
                    if (field.getFigure(pFree)==null)
                        return pFree;
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private boolean sameFigures(final Field field, final Point p1, final Point p2) {
        Figure figure1 = Figure.O;
        Figure figure2 = Figure.O;
        try {
            figure1 = field.getFigure(p1);
        }
        catch (InvalidPointException e) {
            e.printStackTrace();
        }
        try {
            figure2 = field.getFigure(p2);
        }
        catch (InvalidPointException e) {
            e.printStackTrace();
        }
        if (figure1 != null && figure2 != null
                && figure1.equals(figure2)) {
            return true;
        }
        return false;
    }

    private int getLimitedPosition(final int lowLimit, final int highLimit, int x) {
        int cnt = 0;
        for (int i = lowLimit; i < x + 1; i++) {
            if (i!=0)
                cnt++;
            if (cnt > highLimit)
                cnt = 0;
        }
        return cnt;
    }

    private boolean isEmptyField(Field field) {
        for (int x = 0; x < field.getSize(); x = x + 1) {
            for (int y = 0; y < field.getSize(); y = y + 1) {
                Point point = new Point(x, y);
                try {
                    if (field.getFigure(point) != null)
                        return false;
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

}