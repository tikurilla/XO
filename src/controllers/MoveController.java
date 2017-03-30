package controllers;
import exceptions.AlreadyOccupiedException;
import exceptions.InvalidPointException;
import model.*;

public class MoveController {

    public void move (Field field, Point point, Figure figure) {
        try {
            field.setFigure(point, figure);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        } catch (AlreadyOccupiedException e) {
            System.out.println("Ooops.. Point is not empty");
        }
    }

}