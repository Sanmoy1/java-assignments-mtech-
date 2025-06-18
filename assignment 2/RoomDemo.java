//question 1

 class Room{
    int heigth,width,breadth;

    Room(int h,int w,int b)
    {
        heigth=h;
        width=w;
        breadth=b;
    }
    double volume()
    {
        return heigth*breadth*width;
    }

}
public class RoomDemo{
    public static void main(String[] args) {
        Room obj=new Room(1,2,3);
        System.out.println(obj.volume());
    }
}