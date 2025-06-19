//question 2

public class Employee {
    String name;
    int age;
    Manager manager;

    Employee(String name1, int age1) {
        name = name1;
        age = age1;
    }
    void setManager(Manager mg)
    {
        manager=mg;
    }
    Manager getManager()
    {
        return manager;
    }

    void display() {
        System.out.println("Name of the employee: " + name);
        System.out.println("Age of the employee: " + age);
        if(manager!=null)
        {
            System.out.println("manager: "+manager.name);
        }
        else
        {
            System.out.println("no manager assigned");
        }
    }

}
class Manager extends Employee{
    String list[];
    Employee employee[];
    Manager(String list1[],String name1,int age1)
    {
        super(name1,age1);
        list=list1;
        employee=new Employee[list.length];    

    }
    void addemployee(Employee emp,int index)
    {
        if(index>0 && index<employee.length)
        employee[index]=emp;
        emp.setManager(this);
    }
    void display()
    {
        System.out.println("Name of the manager: "+name);
        System.out.println("Age of the manager: "+age);
        System.out.println("The list of employees are:");
        for(String i:list)
        {
            System.out.println(i);
        }
        System.out.println("Employee details:");
        for (Employee emp : employee) {
            if (emp != null) {
                System.out.println("- " + emp.name + " (Age: " + emp.age + ")");
            }
        }
    }

}
