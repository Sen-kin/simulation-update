package Creatures;

import Entities.Coordinates;
import Entities.Entity;

public abstract class Creature extends Entity {

    public Creature(Coordinates coordinates)
    {
        super(coordinates);
    }

   public abstract void makeMove();


}
