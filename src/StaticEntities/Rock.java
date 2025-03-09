package StaticEntities;

import Entities.Coordinates;
import Entities.Entity;

public class Rock extends Entity {
    public Rock(Coordinates coordinates){
        super(coordinates);
        sprite = "🗻";
    }
}
