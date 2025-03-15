package StaticEntities;

import Entities.Coordinates;
import Entities.Entity;

public  abstract class StaticEntity extends Entity {
    public StaticEntity(Coordinates coordinates) {
        super(coordinates);
    }
}
