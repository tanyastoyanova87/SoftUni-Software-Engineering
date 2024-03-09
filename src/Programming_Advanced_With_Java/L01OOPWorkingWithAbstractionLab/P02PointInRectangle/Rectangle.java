package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionLab.P02PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean isInBounds = point.getX() >= this.bottomLeft.getX() && point.getX() <= this.topRight.getX();
        boolean isInBounds2 = point.getY() >= this.bottomLeft.getY() && point.getY() <= this.topRight.getY();

        return isInBounds && isInBounds2;
    }
}
