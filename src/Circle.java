import java.util.Scanner;

class CircleClass {
    private double radius;
    private final double PI = 3.14159;

    public CircleClass() {
        this.radius = 0.0;
    }

    public CircleClass(double radius) {
        setRadius(radius);
    }

    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Radius cannot be negative.");
        this.radius = radius;
    }

    public double getRadius()        { return radius; }
    public double getArea()          { return PI * radius * radius; }
    public double getDiameter()      { return radius * 2; }
    public double getCircumference() { return 2 * PI * radius; }
}

public class Circle {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        double r = -1;
        while (r < 0) {
            System.out.print("Enter the radius of the circle: ");
            if (myInput.hasNextDouble()) {
                r = myInput.nextDouble();
                if (r < 0) System.out.println("  !! Radius cannot be negative.");
            } else {
                System.out.println("  !! Invalid input.");
                myInput.next();
            }
        }

        CircleClass c = new CircleClass(r);

        System.out.println("\n===== Circle Measurements =====");
        System.out.printf("Radius        : %.4f%n", c.getRadius());
        System.out.printf("Diameter      : %.4f%n", c.getDiameter());
        System.out.printf("Area          : %.4f%n", c.getArea());
        System.out.printf("Circumference : %.4f%n", c.getCircumference());
    }
}
