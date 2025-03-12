package Entities;

import java.util.Objects;

public class Coordinates {
    // компилятор жалуется почему не final...
    private final Integer coordinateX;
    private final Integer coordinateY;

    public Coordinates(Integer coordinateX, Integer coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(coordinateX, that.coordinateX) && Objects.equals(coordinateY, that.coordinateY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }
}
