package controllers;

import model.*;

public class WinnerController {
    // BEGIN (write your solution here)
    public String getWinner (Field field) {
        Point p1 = new Point();
        Point p2 = new Point();
        int identicalAmount;
        // finding winner in lines
        for (int y = 0; y < field.getSize(); y = y + 1) {
            identicalAmount = 0;
            for (int x = 0; x < field.getSize() - 1; x = x + 1) {
                p1.x = x; p1.y = y;
                p2.x = x + 1; p2.y = y;
                if (sameNearbyFigures(field, p1, p2)) {
                    identicalAmount = identicalAmount + 1;
                }
            }
            if (identicalAmount == field.getSize() - 1) {
                return field.getFigure(p1);
            }
        }
        // finding winner in rows
        for (int x = 0; x < field.getSize(); x = x + 1) {
            identicalAmount = 0;
            for (int y = 0; y < field.getSize() - 1; y = y + 1) {
                p1.x = x; p1.y = y;
                p2.x = x; p2.y = y + 1;
                if (sameNearbyFigures(field, p1, p2)) {
                    identicalAmount = identicalAmount + 1;
                }
            }
            if (identicalAmount == field.getSize() - 1) {
                return field.getFigure(p1);
            }
        }
        // finding winner in straight diagonal
        identicalAmount = 0;
        for (int i = 0; i < field.getSize() - 1; i = i + 1) {
            p1.x = i; p1.y = i;
            p2.x = i + 1; p2.y = i + 1;
            if (sameNearbyFigures(field, p1, p2)) {
                identicalAmount = identicalAmount + 1;
            }
        }

        if (identicalAmount == field.getSize() - 1) {
            return field.getFigure(p1);
        }
        // finding winner in reverse diagonal
        identicalAmount = 0;
        for (int i = 0; i < field.getSize() - 1; i = i + 1) {
            p1.x = i; p1.y = field.getSize() - i - 1;
            p2.x = i + 1; p2.y = field.getSize() - i - 2;
            if (sameNearbyFigures(field, p1, p2)) {
                identicalAmount = identicalAmount + 1;
            }
        }
        if (identicalAmount == field.getSize() - 1) {
            return field.getFigure(p1);
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