package controllers;

import model.*;

public class WinnerController {
    // BEGIN (write your solution here)
    public Figure getWinner (Field field) {
//        Point p1 = new Point();
//        Point p2 = new Point();
        Point p = new Point(0,0);
        int identicalAmount;
        // finding winner in lines
        for (int y = 0; y < field.getSize(); y = y + 1) {
            identicalAmount = 0;
            for (int x = 0; x < field.getSize() - 1; x = x + 1) {
                Point p1 = new Point(x , y);
                p = p1;
                Point p2 = new Point(x + 1, y);
                if (sameNearbyFigures(field, p1, p2)) {
                    identicalAmount = identicalAmount + 1;
                }
            }
            if (identicalAmount == field.getSize() - 1) {
                return field.getFigure(p);
            }
        }
        // finding winner in rows
        for (int x = 0; x < field.getSize(); x = x + 1) {
            identicalAmount = 0;
            for (int y = 0; y < field.getSize() - 1; y = y + 1) {
                Point p1 = new Point(x, y);
                p = p1;
                Point p2 = new Point(x, y + 1);
                if (sameNearbyFigures(field, p1, p2)) {
                    identicalAmount = identicalAmount + 1;
                }
            }
            if (identicalAmount == field.getSize() - 1) {
                return field.getFigure(p);
            }
        }
        // finding winner in straight diagonal
        identicalAmount = 0;
        for (int i = 0; i < field.getSize() - 1; i = i + 1) {
            Point p1 = new Point(i, i);
            p = p1;
            Point p2 = new Point(i + 1, i + 1);
            if (sameNearbyFigures(field, p1, p2)) {
                identicalAmount = identicalAmount + 1;
            }
        }

        if (identicalAmount == field.getSize() - 1) {
            return field.getFigure(p);
        }
        // finding winner in reverse diagonal
        identicalAmount = 0;
        for (int i = 0; i < field.getSize() - 1; i = i + 1) {
            Point p1 = new Point(i, field.getSize() - i - 1);
            p = p1;
            Point p2 = new Point(i + 1, field.getSize() - i - 2);
            if (sameNearbyFigures(field, p1, p2)) {
                identicalAmount = identicalAmount + 1;
            }
        }
        if (identicalAmount == field.getSize() - 1) {
            return field.getFigure(p);
        }
        return null;
    }

    private boolean sameNearbyFigures (Field field, Point p1, Point p2) {
        if (field.getFigure(p1) != null && field.getFigure(p2) != null
                && field.getFigure(p1).equals(field.getFigure(p2))) {
            return true;
        }
        return false;
    }
    // END

}