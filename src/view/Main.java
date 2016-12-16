package view;

import model.*;
import controllers.*;

public class Main {

    public static void main (String[] args) {
//        testCurrentMove();
//        testMenuView();
//        testWinnerController();
//          testRandom();
        testAICoordinateGetter();
    }

    public static void testAICoordinateGetter() {
        AICoordinateGetter aiCoordinateGetter = new AICoordinateGetter();
        WinnerController winnerController = new WinnerController();
        Field field = new Field();
        // 1 step
        Point pTest = aiCoordinateGetter.getMoveCoordinate(field);
        field.setFigure(pTest, Figure.X);
        System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        // 2 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 3 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 4 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 5 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 6 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 7 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 8 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.O);
            System.out.println("O's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // 9 step
        pTest = aiCoordinateGetter.getMoveCoordinate(field);
        if (pTest!=null) {
            field.setFigure(pTest, Figure.X);
            System.out.println("X's step: " + pTest.getX() + "," + pTest.getY());
        }
        else
            System.out.println("pTest is null");
        System.out.println("The winner is " + winnerController.getWinner(field));
        // Creating game
        Player player1 = new Player("Tim", Figure.X);
        Player player2 = new Player("Alex", Figure.O);
        Game game = new Game(player1, player2, field, "Current game");
        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);

//        Point pTest = aiCoordinateGetter.getOneOfThreeInRow(field);
//        if (pTest!=null)
//            System.out.println(pTest.getX() + "," + pTest.getY());
//        else
//            System.out.println("pTest is null");
//        System.out.println("The field is empty? - " + aiCoordinateGetter.isEmptyField(field));
    }

    public static void testRandom() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(2, 0);
        Point p4 = new Point(0, 1);
        Point p5 = new Point(1, 1);
        Point p6 = new Point(2, 1);
        Point p7 = new Point(0, 2);
//        Point p8 = new Point(1, 2);
//        Point p9 = new Point(2, 2);
        Field field = new Field();
        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);
        field.setFigure(p4, Figure.O);
        field.setFigure(p5, Figure.X);
        field.setFigure(p6, Figure.O);
        field.setFigure(p7, Figure.X);
        //field.setFigure(p8, Figure.O);
        //field.setFigure(p9, Figure.O);
        RandomCoordinateGetter randomCoordinateGetter = new RandomCoordinateGetter();
        Point testPoint = randomCoordinateGetter.getMoveCoordinate(field);
        System.out.println("Radnom X coordinate: " + testPoint.getX());
        System.out.println("Radnom Y coordinate: " + testPoint.getY());
    }

    public static void testCurrentMove() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Field mainField = new Field();
        mainField.setFigure(point1, Figure.X);
        mainField.setFigure(point2, Figure.O);
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
        Field field = new Field();
        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.X);
        field.setFigure(p3, Figure.X);
        field.setFigure(p4, Figure.O);
//        field.setFigure(p5, "0");
//        field.setFigure(p6, "");
//        field.setFigure(p7, "");
//        field.setFigure(p8, "");
//        field.setFigure(p9, "X");

        WinnerController winnerController = new WinnerController();
        System.out.println("The winner is " + winnerController.getWinner(field));
    }

    public static  void  testConsoleView() {
        Player player1 = new Player("Tim", Figure.X);
        Player player2 = new Player("Lena", Figure.O);
        Field field = new Field();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(2, 0);
        Point p4 = new Point(0, 1);
        Point p5 = new Point(1, 1);
        Point p6 = new Point(2, 1);
        Point p7 = new Point(0, 2);
        Point p8 = new Point(1, 2);
        Point p9 = new Point(2, 2);
        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.X);
        field.setFigure(p3, Figure.O);
        field.setFigure(p4, Figure.O);
//        field.setFigure(p5, Figure.O);
//        field.setFigure(p6, Figure.O);
//        field.setFigure(p7, Figure.O);
//        field.setFigure(p8, Figure.O);
//        field.setFigure(p9, Figure.O);
        Game game = new Game(player1, player2, field, "New Game");
        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
    }


}