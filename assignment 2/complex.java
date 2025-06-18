//question 4
public class complex {
    int real, imaginary;
    complex()
    {
        real=0;
        imaginary=0;
    }
    complex(int r)
    {
        real=r;
        imaginary=0;
    }
    complex(int r, int i)
    {
        real=r;
        imaginary=i;
    }
     void sum(complex c1, complex c2)
    {
        real=c1.real+c2.real;
        imaginary=c1.imaginary+c2.imaginary;
        System.out.println("The sum is: "+real+"+ i"+imaginary);
    }
    void product(complex c1,complex c2)
    {
        real=(c1.real*c2.real)-(c1.imaginary*c2.imaginary);
        imaginary=(c1.real*c2.imaginary)+(c2.real*c1.imaginary);
        System.out.println("product: "+real+"+ i"+imaginary);
    }
    public static void main(String[] args) {
        complex o1=new complex(2,3);
        complex o2=new complex(3,2);
        complex o3=new complex();
        o3.sum(o1,o2);

        o3.product(o1, o2);
    }


}
