package Simulation;

import Entities.Coordinates;
import Entities.Entity;


import java.util.HashMap;

public class Simulation {
    private static final Map simulationMap = new Map(3, 3);
    private final HashMap<Coordinates, Entity> field = simulationMap.getField();


    public static Map getSimulationMap() {
        return simulationMap;
    }

    void startSimulation() throws InterruptedException {

         Actions actions = new Actions(2, 1, 10, 1, 1);

         actions.initAction(simulationMap);

         Thread.sleep(1000);

         while (actions.areHerbivoresExist(field))
         {
            actions.makeOneTurnAction(simulationMap);
            Thread.sleep(1000);
            if (!actions.isGrassExists(field)) actions.growGrassAction(simulationMap);
         }
    }
}
