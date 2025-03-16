package Entities;


public abstract class Entity {

    private Coordinates coordinates;
    protected String sprite;
    protected Integer moveLength;

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
