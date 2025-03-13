package Simulation;

import Entities.Coordinates;
import Entities.Entity;

import java.util.HashMap;

public class Map {

    private final Integer mapHeight;
    private final Integer mapWidth;
    private final HashMap<Coordinates, Entity> map;
    private final HashMap<Coordinates, Entity> copyOfField;

    public Map() {
        mapHeight = 15;
        mapWidth = 15;
        map = new HashMap<>();
        copyOfField = new HashMap<>(map);
    }

    public Map(Integer mapHeight, Integer mapWidth) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        map = new HashMap<>();
        copyOfField = new HashMap<>(map);
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

    public HashMap<Coordinates, Entity> getCopyOfField() {
        return copyOfField;
    }
}
