package Simulation;

import Entities.Coordinates;
import Entities.Entity;


import java.util.HashMap;
import java.util.Scanner;

public class Simulation {
    private final Map simulationMap;
    private final HashMap<Coordinates, Entity> field;

    public Simulation() {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Введите высоту и ширину поля через пробел: ");
        Integer mapHeight = scanner.nextInt();
        Integer mapWidth = scanner.nextInt();
        simulationMap = new Map(mapHeight, mapWidth);
        field = simulationMap.getField();
    }

    public Map getSimulationMap() {
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
