package view;

import model.*;
import java.util.Random;
import exceptions.InvalidPointException;

public class RandomCoordinateGetter{

    public Point getMoveCoordinate(Field field) {
        Random random = new Random();
        Point point;
        Figure figure;
        try {
            do {
                point = new Point(random.nextInt(field.getSize()), random.nextInt(field.getSize()));
            } while (field.getFigure(point) != null);
            return point;
        }
        catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

}
