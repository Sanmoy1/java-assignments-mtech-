// question:
// Write a JAVA program that creates a base class called "Distance". It stores the distance between two points in a double value variable and contains a virtual function called travelTime() that outputs the time it takes to travel that distance, assuming that the distance is in miles and the speed is 60 miles per hour. In a derived class called "DistMKS", override travelTime so that it outputs the travel time assuming that the distance is in kilometers and the speed is 100 kilometers per hour. Note: Use base class object to call a function.

// Base class Distance
class Distance {
    protected double distance; // Distance between two points
    
    // Constructor
    public Distance(double distance) {
        this.distance = distance;
    }
    
    // Virtual method to calculate travel time
    // In Java, all non-static methods are virtual by default
    public void travelTime() {
        double time = distance / 60.0; // Speed is 60 miles per hour
        System.out.println("Travel time for " + distance + " miles at 60 mph: " + 
                           time + " hours or " + (time * 60) + " minutes");
    }
}

// Derived class DistMKS
class DistMKS extends Distance {
    // Constructor
    public DistMKS(double distance) {
        super(distance); // Call base class constructor
    }
    
    // Override travelTime method
    @Override
    public void travelTime() {
        double time = distance / 100.0; // Speed is 100 kilometers per hour
        System.out.println("Travel time for " + distance + " kilometers at 100 km/h: " + 
                           time + " hours or " + (time * 60) + " minutes");
    }
}

// Main class to test the program
public class TravelTimeDemo {
    public static void main(String[] args) {
        // Create base class object
        Distance milesDistance = new Distance(120);
        
        // Create derived class object
        DistMKS kmDistance = new DistMKS(160);
        
        // Call travelTime using base class object
        System.out.println("Using base class object:");
        milesDistance.travelTime();
        
        // Call travelTime using derived class object
        System.out.println("\nUsing derived class object:");
        kmDistance.travelTime();
        
        // Call derived class method through base class reference
        // This demonstrates polymorphism
        System.out.println("\nUsing base class reference to derived class object:");
        Distance polyDistance = new DistMKS(200);
        polyDistance.travelTime();  // This calls the overridden method in DistMKS
    }
}