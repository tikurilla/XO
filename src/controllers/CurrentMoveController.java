package controllers;

import model.Field;
import model.Point;

public class CurrentMoveController {

    public String currentMove(Field field) {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < field.getSize(); i = i + 1) {
            for (int j = 0; j < field.getSize(); j = j + 1) {
                Point cPoint = new Point();
                cPoint.x = i;
                cPoint.y = j;
                if (field.getFigure(cPoint) == "X") {
                    xCount = xCount + 1;
                }
                if (field.getFigure(cPoint) == "0") {
                    oCount = oCount + 1;
                }
            }
        }
        if (xCount == oCount) {
            return "X";
        }
        if (xCount > oCount) {
            return "0";
        }
        return "X";
    }
}