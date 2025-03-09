package Creatures;

import Entities.Coordinates;

public class Predator extends Creature{

    private static final Integer attackStrength = 1;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        sprite = "🐺 ";
    }




    @Override
    void makeMove() {

    }
}
