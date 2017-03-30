package view;

import exceptions.EmptyLineException;

import java.util.Scanner;

public class MenuView {
    private static final int ONE_PLAYER_GAME = 1;

    private static final int TWO_PLAYER_GAME = 2;

    private static final int EXIT = 3;

    private String player1;

    private String player2;

    public int showMenuWithResult() {
        System.out.println(ONE_PLAYER_GAME + " - One Player Game");
        System.out.println(TWO_PLAYER_GAME + " - Two Player Game");
        System.out.println(EXIT + " - Exit");
        System.out.println("->");
        final Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        boolean playersHaveEmptyNames = false;
        switch (choice) {
            case TWO_PLAYER_GAME :
                System.out.println("Collect some information..");
                do {
                    try {
                        playersHaveEmptyNames = startGame();
                    }
                    catch (EmptyLineException e) {
                        System.out.println("Please enter valid name."); //e.printStackTrace();
                    }
                } while (playersHaveEmptyNames==false);
                return choice;
            case EXIT :
                return choice;
            default :
                System.out.println("Select valid menu number!");
                return 0;
        }
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    private boolean startGame() throws EmptyLineException {
        final Scanner scannerP1 = new Scanner(System.in);
        System.out.println("1st player will play X figures. Enter 1st player name: ");
        player1 = scannerP1.nextLine();
        if (player1.isEmpty())
            throw new EmptyLineException();
        final Scanner scannerP2 = new Scanner(System.in);
        System.out.println("2nd player will play O figures. Enter 2nd player name: ");
        player2 = scannerP2.nextLine();
        if (player2.isEmpty())
            throw new EmptyLineException();
        if (player1.isEmpty()==false && player2.isEmpty()==false)
            return true;
        else
            return false;
        // <TASK>
        // вынести код по вводу имени каждого игрока в отдельный метод ввиду того, что при проверке на EmptyLineException()
        // для второго игрока в случае пустой сткроки нужно вновь ввести имя 1-го игрока.
        // </TASK>
    }



}
