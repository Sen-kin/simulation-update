package Creatures;

import Entities.Coordinates;



public class Herbivore extends Creature{
    private Integer health = 1;
    private boolean alive;

    public Herbivore(Coordinates coordinates){
        super(coordinates);
        sprite = "🐓";
        alive = true;
    }

    @Override
    public void makeMove() {

        if(!alive) return;

        PathFinder pathFinder = new PathFinder();
        Coordinates cellToMove = pathFinder.bestCellToStayForHerbivore(getCoordinates());

        if (pathFinder.checkIfTheCellContainsGrass(cellToMove)){
                eatGrass(cellToMove);
                return;
        }
        simulationMap.removeEntityFromMap(getCoordinates());
        simulationMap.placeEntityOnMap(cellToMove, this);
    }

    private void eatGrass (Coordinates grassToEat){
        simulationMap.removeEntityFromMap(grassToEat);
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void dead(){
        this.alive = false;
    }
}
