//question 3
public class BankAccount {
    String name;
    int num;
    char type;
    int amt;
    BankAccount(String s, int n,char c,int a)
    {
        name=s;
        num=n;
        type=c;
        amt=a;
    }
    void deposit(int n)
    {
        amt+=n;
    }
    void withdrawl(int n)
    {
        if((amt-n)<=1000)
        System.out.println("maintain a minimum balance of 1000");
        else
        amt-=n;

    }
    void display()
    {
        System.out.println("Holder name: "+name);
        System.out.println("account number: "+num);
        System.out.println("Account type: "+type);
        System.out.println("balance amount: "+amt);
    }
    public static void main(String[] args) {
        BankAccount obj=new BankAccount("Sanmoy", 12121, 'S', 2000);
        obj.deposit(3000);
        obj.withdrawl(2000);
        obj.display();
    }
}
