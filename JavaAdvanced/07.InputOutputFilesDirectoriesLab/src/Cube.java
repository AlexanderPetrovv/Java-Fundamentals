import java.io.Serializable;

class Cube implements Serializable {
    private String color;
    private double width;
    private double height;
    private double depth;

    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getColor() {
        return this.color;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getDepth() {
        return this.depth;
    }

    @Override
    public String toString() {
        return "Color: " + this.color + " Width: " + this.width + " Height: " + this.height + " Depth " + this.depth;
    }
}
