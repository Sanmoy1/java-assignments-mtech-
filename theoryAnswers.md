# Java Core Concepts - Q&A

---

### 1. Write exception handling mechanisms in JAVA. That is, explain try, catch, finally block with an example. Also, describe “Throwable” and “Exception” classes.

Exception handling in Java is a mechanism to handle runtime errors. It uses three main blocks:

*   **`try`**: The `try` block contains a set of statements where an exception might occur.
*   **`catch`**: If an exception occurs in the `try` block, the flow of execution is passed to the `catch` block. The `catch` block must be specific to the type of exception it can handle.
*   **`finally`**: The `finally` block is always executed, regardless of whether an exception is thrown or caught. It's typically used for cleanup code, like closing files or database connections.

**Classes:**

*   **`Throwable`**: The `java.lang.Throwable` class is the superclass for all errors and exceptions in Java. Only objects that are instances of this class (or one of its subclasses) are thrown by the JVM or can be thrown by the `throw` statement.
*   **`Exception`**: The `java.lang.Exception` class is a subclass of `Throwable`. It indicates conditions that a reasonable application might want to catch. It's the parent class for most exceptions, including checked exceptions (which must be handled) and `RuntimeException` (unchecked exceptions).

**Example:**
```java
class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("This finally block is always executed.");
        }
    }
}
```

---

### 3. How do you pass parameter to a base class from a derived class in Java?

You pass parameters from a derived class constructor to a base class constructor using the `super()` keyword. The call to `super()` must be the very first statement in the derived class's constructor.

**Example:**
```java
class Animal {
    String name;
    Animal(String name) { // Base class constructor
        this.name = name;
        System.out.println("Animal constructor called with name: " + name);
    }
}

class Dog extends Animal {
    Dog(String name) { // Derived class constructor
        super(name); // Call to the base class constructor
        System.out.println("Dog constructor called.");
    }
}
```

---

### 4. Explain final modifier in Java?

The `final` modifier can be applied to variables, methods, and classes, with the following effects:

*   **`final` variable**: Its value cannot be changed once it has been initialized. It effectively becomes a constant.
*   **`final` method**: It cannot be overridden by any subclass.
*   **`final` class**: It cannot be extended or inherited by any other class. The `String` class is a good example of a final class.

---

### 5. What is the purpose of “instanceof” keyword in Java?

The `instanceof` keyword is a binary operator used to test if an object is an instance of a particular class, a subclass of that class, or an instance of a class that implements a specific interface. It returns a boolean value (`true` or `false`).

**Example:**
```java
ArrayList<String> list = new ArrayList<>();
boolean isList = list instanceof List; // true
boolean isArrayList = list instanceof ArrayList; // true
boolean isObject = list instanceof Object; // true
```

---

### 6. Name the different methods in String class in Java?

The `java.lang.String` class has many useful methods. Some of the most common ones are:
*   `int length()`: Returns the length of the string.
*   `char charAt(int index)`: Returns the character at a specified index.
*   `String substring(int beginIndex, int endIndex)`: Returns a part of the string.
*   `boolean equals(Object anotherObject)`: Compares the string to another object for equality.
*   `boolean startsWith(String prefix)`: Checks if the string starts with a specified prefix.
*   `int indexOf(String str)`: Returns the index of the first occurrence of a substring.
*   `String toUpperCase()`: Converts the string to uppercase.
*   `String trim()`: Removes leading and trailing whitespace.

---

### 8. Give an example of inner class.

An inner class is a class defined within the body of another class. It has access to the members (including private members) of the outer class.

**Example (Member Inner Class):**
```java
class OuterClass {
    private int outerData = 10;

    // Inner class definition
    class InnerClass {
        void display() {
            // Can access private member of the outer class
            System.out.println("Value from outer class: " + outerData);
        }
    }

    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        innerObj.display(); // Output: Value from outer class: 10
    }
}
```

---

### 9. What is final class? Why are they used?

A `final` class is a class that cannot be subclassed (extended). It's declared with the `final` keyword.

**They are used for two main reasons:**
1.  **Security**: To prevent subclasses from altering or overriding critical behavior. For example, `java.lang.String` is final so that no one can create a malicious subclass that changes its behavior.
2.  **Immutability**: To help create immutable objects. If a class is final, you can be sure that its methods won't be overridden in a way that would make the object mutable.

---

### 10. What is the base class of all the classes in JAVA? Mention three important methods of that class.

