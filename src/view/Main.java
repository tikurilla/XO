package view;
import controllers.CurrentMoveController;
import controllers.WinnerController;
import model.*;

public class Main {

    public static void main (String[] args) {
        //testCurrentMove();
        //testMenuView();
        testWinnerController();
    }

    public static void testCurrentMove() {
        Point point1 = new Point();
        point1.x = 0; point1.y = 0;
        Point point2 = new Point();
        point2.x = 1; point2.y = 1;
        Field mainField = new Field();
        mainField.setFigure(point1, "X");
        mainField.setFigure(point2, "0");
        CurrentMoveController CMC = new CurrentMoveController();
        System.out.println("Next move is - " + CMC.currentMove(mainField));
    }

    public static  void  testMenuView () {
        MenuView menuView = new MenuView();
        int itest = menuView.showMenuWithResult();
    }

    public  static  void testWinnerController() {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();
        Point p5 = new Point();
        Point p6 = new Point();
        Point p7 = new Point();
        Point p8 = new Point();
        Point p9 = new Point();
        p1.x = 0; p1.y = 0;
        p2.x = 1; p2.y = 0;
        p3.x = 2; p3.y = 0;
        p4.x = 0; p4.y = 1;
        p5.x = 1; p5.y = 1;
        p6.x = 2; p6.y = 1;
        p7.x = 0; p7.y = 2;
        p8.x = 1; p8.y = 2;
        p9.x = 2; p9.y = 2;
        Field field = new Field();
        field.setFigure(p1, "0");
        field.setFigure(p2, "0");
        field.setFigure(p3, "X");
        field.setFigure(p4, "X");
        field.setFigure(p5, "X");
        field.setFigure(p6, "0");
        field.setFigure(p7, "0");
        field.setFigure(p8, "0");
        field.setFigure(p9, "0");

        WinnerController winnerController = new WinnerController();
        System.out.println("The winner is " + winnerController.getWinner(field));
    }


}
