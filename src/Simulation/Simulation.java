package Simulation;

import Entities.Coordinates;
import Entities.Entity;

import java.util.HashMap;

public class Simulation {
    static Map simulationMap = new Map();


    static void startSimulation() throws InterruptedException {

         HashMap<Coordinates, Entity> field = simulationMap.getField();
         HashMap<Coordinates, Entity> copyOfField = new HashMap<>(field);

         Actions actions = new Actions(2, 1, 10, 1, 1);

         actions.initAction(simulationMap);
         Thread.sleep(1000);

         while (actions.areHerbivoresExist(field)){
            actions.makeOneTurnAction(simulationMap);
            Thread.sleep(1000);
            if (!actions.isGrassExists(field)) actions.growGrassAction(simulationMap);
        }





    }
}
