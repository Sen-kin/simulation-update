package Creatures;

import Entities.Coordinates;
import Entities.Entity;
import Simulation.Map;
import StaticEntities.Grass;

import java.util.ArrayList;
import java.util.HashMap;

public class PathFinder {

    Map map = new Map();
    HashMap<Coordinates, Entity> field = map.getField();

    private double findDistance(double a, double b){
        return Math.sqrt((Math.pow(a, 2)) + Math.pow(b, 2));
    }

    private boolean isNeighbor(Coordinates currentEntityCoordinates, Coordinates[] neighborsCoordinates){
        for  (Coordinates neighborCells: neighborsCoordinates){
            if (currentEntityCoordinates.equals(neighborCells)) return true;
        }
        return false;
    }

    private double findDistanceToNearestGrass(Coordinates herbivoreNeighbor){
            double minimalDistance = Double.MAX_VALUE;
            for (Coordinates cell: field.keySet()){
                Entity currentEntity = field.get(cell);
                if (currentEntity instanceof Grass){
                    double distance = findDistance
                            (
                                    currentEntity.getCoordinates().getCoordinateX() - herbivoreNeighbor.getCoordinateX(),
                                    currentEntity.getCoordinates().getCoordinateY() - herbivoreNeighbor.getCoordinateY()
                            );
                    if (distance <= minimalDistance){
                        minimalDistance = distance;
                    }
                }
            }
            return minimalDistance;
    }

    private double findDistanceToNearestHerbivore(Coordinates predatorNeighbor){
        double minimalDistance = Double.MAX_VALUE;
        for (Coordinates cell: field.keySet()){
            Entity currentEntity = field.get(cell);
            if (currentEntity instanceof Herbivore){
                double distance = findDistance
                        (
                                currentEntity.getCoordinates().getCoordinateX() - predatorNeighbor.getCoordinateX(),
                                currentEntity.getCoordinates().getCoordinateY() - predatorNeighbor.getCoordinateY()
                        );
                if (distance <= minimalDistance){
                    minimalDistance = distance;
                }
            }
        }
        return minimalDistance;
    }

    Coordinates bestCellToStayForHerbivore(Coordinates herbivorePosition){

        Coordinates bestCell = null;

            Coordinates[] neighbors = new Coordinates[]
                    {
                    new Coordinates(herbivorePosition.getCoordinateX() - 1, herbivorePosition.getCoordinateY()),
                    new Coordinates(herbivorePosition.getCoordinateX() + 1, herbivorePosition.getCoordinateY()),
                    new Coordinates(herbivorePosition.getCoordinateX(), herbivorePosition.getCoordinateY() - 1),
                    new Coordinates(herbivorePosition.getCoordinateX(), herbivorePosition.getCoordinateY() + 1)
                    };

            ArrayList<Coordinates> cellsToMoveOn = new ArrayList<>();

        for (Coordinates coordinates: field.keySet()){
             Entity currentEntity = field.get(coordinates);
             if (isNeighbor(coordinates, neighbors) && !(currentEntity instanceof Creature))
                 cellsToMoveOn.add(coordinates);
        }

        double minimalDistance = Double.MAX_VALUE;

        for (Coordinates cell: cellsToMoveOn)
        {
            double distance = findDistanceToNearestGrass(cell);

            if (distance <= minimalDistance) bestCell = cell;
        }

        return (bestCell == null)? herbivorePosition: bestCell;
    }

    Coordinates bestCellToStayForPredator(Coordinates predatorPosition){

        Coordinates bestCell = null;

        Coordinates[] neighbors = new Coordinates[]
                {
                        new Coordinates(predatorPosition.getCoordinateX() - 1, predatorPosition.getCoordinateY()),
                        new Coordinates(predatorPosition.getCoordinateX() + 1, predatorPosition.getCoordinateY()),
                        new Coordinates(predatorPosition.getCoordinateX(), predatorPosition.getCoordinateY() - 1),
                        new Coordinates(predatorPosition.getCoordinateX(), predatorPosition.getCoordinateY() + 1)
                };

        ArrayList<Coordinates> cellsToMoveOn = new ArrayList<>();

        for (Coordinates coordinates: field.keySet()){
            Entity currentEntity = field.get(coordinates);
            if (isNeighbor(coordinates, neighbors) && !(currentEntity instanceof Creature))
                cellsToMoveOn.add(coordinates);
        }

        double minimalDistance = Double.MAX_VALUE;
        for (Coordinates cell: cellsToMoveOn){
            double distance = findDistanceToNearestHerbivore(cell);

            if (distance <= minimalDistance) bestCell = cell;
        }
        return (bestCell == null)? predatorPosition: bestCell;
    }

    boolean checkIfTheCellContainsGrass (Coordinates cell){
        return map.getField().get(cell) instanceof Grass;
    }

    boolean checkIfTheCellContainsHerbivore (Coordinates cell){
        return map.getField().get(cell) instanceof Herbivore;
    }

}
