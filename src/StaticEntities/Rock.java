package StaticEntities;

import Entities.Coordinates;

public class Rock extends StaticEntity {
    public Rock(Coordinates coordinates){
        super(coordinates);
        sprite = "🗻";
    }
}
