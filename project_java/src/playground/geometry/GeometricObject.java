package playground.geometry;

public abstract class GeometricObject {

    private String color;

    public abstract double getArea();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
