package view;

import model.Field;
import model.Point;

import java.awt.*;
import java.util.Random;

import controllers.MoveController;

import java.util.Random;

public class RandomCoordinateGetter implements ICoordinateGetter {

    public Point getMoveCoordinate(Field field) {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(field.getSize()), random.nextInt(field.getSize()));
        } while (field.getFigure(point) != null);
        return point;
    }

}
