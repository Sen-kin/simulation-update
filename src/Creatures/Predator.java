package Creatures;

import Entities.Coordinates;

public class Predator extends Creature{

    private static final Integer attackStrength = 1;


    public Predator(Coordinates coordinates) {
        super(coordinates);
        sprite = "🐺 ";
        moveLength = 2;
    }




    @Override
    public void makeMove() {

        for (int i = 0; i < moveLength; i++) {


            PathFinder pathFinder = new PathFinder();
            Coordinates cellToMove = pathFinder.bestCellToStayForPredator(getCoordinates());

            if (pathFinder.checkIfTheCellContainsHerbivore(cellToMove)) {
                attackHerbivore(cellToMove);
                return;
            }
            simulationMap.removeEntityFromMap(getCoordinates());
            simulationMap.placeEntityOnMap(cellToMove, this);
        }
    }

    private void attackHerbivore (Coordinates herbivoreToAttack){
       Herbivore attackedHerbivore = ((Herbivore) simulationMap.getField().get(herbivoreToAttack));

       attackedHerbivore.setHealth(attackedHerbivore.getHealth() - attackStrength);

       if (attackedHerbivore.getHealth() == 0) {
           simulationMap.removeEntityFromMap(herbivoreToAttack);
           attackedHerbivore.dead();
       }
    }
}
