package Programming_Advanced_With_Java.L05OOPPolymorphismLab.P02Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public abstract double calculatePerimeter();
    public abstract double calculateArea();

    private Double getPerimeter() {
        return perimeter;
    }

    private Double getArea() {
        return area;
    }
}
