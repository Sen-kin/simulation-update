package Simulation;

import Creatures.*;
import Entities.*;
import StaticEntities.*;

import java.util.HashMap;


public class Actions {
    private final Integer herbivoreSpawnRate;
    private final Integer predatorSpawnRate;
    private final Integer grassSpawnRate;
    private final Integer rockSpawnRate;
    private final Integer treeSpawnRate;

    public Actions() {
        this.herbivoreSpawnRate = 1;
        this.predatorSpawnRate = 1;
        this.grassSpawnRate = 5;
        this.rockSpawnRate = 0;
        this.treeSpawnRate = 0;
    }


    public Actions(Integer herbivoreSpawnRate, Integer predatorSpawnRate, Integer grassSpawnRate, Integer rockSpawnRate, Integer treeSpawnRate) {
        this.herbivoreSpawnRate = herbivoreSpawnRate;
        this.predatorSpawnRate = predatorSpawnRate;
        this.grassSpawnRate = grassSpawnRate;
        this.rockSpawnRate = rockSpawnRate;
        this.treeSpawnRate = treeSpawnRate;
    }

    private void fillMapWithEntities(Map map) {
        for (int i = 0; i < map.getMapHeight(); i++) {
            for (int j = 0; j < map.getMapWidth(); j++) {
                Coordinates coordinatesToSpawn = getRandomFreeCoordinates(map);
                map.getField().put(coordinatesToSpawn, spawnEntity(coordinatesToSpawn));
            }
        }
    }

    private Coordinates getRandomFreeCoordinates(Map map) {
        Coordinates placeForEntity = new Coordinates((int) (Math.random() * map.getMapHeight()),
                (int) (Math.random() * map.getMapWidth())
        );
        while (map.getField().containsKey(placeForEntity)) {
            placeForEntity = new Coordinates((int) (Math.random() * map.getMapHeight()),
                    (int) (Math.random() * map.getMapWidth())
            );
        }
        return placeForEntity;
    }

    private Entity spawnEntity(final Coordinates coordinates) {
        int number = (int) (Math.random() * 100 + 1);

        if (number <= treeSpawnRate) {
            return new Tree(coordinates);
        } else if (number <= treeSpawnRate + rockSpawnRate) {
            return new Rock(coordinates);
        } else if (number <= treeSpawnRate + rockSpawnRate + grassSpawnRate) {
            return new Grass(coordinates);
        } else if (number <= treeSpawnRate + rockSpawnRate + grassSpawnRate + herbivoreSpawnRate) {
            return new Herbivore(coordinates);
        } else if (number <= treeSpawnRate + rockSpawnRate + grassSpawnRate + herbivoreSpawnRate + predatorSpawnRate) {
            return new Predator(coordinates);
        }

        return null;
    }

    private Coordinates getCoordinatesForGrass(final Map map) {
        Coordinates coordinatesForGrass = getRandomFreeCoordinates(map);
        while (map.getField().get(coordinatesForGrass) instanceof Creature ||
                map.getField().get(coordinatesForGrass) instanceof Rock)
            coordinatesForGrass = getRandomFreeCoordinates(map);

        return coordinatesForGrass;
    }

    void initAction(final Map map) {
        fillMapWithEntities(map);
        Renderer renderer = new Renderer();
        renderer.renderMap(map);
    }

    void moveAction(final HashMap<Coordinates, Entity> map) {
        for (Coordinates key : map.keySet()) {
            Entity currentCellEntity = map.get(key);
            if (currentCellEntity instanceof Creature) {
                ((Creature) currentCellEntity).makeMove();
            }
        }
    }

    void growGrassAction(final Map map) {
        int grassCount = (int) (Math.random() * (map.getField().size()) / 5 + 1);
        for (int i = 0; i < grassCount; i++) {
            Coordinates coordinatesToSpawn = getCoordinatesForGrass(map);
            map.getCopyOfField().put(coordinatesToSpawn, new Grass(coordinatesToSpawn));
        }
    }

    boolean stopAction(final HashMap<Coordinates, Entity> map) {
        return areHerbivoresExist(map);
    }

    boolean areHerbivoresExist(final HashMap<Coordinates, Entity> field) {
        boolean herbivoreExists = false;
        for (Coordinates key : field.keySet()) {
            herbivoreExists = field.get(key) instanceof Herbivore;
            if (herbivoreExists) return herbivoreExists;
        }
        return herbivoreExists;
    }

    boolean isGrassExists(final HashMap<Coordinates, Entity> field) {
        boolean grassExists = false;
        for (Coordinates key : field.keySet()) {
            grassExists = field.get(key) instanceof Grass;
            if (grassExists) return grassExists;
        }
        return grassExists;
    }

    void makeOneTurnAction(final Map simulationMap) {
        Renderer renderer = new Renderer();
        moveAction(simulationMap.getField());
        mergeCopyToOrigin(simulationMap.getField(), simulationMap.getCopyOfField());
        renderer.renderMap(simulationMap);
    }

   private void mergeCopyToOrigin(HashMap<Coordinates, Entity> origin, HashMap<Coordinates, Entity> copy){
        origin.putAll(copy);
    }
}

