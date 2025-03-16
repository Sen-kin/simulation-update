package Simulation;

import Entities.Coordinates;
import Entities.Entity;


import java.util.HashMap;
import java.util.Scanner;

public class Simulation {
    private final Map simulationMap;
    private final HashMap<Coordinates, Entity> field;
    private final Integer cooldownBetweenFrames;

    public Simulation() {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Введите высоту, ширину поля и задержку между кадрами (в мс) через пробел: ");
        Integer mapHeight = scanner.nextInt();
        Integer mapWidth = scanner.nextInt();
        cooldownBetweenFrames = scanner.nextInt();
        simulationMap = new Map(mapHeight, mapWidth);
        field = simulationMap.getField();
    }

    public Map getSimulationMap() {
        return simulationMap;
    }

    void startSimulation() throws InterruptedException {

         Actions actions = new Actions(2, 1, 10, 1, 1);

         actions.initAction(simulationMap);

         Thread.sleep(cooldownBetweenFrames);

         while (actions.areHerbivoresExist(field))
         {
            actions.makeOneTurnAction(simulationMap);

            Thread.sleep(cooldownBetweenFrames);

            if (!actions.isGrassExists(field)) actions.growGrassAction(simulationMap);
         }
    }
}
