package Simulation;

import Entities.Coordinates;
import Entities.Entity;

import java.util.HashMap;

public class Map {

    private final Integer mapHeight;
    private final Integer mapWidth;
    private final HashMap<Coordinates, Entity> map;

    public Map() {
        this.mapHeight = 15;
        this.mapWidth = 15;
        this.map = new HashMap<>();
    }

    public Integer getMapHeight() {
        return mapHeight;
    }

    public Integer getMapWidth() {
        return mapWidth;
    }

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }


}
