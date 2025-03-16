package Simulation;

import Creatures.Creature;
import Entities.Coordinates;
import Entities.Entity;

import java.util.HashMap;

public class Map {

    private final Integer mapHeight;
    private final Integer mapWidth;
    private final HashMap<Coordinates, Entity> map;

    public Map() {
        mapHeight = 15;
        mapWidth = 15;
        map = new HashMap<>();
    }

    public Map(Integer mapHeight, Integer mapWidth) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        map = new HashMap<>();
    }

    public Integer getMapHeight() {
        return mapHeight;
    }

    public Integer getMapWidth() {
        return mapWidth;
    }

    public HashMap<Coordinates, Entity> getField() {
        return map;
    }

    public void placeEntityOnMap(Coordinates coordinates, Creature creature){
        map.remove(coordinates);
        map.put(coordinates, creature);
        creature.setCoordinates(coordinates);
    }
    public void removeEntityFromMap(Coordinates coordinates){
        map.remove(coordinates);
        map.put(coordinates, null);
    }
}
