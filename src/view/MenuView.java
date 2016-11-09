package view;

import java.util.Scanner;

public class MenuView {
    private static final int START_GAME = 1;

    private static final int LOAD_GAME = 2;

    private static final int SETTINGS = 3;

    private static final int EXIT = 4;

    public int showMenuWithResult() {
        System.out.println(START_GAME + " - Start Game");
        System.out.println(LOAD_GAME + " - Load Game");
        System.out.println(SETTINGS + " - Settings");
        System.out.println(EXIT + " - Exit");
        System.out.println("->");
        final Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case START_GAME :
                System.out.println("Start!");
                return choice;
            case LOAD_GAME :
                System.out.println("Load!");
                return choice;
            case SETTINGS :
                return choice;
            case EXIT :
                return choice;
            default :
                System.out.println("Select valid menu number!");
                return 0;
        }
    }

}
