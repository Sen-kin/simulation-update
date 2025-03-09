package Entities;

public abstract class Entity {

    private Coordinates coordinates;
    protected String sprite;
    protected static final Integer moveLength = 1;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public String getSprite (){
        return sprite;
    }
}
