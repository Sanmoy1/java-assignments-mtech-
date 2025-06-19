// question


// Define a class "Fraction" that contains three integer data members "numerator", "denominator", and "quotient".
// Write the following methods:
// ·
// construct a Fraction object that initializes "numerator" and "denominator" to user defined integers and "quotient" to zero.
// divide "numerator" by "denominator" of a "Fraction" object and store that
// in "quotient".
// Create an exception class "DivisionByZero". Add the code to throw this exception from the divide method.
// Write a main method to:
// i)
// create a "Fraction" object
// ii) define a try-catch block to call divide method on that object with suitable exception object.


// Custom exception class for division by zero
class DivisionByZero extends Exception {
    public DivisionByZero(String message) {
        super(message);
    }
}

// Fraction class
class Fraction {
    private int numerator;
    private int denominator;
    private int quotient;
    
    // Constructor to initialize numerator and denominator
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.quotient = 0;
    }
    
    // Method to divide numerator by denominator
    public void divide() throws DivisionByZero {
        if (denominator == 0) {
            throw new DivisionByZero("Cannot divide by zero: denominator is zero");
        }
        quotient = numerator / denominator;
    }
    
    // Getter methods for accessing private fields
    public int getNumerator() {
        return numerator;
    }
    
    public int getDenominator() {
        return denominator;
    }
    
    public int getQuotient() {
        return quotient;
    }
    
    // Method to display fraction details
    public void displayFraction() {
        System.out.println("Numerator: " + numerator);
        System.out.println("Denominator: " + denominator);
        System.out.println("Quotient: " + quotient);
    }
}

// Main class
public class FractionDemo {
    public static void main(String[] args) {
        // Create Fraction objects for testing
        System.out.println("=== Testing Fraction with valid denominator ===");
        Fraction fraction1 = new Fraction(10, 3);
        
        try {
            fraction1.divide();
            System.out.println("Division successful!");
            fraction1.displayFraction();
        } catch (DivisionByZero e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\n=== Testing Fraction with zero denominator ===");
        Fraction fraction2 = new Fraction(15, 0);
        
        try {
            fraction2.divide();
            System.out.println("Division successful!");
            fraction2.displayFraction();
        } catch (DivisionByZero e) {
            System.out.println("Exception caught: " + e.getMessage());
            fraction2.displayFraction();
        }
        
        System.out.println("\n=== Testing another valid fraction ===");
        Fraction fraction3 = new Fraction(20, 4);
        
        try {
            fraction3.divide();
            System.out.println("Division successful!");
            fraction3.displayFraction();
        } catch (DivisionByZero e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}