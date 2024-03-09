package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P02Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;
    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * this.height + this.width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    private Double getHeight() {
        return height;
    }

    private Double getWidth() {
        return width;
    }
}
