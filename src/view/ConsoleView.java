package view;

import exceptions.InvalidPointException;
import model.*;

import java.util.Scanner;

public class ConsoleView {

    private int pointX;

    private int pointY;

    public Point getMoveCoordinate(final Field field) {
        return new Point(0, 0);
    }

    public void show(final Game game) {
        final Field field = game.getField();
        final StringBuilder fieldBuilder = new StringBuilder();
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                generateSeparator(fieldBuilder, field);
            generateLine(field, y, fieldBuilder);
        }
        System.out.println(fieldBuilder.toString());
    }

    public Point getCoordinates(Figure figure) {
        System.out.println(figure.getFigure() + ", enter x-coordinate for new figure:");
        final Scanner scanner1 = new Scanner(System.in);
        pointX = scanner1.nextInt();
        System.out.println(figure.getFigure() + ", enter y-coordinate for new figure:");
        final Scanner scanner2 = new Scanner(System.in);
        pointY = scanner2.nextInt();
        return new Point(pointX, pointY);
    }

    public boolean move(final Game game) {
        return true;
    }

    void generateLine(final Field field,
                      final int y,
                      final StringBuilder sb) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                Point point = new Point(i, y);
                if (i != 0)
                    sb.append('|');
                sb.append(" ");
                if (field.getFigure(point)!=null)
                    sb.append(field.getFigure(point));
                else sb.append(" ");
                sb.append(" ");
            }
            sb.append("\n");
        }
        catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    void generateSeparator(final StringBuilder sb , final Field field) {
        for(int i = 0; i < field.getSize() - 1; i++) {
            sb.append("----");
        }
        sb.append("---\n");
    }

}