The base class of all classes in Java is `java.lang.Object`. Every class is a descendant, direct or indirect, of the `Object` class.

**Three important methods are:**
1.  **`public boolean equals(Object obj)`**: Compares two objects for equality. The default implementation checks for reference equality (if they are the same object in memory).
2.  **`public int hashCode()`**: Returns a hash code value for the object. It's important for performance in collections like `HashMap` and `HashSet`.
3.  **`public String toString()`**: Returns a string representation of the object. By default, it returns the class name followed by its hash code, but it's often overridden to provide a more meaningful representation.

---

### 11. What are the differences between an interface and an abstract class? What kinds of fields and methods may be contained in Java interface?

| Feature             | Abstract Class                                        | Interface                                                 |
| ------------------- | ----------------------------------------------------- | --------------------------------------------------------- |
| **Multiple Inheritance** | A class can extend only **one** abstract class.       | A class can implement **multiple** interfaces.            |
| **Fields**          | Can have any type of field (static, final, etc.).     | Fields are implicitly `public static final` (constants).  |
| **Methods**         | Can have abstract and concrete (with body) methods.   | Can have abstract, `default`, and `static` methods.       |
| **Constructor**     | Can have a constructor.                               | Cannot have a constructor.                                |
| **Purpose**         | To provide a common base with some shared implementation. | To define a contract of behaviors a class must adhere to. |

**Fields and methods in an interface:**
*   **Fields**: Must be `public static final`.
*   **Methods**: Can be `public abstract` (the default), `public static`, or `public default` (since Java 8).

---

### 12. How can you create packages in Java? What kind of classes can be grouped in a package? How your friend’s code can use classes in your package?

*   **Creating a Package**: You use the `package` keyword at the very top of a Java source file. The directory structure on the file system must match the package name (e.g., `package com.example.myapp;` requires the file to be in a `com/example/myapp` directory).
*   **Grouping Classes**: A package is used to group related classes, interfaces, and enums. This helps in organizing code and preventing naming conflicts.
*   **Using a Package**: Your friend can use classes from your package in two ways:
    1.  **Using `import`**: By adding `import your.package.name.ClassName;` or `import your.package.name.*;` at the top of their source file.
    2.  **Using Fully Qualified Name**: By referring to the class with its full package name, like `your.package.name.ClassName obj = new your.package.name.ClassName();`.

---

### 13. Do you think copy of an array can be created using assignment statement? Give reason for your answer.

No, a copy of an array **cannot** be created using an assignment statement (`=`).

**Reason**: In Java, array variables are references that point to the actual array object in memory. When you use an assignment statement like `int[] array2 = array1;`, you are only copying the reference (the memory address). Both `array1` and `array2` will point to the exact same array object. Any change made through `array2` will be reflected in `array1`, and vice-versa, because they are the same array.

---

### 14. Explain with examples instance variables and class variables.

*   **Instance Variables**: These variables belong to an *instance* (an object) of a class. Each object has its own separate copy of the instance variable. They are declared inside a class but outside any method.
*   **Class Variables (Static Variables)**: These variables belong to the *class* itself. There is only one copy of a class variable, shared among all instances of that class. They are declared with the `static` keyword.

**Example:**
```java
class Car {
    String model; // Instance variable
    static int numberOfCars = 0; // Class variable

    Car(String model) {
        this.model = model;
        numberOfCars++; // Increment the shared class variable
    }
}

Car car1 = new Car("BMW");
Car car2 = new Car("Audi");

System.out.println(car1.model); // BMW
System.out.println(car2.model); // Audi
System.out.println(Car.numberOfCars); // 2
```

---

### 15. Short notes on “package” and “import” in Java.

*   **`package`**: A package is a mechanism for organizing Java classes into namespaces, similar to modules. It helps to avoid naming conflicts and provides a way to control access to classes. The `package` statement must be the first line in a Java source file.
*   **`import`**: The `import` statement allows you to refer to classes and interfaces from other packages by their simple names instead of their fully qualified names. It makes the code more readable. You can import a single class (`import java.util.ArrayList;`) or all classes in a package (`import java.util.*;`).

---

### 17. Explain Object class and its methods.

(This is a repeat of question 10). `java.lang.Object` is the root of the class hierarchy in Java. Every class implicitly extends `Object`. It provides several fundamental methods that are available to all objects:

