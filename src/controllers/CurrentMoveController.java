package controllers;

import exceptions.InvalidPointException;
import model.Field;
import model.Figure;
import model.Point;

public class CurrentMoveController {

    public Figure currentMove(Field field) {
        int xCount = 0;
        int oCount = 0;

        for (int i = 0; i < field.getSize(); i = i + 1) {
            for (int j = 0; j < field.getSize(); j = j + 1) {
                Point cPoint = new Point(i, j);
                try {
                    if (field.getFigure(cPoint) == Figure.X) {
                        xCount = xCount + 1;
                    }
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }
                try {
                    if (field.getFigure(cPoint) == Figure.O) {
                        oCount = oCount + 1;
                    }
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                }

            }
        }
        if (xCount == oCount) {
            return Figure.X;
        }
        if (xCount > oCount) {
            return Figure.O;
        }
        return Figure.X;
    }
}