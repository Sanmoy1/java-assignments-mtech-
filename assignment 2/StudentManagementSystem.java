import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private String[] subjects;

    // Constructor
    public Student(String name, int rollNumber, String subject1, String subject2) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = new String[2];
        this.subjects[0] = subject1;
        this.subjects[1] = subject2;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getSubject(int index) {
        if (index >= 0 && index < 2) {
            return subjects[index];
        }
        return "";
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setSubject(int index, String subject) {
        if (index >= 0 && index < 2) {
            subjects[index] = subject;
        }
    }

    // Display student information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Roll: " + rollNumber + 
                          ", Subjects: " + subjects[0] + ", " + subjects[1]);
    }
}

class TabulationSheet {
    private String subject;
    private Map<Integer, Double> studentMarks; // roll number -> marks

    // Constructor
    public TabulationSheet(String subject) {
        this.subject = subject;
        this.studentMarks = new HashMap<>();
    }

    // Method to add marks for a student
    public void addStudentMarks(int rollNumber, double marks) {
        studentMarks.put(rollNumber, marks);
    }

    // Getter methods
    public String getSubject() {
        return subject;
    }

    public double getMarks(int rollNumber) {
        return studentMarks.getOrDefault(rollNumber, 0.0);
    }

    // Display tabulation sheet
    public void display() {
        System.out.println("\nTabulation Sheet for " + subject + ":");
        System.out.println("Roll Number\tMarks");
        System.out.println("------------------------");
        for (Map.Entry<Integer, Double> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
    }
}

class MarkSheet {
    private String studentName;
    private int rollNumber;
    private Map<String, Double> subjectMarks; // subject -> marks

    // Constructor
    public MarkSheet(String studentName, int rollNumber) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.subjectMarks = new HashMap<>();
    }

    // Method to add student name and marks for each subject
    public void addSubjectMarks(String subject, double marks) {
        subjectMarks.put(subject, marks);
    }

    // Getter methods
    public String getStudentName() {
        return studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarks(String subject) {
        return subjectMarks.getOrDefault(subject, 0.0);
    }

    // Display mark sheet
    public void display() {
        System.out.println("\nMark Sheet for " + studentName + " (Roll: " + rollNumber + "):");
        System.out.println("Subject\t\tMarks");
        System.out.println("------------------------");
        for (Map.Entry<String, Double> entry : subjectMarks.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        // Create three Student objects
        Student student1 = new Student("Alice Johnson", 101, "Mathematics", "Physics");
        Student student2 = new Student("Bob Smith", 102, "Mathematics", "Physics");
        Student student3 = new Student("Carol Davis", 103, "Mathematics", "Physics");

        System.out.println("=== STUDENT INFORMATION ===");
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();

        // Create two TabulationSheet objects for two subjects
        TabulationSheet mathTabulation = new TabulationSheet("Mathematics");
        TabulationSheet physicsTabulation = new TabulationSheet("Physics");

        // Add marks to tabulation sheets
        mathTabulation.addStudentMarks(101, 85.5);
        mathTabulation.addStudentMarks(102, 92.0);
        mathTabulation.addStudentMarks(103, 78.5);

        physicsTabulation.addStudentMarks(101, 88.0);
        physicsTabulation.addStudentMarks(102, 91.5);
        physicsTabulation.addStudentMarks(103, 82.0);

        System.out.println("\n=== TABULATION SHEETS ===");
        mathTabulation.display();
        physicsTabulation.display();

        // Create three MarkSheet objects for three students
        MarkSheet markSheet1 = new MarkSheet("Alice Johnson", 101);
        MarkSheet markSheet2 = new MarkSheet("Bob Smith", 102);
        MarkSheet markSheet3 = new MarkSheet("Carol Davis", 103);

        // Add marks to mark sheets
        markSheet1.addSubjectMarks("Mathematics", 85.5);
        markSheet1.addSubjectMarks("Physics", 88.0);

        markSheet2.addSubjectMarks("Mathematics", 92.0);
        markSheet2.addSubjectMarks("Physics", 91.5);

        markSheet3.addSubjectMarks("Mathematics", 78.5);
        markSheet3.addSubjectMarks("Physics", 82.0);

        System.out.println("\n=== MARK SHEETS ===");
        markSheet1.display();
        markSheet2.display();
        markSheet3.display();
    }
}
