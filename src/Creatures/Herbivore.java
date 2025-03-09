package Creatures;

import Entities.Coordinates;

public class Herbivore extends Creature{
    private Integer health = 1;


    public Herbivore(Coordinates coordinates){
        super(coordinates);
        sprite = "🐓";
    }

    @Override
    void makeMove() {

    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
