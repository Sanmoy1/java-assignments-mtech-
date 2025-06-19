// question:

// Create two derived classes called Integer Counter and EnumerationCounter that inherit the Counter class. IntegerCounter class contains an integer whose value is incremented or decremented or displayed. EnumerationCounter class contains an array of strings. When an EnumerationCounter object is incremented or decremented then the current index in the array is increased or decreased by one till the index reaches its maximum or minimum value. If the index reaches maximum value, an increment in the index will set the index to zero. If the index reaches zero, a decrement in the index will set the index to its maximum value.
// Implement the classes Integer Counter, EnumerationCounter in JAVA.

// Base Counter class
abstract class Counter {
    // Abstract methods to be implemented by derived classes
    public abstract void increment();
    public abstract void decrement();
    public abstract void display();
}

// IntegerCounter class that inherits from Counter
class IntegerCounter extends Counter {
    private int count;
    
    // Constructor
    public IntegerCounter(int initialValue) {
        this.count = initialValue;
    }
    
    // Default constructor
    public IntegerCounter() {
        this(0); // Default initial value is 0
    }
    
    @Override
    public void increment() {
        count++;
    }
    
    @Override
    public void decrement() {
        count--;
    }
    
    @Override
    public void display() {
        System.out.println("Integer Counter value: " + count);
    }
    
    // Getter for the count value
    public int getCount() {
        return count;
    }
}

// EnumerationCounter class that inherits from Counter
class EnumerationCounter extends Counter {
    private String[] values;
    private int currentIndex;
    
    // Constructor
    public EnumerationCounter(String[] values, int initialIndex) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values array cannot be null or empty");
        }
        
        this.values = values;
        
        // Validate and set the initial index
        if (initialIndex >= 0 && initialIndex < values.length) {
            this.currentIndex = initialIndex;
        } else {
            this.currentIndex = 0; // Default to 0 if invalid index
        }
    }
    
    // Default constructor with initial index 0
    public EnumerationCounter(String[] values) {
        this(values, 0);
    }
    
    @Override
    public void increment() {
        currentIndex = (currentIndex + 1) % values.length;
        // This will wrap around to 0 when it reaches maximum
    }
    
    @Override
    public void decrement() {
        currentIndex = (currentIndex - 1 + values.length) % values.length;
        // This will wrap around to max when it reaches 0
    }
    
    @Override
    public void display() {
        System.out.println("Enumeration Counter value: " + values[currentIndex] + 
                           " (index: " + currentIndex + ")");
    }
    
    // Getter for the current value
    public String getCurrentValue() {
        return values[currentIndex];
    }
    
    // Getter for the current index
    public int getCurrentIndex() {
        return currentIndex;
    }
}

// Main class to test the implementation
public class CounterDemo {
    public static void main(String[] args) {
        // Test IntegerCounter
        IntegerCounter ic = new IntegerCounter(5);
        System.out.println("Testing IntegerCounter:");
        ic.display();
        ic.increment();
        ic.display();
        ic.increment();
        ic.display();
        ic.decrement();
        ic.display();
        
        // Test EnumerationCounter
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        EnumerationCounter ec = new EnumerationCounter(days);
        
        System.out.println("\nTesting EnumerationCounter:");
        ec.display();
        
        // Increment a few times
        System.out.println("\nIncrementing:");
        for (int i = 0; i < 9; i++) {
            ec.increment();
            ec.display();
        }
        
        // Decrement a few times
        System.out.println("\nDecrementing:");
        for (int i = 0; i < 9; i++) {
            ec.decrement();
            ec.display();
        }
        
        // Test polymorphism
        System.out.println("\nTesting polymorphism:");
        Counter[] counters = {ic, ec};
        for (Counter c : counters) {
            c.increment();
            c.display();
        }
    }
}