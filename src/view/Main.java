package view;
import controllers.CurrentMoveController;
import controllers.WinnerController;
import model.*;

public class Main {

    public static void main (String[] args) {
        //testCurrentMove();
        //testMenuView();
        //testWinnerController();
        testConsoleView();
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