package model;

public class Player {

    public String name;

    public String figure;

    public Player(final String name, final String figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getPlayerName() {
        return this.name;
    }

    public String getPlayerFigure() { return this.figure; }

}