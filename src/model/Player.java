package model;

public class Player {

    public String name;

    public Figure figure;

    public Player(final String name,
                  final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getPlayerName() {
        return this.name;
    }

    public Figure getPlayerFigure() { return this.figure; }

}