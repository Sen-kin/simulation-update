package StaticEntities;

import Entities.Coordinates;
import Entities.Entity;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        super(coordinates);
        sprite = "🌾 ";
    }
}
