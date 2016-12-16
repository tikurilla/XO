package view;

import model.Field;
import model.Point;

public class AICoordinateGetter implements ICoordinateGetter {

    private final int FIRST_POSITION = 1;

    public Point getMoveCoordinate(final Field field) {
        if (isEmptyField(field)==true) {
            return new Point(FIRST_POSITION, FIRST_POSITION);
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
                    if (field.getFigure(pFree)==null)
                        return pFree;
                    else
                        return null;
                }
                if (sameFigures(field, p1, p3)) {
                    pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , x + 1), y);
                    if (field.getFigure(pFree)==null)
                        return pFree;
                    else
                        return null;
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
                    if (field.getFigure(pFree)==null)
                        return pFree;
                    else
                        return null;
                }
                if (sameFigures(field, p1, p3)) {
                    pFree = new Point(x, getLimitedPosition(0, field.getSize() - 1 , y + 1));
                    if (field.getFigure(pFree)==null)
                        return pFree;
                    else
                        return null;
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
                if (field.getFigure(pFree)==null)
                    return pFree;
                else
                    return null;
            }
            if (sameFigures(field, p1, p3)) {
                pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 1),
                                  getLimitedPosition(0, field.getSize() - 1 , i + 1));
                if (field.getFigure(pFree)==null)
                    return pFree;
                else
                    return null;
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
                if (field.getFigure(pFree)==null)
                    return pFree;
                else
                    return null;
            }
            if (sameFigures(field, p1, p3)) {
                pFree = new Point(getLimitedPosition(0, field.getSize() - 1 , i + 1),
                            getLimitedPosition(0, field.getSize() - 1 , i + 1));
                if (field.getFigure(pFree)==null)
                    return pFree;
                else
                    return null;
            }
            if (sameFigures(field, p2, p3)) {
                pFree = new Point(i, getLimitedPosition(0, field.getSize() - 1 , i + 2));
                if (field.getFigure(pFree)==null)
                    return pFree;
                else
                    return null;
            }
        }
        return null;
    }

    private boolean sameFigures(final Field field, final Point p1, final Point p2) {
        if (field.getFigure(p1) != null && field.getFigure(p2) != null
                && field.getFigure(p1).equals(field.getFigure(p2))) {
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
                if (field.getFigure(point) != null)
                    return false;
            }
        }
        return true;
    }

}