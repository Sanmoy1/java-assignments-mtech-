public class Fraction
{
    int numerator, denominator,quotient;
    Fraction(int a,int b)
    {
        numerator=a;
        denominator=b;
        quotient=0;
    }
    void divide()throws DivisionByZero
    {
        if(denominator==0)
        throw new DivisionByZero(denominator);
        quotient=numerator/denominator;
        System.out.println("Quotient: "+quotient);
    }

class DivisionByZero extends Exception{
    int quotient;
    DivisionByZero(int a)
    {
        quotient=a;
    }
    public String toString(){
        return "Division By Zero";
    }
    
}
public static void main(String args[]){
    Fraction obj=new Fraction(2,0);
    try{
        obj.divide();
    }
    catch(DivisionByZero e)
    {
        System.out.println("Exception: "+e);
    }
}
}

