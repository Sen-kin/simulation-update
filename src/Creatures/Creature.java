package Creatures;

import Entities.Coordinates;
import Entities.Entity;

import Simulation.Main;
import Simulation.Map;


public abstract class Creature extends Entity {
    protected Map simulationMap = Main.getSimulation().getSimulationMap();


    public Creature(Coordinates coordinates)
    {
        super(coordinates);
    }

   public abstract void makeMove();


}
