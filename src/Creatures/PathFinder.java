package Creatures;

import Entities.Coordinates;
import Entities.Entity;
import Simulation.Main;
import StaticEntities.Grass;
import StaticEntities.StaticEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class PathFinder {

    HashMap<Coordinates, Entity> field = Main.getSimulation().getSimulationMap().getField();

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

    Coordinates[] getNeighbors(Coordinates position){
        return new Coordinates[]
                {
                        new Coordinates(position.getCoordinateX() - 1, position.getCoordinateY()),
                        new Coordinates(position.getCoordinateX() + 1, position.getCoordinateY()),
                        new Coordinates(position.getCoordinateX(), position.getCoordinateY() - 1),
                        new Coordinates(position.getCoordinateX(), position.getCoordinateY() + 1)
                };
    }

    Coordinates bestCellToStayForHerbivore(Coordinates herbivorePosition){

        Coordinates bestCell = null;

            Coordinates[] neighbors = getNeighbors(herbivorePosition);

            ArrayList<Coordinates> cellsToMoveOn = new ArrayList<>();

        for (Coordinates coordinates: field.keySet()){
             Entity currentEntity = field.get(coordinates);
             if (isNeighbor(coordinates, neighbors)
                     && !(currentEntity instanceof Creature)
                     && !(currentEntity instanceof StaticEntity)
                )
                 cellsToMoveOn.add(coordinates);
        }

        double minimalDistance = Double.MAX_VALUE;

        for (Coordinates cell: cellsToMoveOn)
        {
            double distance = findDistanceToNearestGrass(cell);

            if (distance < minimalDistance) {
                minimalDistance = distance;
                bestCell = cell;
            }
        }

        return (bestCell == null)? herbivorePosition: bestCell;
    }

    Coordinates bestCellToStayForPredator(Coordinates predatorPosition){

        Coordinates bestCell = null;

        Coordinates[] neighbors = getNeighbors(predatorPosition);

        ArrayList<Coordinates> cellsToMoveOn = new ArrayList<>();

        for (Coordinates coordinates: field.keySet()){
            Entity currentEntity = field.get(coordinates);
            if (isNeighbor(coordinates, neighbors)
                    && !(currentEntity instanceof Predator)
                    && !(currentEntity instanceof StaticEntity)
            )
                cellsToMoveOn.add(coordinates);
        }

        double minimalDistance = Double.MAX_VALUE;
        for (Coordinates cell: cellsToMoveOn){
            double distance = findDistanceToNearestHerbivore(cell);

            if (distance < minimalDistance) {
                minimalDistance = distance;
                bestCell = cell;
            }
        }
        return (bestCell == null)? predatorPosition: bestCell;
    }

    boolean checkIfTheCellContainsGrass (Coordinates cell){
        return field.get(cell) instanceof Grass;
    }

    boolean checkIfTheCellContainsHerbivore (Coordinates cell){
        return field.get(cell) instanceof Herbivore;
    }


}
