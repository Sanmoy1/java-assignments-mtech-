// question:
// Write a class "Point" in JAVA. A "Point" class has two members to store its x and y coordinates and an appropriate constructor. A "Point" class has a method "getDistanceFrom" that accepts a "Point" object and returns the distance of the given point from "this" point.
// Write a "SimplePolygon" class in JAVA that has an array of "Point" objects. The constructor of this class is passed an array of point objects. The "SimplePolygon" class has a method called "getPerimeter" that calculates the perimeter of the polygon by calling repeatedly "getDistanceFrom" methods of its point objects.
// Write a "Triangle" class in JAVA that inherits "SimplePolygon" class. A Triangle class additionally has a boolean member "isEquilateral". The constructor of the class accepts an array of points and a boolean (indicating whether "isEquilateral" is true or false) as parameters. Override the method "getPerimeter" by checking whether "isEquilateral" is true or false. If "isEquilateral" is true then multiply the length of one side by 3; if "isEquilateral" is false call the "getPerimeter" method of the base class.

import java.lang.Math;

// Point class
class Point {
    private double x;
    private double y;
    
    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Method to calculate distance from another point
    public double getDistanceFrom(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    // Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}

// SimplePolygon class
class SimplePolygon {
    protected Point[] points;
    
    // Constructor
    public SimplePolygon(Point[] points) {
        this.points = points;
    }
    
    // Method to calculate perimeter
    public double getPerimeter() {
        double perimeter = 0.0;
        
        // Calculate the sum of distances between consecutive points
        for (int i = 0; i < points.length; i++) {
            Point current = points[i];
            Point next = points[(i + 1) % points.length]; // Wrap around to first point
            perimeter += current.getDistanceFrom(next);
        }
        
        return perimeter;
    }
}

// Triangle class inheriting from SimplePolygon
class Triangle extends SimplePolygon {
    private boolean isEquilateral;
    
    // Constructor
    public Triangle(Point[] points, boolean isEquilateral) {
        super(points);
        
        // Ensure we have exactly 3 points for a triangle
        if (points.length != 3) {
            throw new IllegalArgumentException("A triangle must have exactly 3 points");
        }
        
        this.isEquilateral = isEquilateral;
    }
    
    // Override getPerimeter method
    @Override
    public double getPerimeter() {
        if (isEquilateral) {
            // For equilateral triangle, calculate one side length and multiply by 3
            double sideLength = points[0].getDistanceFrom(points[1]);
            return sideLength * 3;
        } else {
            // For non-equilateral triangle, use the base class method
            return super.getPerimeter();
        }
    }
}

// Main class to test the implementation
public class PolygonDemo {
    public static void main(String[] args) {
        // Create some points
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(0, 4);
        
        // Create an equilateral triangle (though the points don't actually form an equilateral triangle)
        Point[] trianglePoints1 = {p1, p2, p3};
        Triangle equilateralTriangle = new Triangle(trianglePoints1, true);
        
        // Create a non-equilateral triangle
        Triangle nonEquilateralTriangle = new Triangle(trianglePoints1, false);
        
        // Create a simple polygon (a quadrilateral)
        Point p4 = new Point(3, 4);
        Point[] quadPoints = {p1, p2, p4, p3};
        SimplePolygon quad = new SimplePolygon(quadPoints);
        
        // Calculate and display perimeters
        System.out.println("Equilateral triangle perimeter: " + equilateralTriangle.getPerimeter());
        System.out.println("Non-equilateral triangle perimeter: " + nonEquilateralTriangle.getPerimeter());
        System.out.println("Quadrilateral perimeter: " + quad.getPerimeter());
    }
}