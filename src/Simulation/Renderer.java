package Simulation;

import Entities.Coordinates;
import Entities.Entity;

import java.util.HashMap;

public class Renderer {

    static void renderMap (Map map){
         for (int i = 0; i < map.getMapHeight(); i++) {
             for (int j = 0; j < map.getMapWidth(); j++) {
                    renderCell(i, j, map.getMap());
             }
             System.out.println();
         }
    }
    private static  void renderCell(Integer coordinateX, Integer coordinateY, HashMap<Coordinates, Entity> map){
        String resetColor = "\u001b[0m";
        String backgroundColor = "\u001b[48;5;64m";

        Entity toPrint = map.get(new Coordinates(coordinateX, coordinateY));
        if (toPrint == null){
            System.out.printf("%s" + "%s", backgroundColor, resetColor);
        }else {
            System.out.printf("%s" + "%-6s" + "%s",
                    backgroundColor,
                    toPrint.getSprite(), resetColor);
        }
    }
}
