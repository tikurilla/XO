package view;

import exceptions.InvalidPointException;
import model.*;
import controllers.*;

public class Main {

    private static final int ONE_PLAYER_GAME = 1;

    private static final int TWO_PLAYER_GAME = 2;

    private static final int EXIT = 3;

    public static void main (String[] args) {
        final int fieldSize = 3;
        MenuView menuView = new MenuView();
        if (menuView.showMenuWithResult() == TWO_PLAYER_GAME) {
            Field field = new Field(fieldSize);
            Player player1 = new Player(menuView.getPlayer1(),Figure.X);
            Player player2 = new Player(menuView.getPlayer1(),Figure.O);
            CurrentMoveController currentMoveController = new CurrentMoveController();
            MoveController moveController = new MoveController();
            Game game = new Game.Builder()
                    .player1(player1)
                    .player2(player2)
                    .field(field)
                    .name("New game")
                    .build();
            ConsoleView consoleView = new ConsoleView();
            WinnerController winnerController = new WinnerController();
            do {
                consoleView.show(game);
                Point currentPoint = consoleView.getCoordinates(currentMoveController.currentMove(field));
                moveController.move(field, currentPoint, currentMoveController.currentMove(field));
                if (field.fieldIsFull() && winnerController.getWinner(field)==null) {
                    System.out.println("Dead heat. No winner in this game :(");
                    break;
                }
            } while (winnerController.getWinner(field)==null);
            if (winnerController.getWinner(field)!=null)
                System.out.println("The winner is - " + winnerController.getWinner(field));
        }
    }

    public static void testAICoordinateGetter() {
        AICoordinateGetter aiCoordinateGetter = new AICoordinateGetter();
        WinnerController winnerController = new WinnerController();
        final int fieldSize = 3;
        Field field = new Field(fieldSize);
        // 1 step
        Point pTest = aiCoordinateGetter.getMoveCoordinate(field);
        MoveController moveController = new MoveController();
        moveController.move(field, pTest, Figure.X);
        System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        // 2 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 3 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 4 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 5 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 6 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 7 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 8 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 9 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            moveController.move(field, pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // Creating game
        Player player1 = new Player("Tim", Figure.X);
        Player player2 = new Player("Alex", Figure.O);
        Game game = new Game.Builder()
                .player1(player1)
                .player2(player2)
                .field(field)
                .name("Current game")
                .build();
        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);

//        Point pTest = aiCoordinateGetter.getOneOfThreeInRow(field);
//        if (pTest!=null)
//            System.out.println(pTest.getX() + "," + pTest.getY());
//        else
//            System.out.println("pTest is null");
//        System.out.println("The field is empty? - " + aiCoordinateGetter.isEmptyField(field));
    }

    public static void testCurrentMove() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        final int fieldSize = 3;
        Field mainField = new Field(fieldSize);
        MoveController moveController = new MoveController();
        moveController.move(mainField, point1, Figure.X);
        moveController.move(mainField, point2, Figure.O);
        CurrentMoveController CMC = new CurrentMoveController();
        System.out.println("Next move is - " + CMC.currentMove(mainField));
    }

    public static  void  testMenuView () {
        MenuView menuView = new MenuView();
        int itest = menuView.showMenuWithResult();
    }

    public  static  void testWinnerController() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(2, 0);
        Point p4 = new Point(0, 1);
        Point p5 = new Point(1, 1);
        Point p6 = new Point(2, 1);
        Point p7 = new Point(0, 2);
        Point p8 = new Point(1, 2);
        Point p9 = new Point(2, 2);
        final int fieldSize = 3;
        Field field = new Field(fieldSize);
        MoveController moveController = new MoveController();
        moveController.move(field, p1, Figure.X);
        moveController.move(field, p2, Figure.X);
        moveController.move(field, p3, Figure.X);
        moveController.move(field, p4, Figure.O);

        WinnerController winnerController = new WinnerController();
        System.out.println("The winner is " + winnerController.getWinner(field));
    }

    public static  void  testConsoleView() {
        Player player1 = new Player("Tim", Figure.X);
        Player player2 = new Player("Lena", Figure.O);
        final int fieldSize = 3;
        Field field = new Field(fieldSize);
        MoveController moveController = new MoveController();

        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(2, 0);
        Point p4 = new Point(0, 1);
        Point p5 = new Point(1, 1);
        Point p6 = new Point(2, 1);
        Point p7 = new Point(0, 2);
        Point p8 = new Point(1, 2);
        Point p9 = new Point(2, 2);
        moveController.move(field, p1, Figure.X);
        moveController.move(field, p2, Figure.X);
        moveController.move(field, p3, Figure.O);
        moveController.move(field, p4, Figure.O);
        Game game = new Game.Builder()
                .player1(new Player("Timur", Figure.X))
                .player2(new Player("Lena", Figure.O))
                .field(field)
                .name("XO")
                .build();
        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
    }
}