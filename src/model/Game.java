package model;

public class Game {

    private Player player1;

    private Player player2;

    private Field field;

    private String name;

    public Game(Player player1, Player player2, Field field, String name) {
        this.player1 = player1;
        this.player2 = player2;
        this.field = field;
        this.name = name;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

}