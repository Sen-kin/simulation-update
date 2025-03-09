package StaticEntities;

import Entities.Coordinates;
import Entities.Entity;

public class Tree extends Entity {


    public Tree(Coordinates coordinates) {
        super(coordinates);
        sprite = "🍀 ";
    }
}
