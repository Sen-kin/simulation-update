package Simulation;

import Creatures.*;
import Entities.*;
import StaticEntities.*;

import java.beans.BeanProperty;


public class Actions {
    private final Integer herbivoreSpawnRate;
    private final Integer predatorSpawnRate;
    private final Integer grassSpawnRate;
    private final Integer rockSpawnRate;
    private final Integer treeSpawnRate;

    public Actions() {
        this.herbivoreSpawnRate = 2;
        this.predatorSpawnRate = 1;
        this.grassSpawnRate = 5;
        this.rockSpawnRate = 10;
        this.treeSpawnRate = 80;
    }

    public Actions(Integer herbivoreSpawnRate, Integer predatorSpawnRate, Integer grassSpawnRate, Integer rockSpawnRate, Integer treeSpawnRate) {
        this.herbivoreSpawnRate = herbivoreSpawnRate;
        this.predatorSpawnRate = predatorSpawnRate;
        this.grassSpawnRate = grassSpawnRate;
        this.rockSpawnRate = rockSpawnRate;
        this.treeSpawnRate = treeSpawnRate;
    }

    private void fillMapWithEntities (Map map){
        for (int i = 0; i < map.getMapHeight(); i++) {
            for (int j = 0; j < map.getMapWidth(); j++) {
                Coordinates coordinatesToSpawn = getRandomFreeCoordinates(map);
                map.getMap().put(coordinatesToSpawn, spawnEntity(coordinatesToSpawn));
            }
        }
    }

    void initAction(Map map){
        fillMapWithEntities(map);
        Renderer.renderMap(map);
    }

    private Coordinates getRandomFreeCoordinates(Map map){
        Coordinates placeForEntity = new Coordinates((int)(Math.random() * map.getMapHeight()),
                                                     (int)(Math.random() * map.getMapWidth())
                                                     );
        while (map.getMap().containsKey(placeForEntity)){
            placeForEntity = new Coordinates((int)(Math.random() * map.getMapHeight()),
                                             (int)(Math.random() * map.getMapWidth())
                                             );
        }
        return placeForEntity;
    }


    private Entity spawnEntity(Coordinates coordinates) {
       int number = (int)(Math.random() * 100 + 1);

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

}

