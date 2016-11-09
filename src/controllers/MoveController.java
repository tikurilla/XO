package controllers;
import model.*;

public class MoveController {
    private static final int MIN_FIELDSIZE = 0;
    private static final int MAX_FIELDSIZE = 2;

    // applyFigure checks whether it's possible to set a figure on this point
    public boolean applyFigure (Field field, Point point, String figure) {
        if (!checkCoordinate(point.x) || !checkCoordinate(point.y)) {
            assert point.x >= 0;
            assert point.y >= 0;
            return false;}
        else {
            if (field.getFigure(point) != null){
                return false;
            }
            else {
                field.setFigure(point, figure);
                return true;
            }
        }

    }

    // checkCoordinate checks whether coordinate inside field size
    private static boolean checkCoordinate(final int coordinate) {
        return !(coordinate < MIN_FIELDSIZE || coordinate > MAX_FIELDSIZE);
    }

}