*   **`toString()`**: Returns a string representation of the object.
*   **`equals(Object obj)`**: Checks for equality between two objects.
*   **`hashCode()`**: Returns an integer hash code for the object, used by hash-based collections.
*   **`getClass()`**: Returns the runtime class of the object.
*   **`clone()`**: Creates and returns a copy of the object.
*   **`finalize()`**: Called by the garbage collector just before an object is garbage collected.
*   **`wait()`, `notify()`, `notifyAll()`**: Methods used for inter-thread communication.

---

### 18. Mention 3 methods which are not in String class but in StringBuffer class. Why these methods are not defined in String class.

Three methods in `StringBuffer` but not in `String` are:
1.  **`append()`**: Adds characters to the end of the sequence.
2.  **`insert()`**: Inserts characters at a specified position.
3.  **`reverse()`**: Reverses the sequence of characters.

**Reason**: These methods are not in the `String` class because **`String` objects are immutable**. Once a `String` object is created, its value cannot be changed. The methods above all modify the object's state, which is the entire purpose of the mutable `StringBuffer` and `StringBuilder` classes.

---

### 19. What is an interface? Why is an interface used in Java? What are the marker interfaces? Give two example of marker interface?

*   **What is an interface?**: An interface is a reference type in Java that defines a contract. It is a collection of abstract methods and constant fields (`public static final`). A class can `implement` an interface to adhere to this contract.
*   **Why is it used?**: To achieve full abstraction, to allow a class to have multiple types (multiple inheritance of behavior), and to decouple components.
*   **What is a marker interface?**: A marker interface is an empty interface (it has no methods or fields). It is used to provide metadata about a class to the JVM or other libraries. It 'marks' a class as having a certain capability.
*   **Examples**: `java.io.Serializable`, `java.lang.Cloneable`.

---

### 21. What is the difference between a String object and a StringBuffer object?

| Feature             | `String`                                      | `StringBuffer`                                    |
| ------------------- | --------------------------------------------- | ------------------------------------------------- |
| **Mutability**      | **Immutable**: Cannot be changed after creation. | **Mutable**: Can be modified after creation.        |
| **Performance**     | Slower for frequent modifications.            | Faster for frequent modifications.                |
| **Thread Safety**   | Thread-safe (due to immutability).            | Thread-safe (methods are synchronized).           |
| **Storage**         | Stored in the String Constant Pool (if literal). | Stored in the heap.                               |

---

### 22. How can you convert an integer to a string and a string containing digits to an integer?

*   **Integer to String**:
    ```java
    int num = 123;
    String str1 = String.valueOf(num);
    String str2 = Integer.toString(num);
    ```
*   **String to Integer**:
    ```java
    String str = "456";
    int num1 = Integer.parseInt(str);
    int num2 = Integer.valueOf(str); // Returns an Integer object
    ```

---

### 23. How can you define three classes “X”, “Y”, “Z” so that they belong to the same package, “mypackage”? How can a class “V” be defined in a package, “anotherPackage”, use a class “X”?

1.  **Defining X, Y, Z in `mypackage`**:
    Place the `package mypackage;` statement at the top of `X.java`, `Y.java`, and `Z.java`.
    ```java
    // In file X.java
    package mypackage;
    public class X {}
    ```
    (Do the same for Y and Z).

2.  **Defining V in `anotherPackage` to use X**:
    Place `package anotherPackage;` at the top of `V.java` and import class `X`.
    ```java
    // In file V.java
    package anotherPackage;
    import mypackage.X;

    public class V {
        public void someMethod() {
            X myX = new X(); // Now you can use class X
        }
    }
    ```

---

### 24. What is the base class of all exception objects in Java?

The base class for all exceptions and errors is `java.lang.Throwable`.

---

### 27. Name 4 different methods in String class in Java.

(This is a repeat of question 6).
1.  `length()`
2.  `charAt(int index)`
3.  `equals(Object obj)`
4.  `substring(int beginIndex)`

---

### 28. State whether the following statements are TRUE or FALSE

I.    Operators cannot be overloaded in Java. - **TRUE**
III.  A field defined private in super class can be used in functions defined in a derived class. - **FALSE**
IV.   A string object can be modified after it is created. - **FALSE**
V.    Non static methods of the super class may be invoked by “super” keyword. - **TRUE**
VII.  A class may implement multiple interfaces. - **TRUE**
VIII. An abstract class can be instantiated. - **FALSE**
IX.   When a class implements marker interface then the class does not define any method for those interfaces. - **TRUE**
X.    All user defined exception classes are derived from “Exception” class. - **TRUE**
