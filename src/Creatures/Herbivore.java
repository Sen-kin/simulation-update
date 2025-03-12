package Creatures;

import Entities.Coordinates;

public class Herbivore extends Creature{
    private Integer health = 1;


    public Herbivore(Coordinates coordinates){
        super(coordinates);
        sprite = "🐓";
    }

    @Override
    public void makeMove() {
        PathFinder pathFinder = new PathFinder();

        Coordinates cellToMove = pathFinder.bestCellToStayForHerbivore(this.getCoordinates());

        if (pathFinder.checkIfTheCellContainsGrass(cellToMove)){
                eatGrass(cellToMove);
        }


        setCoordinates(cellToMove);
    }

    private void eatGrass (Coordinates grassToEat){

    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }


}
