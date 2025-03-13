package Creatures;

import Entities.Coordinates;
import Entities.Entity;
import Simulation.Simulation;
import Simulation.Map;

import java.util.HashMap;


public abstract class Creature extends Entity {
    protected final Map map = Simulation.getSimulationMap();
    protected final HashMap<Coordinates, Entity> fieldWhereMoving = map.getCopyOfField();

    public Creature(Coordinates coordinates)
    {
        super(coordinates);
    }

   public abstract void makeMove();


}
