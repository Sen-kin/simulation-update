package Simulation;

import Entities.Coordinates;
import Entities.Entity;

import java.util.HashMap;

public class Renderer {

     void renderMap (Map map){
         for (int i = 0; i < map.getMapHeight(); i++) {
             for (int j = 0; j < map.getMapWidth(); j++) {
                    renderCell(i, j, map.getField());
             }
             System.out.println();
         }
         System.out.print("\n\n");

    }
    private static  void renderCell(Integer coordinateX, Integer coordinateY, HashMap<Coordinates, Entity> map){
        String resetColor = "\u001b[0m";
        String backgroundColor = "\u001b[48;5;64m";

        Entity toPrint = map.get(new Coordinates(coordinateX, coordinateY));
        if (toPrint == null){
            System.out.printf("%s" + "\uD83D\uDFE2    " + "%s", backgroundColor, resetColor);
        }else {
            System.out.printf("%s" + "%-6s" + "%s",
                    backgroundColor,
                    toPrint.getSprite(), resetColor);
        }
    }
}
