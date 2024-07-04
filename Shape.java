// Base class Shape
abstract class Shape {
    // Abstract method for drawing the shape
    abstract void draw();

    // Abstract method for calculating the area of the shape
    abstract double calculateArea();
}

// Circle class, subclass of Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle with radius " + radius);
        // Placeholder for drawing logic, can be graphical or text-based
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Square class, subclass of Shape
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    void draw() {
        System.out.println("Drawing Square with side " + side);
        // Placeholder for drawing logic, can be graphical or text-based
    }

    @Override
    double calculateArea() {
        return side * side;
    }
}

// Triangle class, subclass of Shape
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("Drawing Triangle with base " + base + " and height " + height);
        // Placeholder for drawing logic, can be graphical or text-based
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class to test the Shape system
public class Main {
    public static void main(String[] args) {
        // Create instances of Circle, Square, and Triangle
        Circle circle = new Circle(5.0);
        Square square = new Square(4.0);
        Triangle triangle = new Triangle(3.0, 6.0);

        // Draw each shape and print its area
        circle.draw();
        System.out.println("Area of Circle: " + circle.calculateArea());

        square.draw();
        System.out.println("Area of Square: " + square.calculateArea());

        triangle.draw();
        System.out.println("Area of Triangle: " + triangle.calculateArea());
    }
}
