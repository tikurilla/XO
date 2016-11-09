package model;

import model.Field;
import model.Player;

public class Game {

    private static final int MIN_FIELDSIZE = 0;

    private static final int MAX_FIELDSIZE = 2;

    private Player[] players;

    public Field field;

    public String name;

    public Player currentPlayer(){
        return null;
    }

    public boolean move(final int x, final int y) {
        if (!checkCoordinate(x) || !checkCoordinate(y)) {
            assert x >= 0;
            assert x >= 0;
            return false;}
        return true;
    }

    private static boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_FIELDSIZE || coordinate > MAX_FIELDSIZE) {
            return false;
        }
        return true;
    }

}