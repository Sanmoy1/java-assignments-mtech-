// question

// Define a Java class Stack that contains an array of numbers. It has a push method to insert a given number at the top of the array. It also has a pop method to return a number from the top of the array. The number of elements in the array is provided at the time of construction. If a number is attempted to be pushed in a full array then an exception "StackFull" is to be thrown. If an empty stack is popped then "EmptyStack" exception is to be thrown. Write a method testPush in the class that reads a number from the input and pushes it into the stack. Write a method testPop in the class that pops the stack and returns the number received. The methods testPush and testPop must catch exceptions and print appropriate messages.

import java.util.Scanner;

// Custom exception for full stack
class StackFull extends Exception {
    public StackFull(String message) {
        super(message);
    }
}

// Custom exception for empty stack
class EmptyStack extends Exception {
    public EmptyStack(String message) {
        super(message);
    }
}

public class Stack {
    private int[] array;
    private int top;
    private int maxSize;
    
    // Constructor to initialize stack with given size
    public Stack(int size) {
        this.maxSize = size;
        this.array = new int[size];
        this.top = -1; // Stack is initially empty
    }
    
    // Push method to insert number at top of stack
    public void push(int number) throws StackFull {
        if (top >= maxSize - 1) {
            throw new StackFull("Stack is full. Cannot push " + number);
        }
        array[++top] = number;
    }
    
    // Pop method to return and remove number from top of stack
    public int pop() throws EmptyStack {
        if (top < 0) {
            throw new EmptyStack("Stack is empty. Cannot pop");
        }
        return array[top--];
    }
    
    // Test method to read input and push to stack
    public void testPush() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number to push: ");
            int number = scanner.nextInt();
            push(number);
            System.out.println("Successfully pushed " + number + " to stack");
        } catch (StackFull e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
    
    // Test method to pop from stack and return the number
    public int testPop() {
        try {
            int poppedNumber = pop();
            System.out.println("Successfully popped " + poppedNumber + " from stack");
            return poppedNumber;
        } catch (EmptyStack e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // Return -1 to indicate error
        }
    }
    
    // Helper method to check if stack is empty
    public boolean isEmpty() {
        return top < 0;
    }
    
    // Helper method to check if stack is full
    public boolean isFull() {
        return top >= maxSize - 1;
    }
    
    // Helper method to get current size
    public int size() {
        return top + 1;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Stack stack = new Stack(3); // Create stack of size 3
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Stack Operations Demo");
        System.out.println("Commands: 1-Push, 2-Pop, 3-Exit");
        
        while (true) {
            System.out.print("\nEnter command (1/2/3): ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    stack.testPush();
                    break;
                case 2:
                    stack.testPop();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
            
            System.out.println("Current stack size: " + stack.size());
        }
    }
}