//question 2
public class Student {
    String name;
    int mark1,mark2,mark3;
    Student(String n,int m1,int m2,int m3)
    {
        name=n;
        mark1=m1;
        mark2=m2;
        mark3=m3;
    }
    double avg()
    {
        return (mark1+mark2+mark3)/3;
    }
    void display()
    {
        System.out.println("Name of the student: "+name);
        System.out.println("Total average marks: "+avg());
    }
    public static void main(String[] args) {
        Student obj=new Student("Sanmoy", 50, 80, 90);
        obj.display();
    }
}
