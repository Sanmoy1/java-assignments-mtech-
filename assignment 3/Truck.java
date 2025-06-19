//question 1

 class Vehicle {
    int wheels,speed;
    Vehicle(int w,int s)
    {
        wheels=w;
        speed=s;
    }
    
}
class Car extends Vehicle{
    int passengers;
    Car(int p,int w,int s)
    {
        super(w,s);
        passengers=p;
    }

}
public class Truck extends Vehicle{
    int load;
    Truck(int l,int w,int s)
{
    super(w, s);
    load=l;
}
public static void main(String[] args) {
    Car obj=new Car(20, 4, 50);
    Truck obj1=new Truck(100, 8, 30);
    System.out.println("Information about car");
    System.out.println("Passengers:"+obj.passengers+" Wheels: "+obj.wheels+" speed: "+obj.speed);
    System.out.println("Information about truck");
    System.out.println("Load: "+obj1.load+" Wheels: "+obj1.wheels+" Speed: "+obj1.speed);
    if(obj.speed>obj1.speed)
    System.out.println("Faster");
    else
    System.out.println("slower");
}

}
