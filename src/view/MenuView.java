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
//                do {
//                    playersHaveEmptyNames = startGame();
//                } while (playersHaveEmptyNames==true);
                while(player1==null) {
                    try {
                        player1 = this.getPlayerNameFromConsole(false);
                    }
                    catch (EmptyLineException e) {
                        System.out.println("Please enter valid name.");
                    }
                }
                while(player2==null) {
                    try {
                        player2 = this.getPlayerNameFromConsole(true);
                    }
                    catch (EmptyLineException e) {
                        System.out.println("Please enter valid name.");
                    }
                }
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

    private String getPlayerNameFromConsole(boolean playerNumber) throws EmptyLineException  {
        String player;
        final Scanner scannerP = new Scanner(System.in);
        if (!playerNumber) {
            System.out.println("1st player will play X figures. Enter 1st player name: ");
        }
        else {
            System.out.println("2nd player will play O figures. Enter 2nd player name: ");
        }
        player = scannerP.nextLine();
        if (player.isEmpty())
            throw new EmptyLineException();
        return player;
    }
}
