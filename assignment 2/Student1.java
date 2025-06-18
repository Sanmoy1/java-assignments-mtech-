// question 7
public class Student1 {
    int rollno;
    String subNames[], name;

    Student1(String n, int roll, String arr[]) {
        name = n;
        rollno = roll;
        subNames = arr;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return rollno;
    }

    public String[] arr() {
        return subNames;
    }

    public void setName(String n) {
        name = n;
    }

    public void setRoll(int r) {
        rollno = r;
    }

    public void setsubNames(String arr[]) {
        subNames = arr;
    }
}

class TabulationSheet {
    int marks, rollNo;

    TabulationSheet(int m, int r) {
        marks = m;
        rollNo = r;
    }

    void add(int m, int r) {
        marks = m;
        rollNo = r;
    }
}

class MarkSheet {
    int marks1, marks2;
    String Name;

    MarkSheet(int m1, int m2) {
        marks1 = m1;
        marks2 = m2;
    }
    void add(String n,int m1,int m2)
    {
        Name=n;
        marks1=m1;
        marks2=m2;
    }

    public static void main(String[] args) {
        String[] subjects1 = {"Mathematics", "Physics"};
        String[] subjects2 = {"Chemistry", "Biology"};
        String[] subjects3 = {"Computer Science", "English"};
        
        Student1 s1 = new Student1("John", 101, subjects1);
        Student1 s2 = new Student1("Alice", 102, subjects2);
        Student1 s3 = new Student1("Bob", 103, subjects3);
        
        // Create two TabulationSheet objects for two subjects
        TabulationSheet mathSheet = new TabulationSheet(0, 0);
        TabulationSheet physicsSheet = new TabulationSheet(0, 0);
        
        // Add student data to tabulation sheets
        mathSheet.add(85, s1.getRoll());
        physicsSheet.add(78, s1.getRoll());
        
        mathSheet.add(92, s2.getRoll());
        physicsSheet.add(88, s2.getRoll());
        
        mathSheet.add(75, s3.getRoll());
        physicsSheet.add(80, s3.getRoll());
        
        // Create three MarkSheet objects for three students
        MarkSheet ms1 = new MarkSheet(0, 0);
        MarkSheet ms2 = new MarkSheet(0, 0);
        MarkSheet ms3 = new MarkSheet(0, 0);
        
        // Add data to mark sheets
        ms1.add(s1.getName(), 85, 78);
        ms2.add(s2.getName(), 92, 88);
        ms3.add(s3.getName(), 75, 80);
        
        // Print the mark sheets
        System.out.println("STUDENT MARK SHEETS:");
        ms1.printMarkSheet();
        ms2.printMarkSheet();
        ms3.printMarkSheet();
    }
}

