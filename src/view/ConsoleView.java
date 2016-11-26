package view;

import model.Game;
import model.Field;
import model.Point;


public class ConsoleView {

    public Point getMoveCoordinate(final Field field) {
        return new Point(0, 0);
    }

    public void show(final Game game) {
        final Field field = game.getField();
        final StringBuilder fieldBuilder = new StringBuilder();
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                generateSeparator(fieldBuilder);
            generateLine(field, y, fieldBuilder);
        }
        System.out.println(fieldBuilder.toString());
    }

    public boolean move(final Game game) {
        return true;
    }

    void generateLine(final Field field,
                      final int y,
                      final StringBuilder sb) {
        // BEGIN (write your solution here)
        for (int i = 0; i < field.getSize(); i++) {
            Point point = new Point(i, y);
            if (i != 0)
                sb.append('|');
            sb.append(" ");
            if (field.getFigure(point)!=null) sb.append(field.getFigure(point));
            else sb.append(" ");
            sb.append(" ");
        }
        sb.append("\n");
        // END
    }

    void generateSeparator(final StringBuilder sb) {
        // BEGIN (write your solution here)
        final String separator = "~~~~~~~~~~~\n";
        sb.append(separator);
        // END
    }

}
