package Creatures;

import Entities.Coordinates;

public class Predator extends Creature{

    private static final Integer attackStrength = 1;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        sprite = "🐺 ";
    }




    @Override
    public void makeMove() {
        PathFinder pathFinder = new PathFinder();
        Coordinates coordinatesToStay = pathFinder.bestCellToStayForPredator(this.getCoordinates());

        if (pathFinder.checkIfTheCellContainsHerbivore(coordinatesToStay)){

        }
    }
}
