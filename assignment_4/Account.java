class Account{
    String name;
    int acc_no;
    char type;
    int mobile_no;
    int acc_balance;
    Account(String n,int a,char t,int m,int b){
    name=n;
    acc_no=a;
    type=t;
    mobile_no=m;
    acc_balance=b;
}
    void deposit(int a)throws NegativeAmount
    {
        if(a<0)
        throw new NegativeAmount();
        acc_balance+=a;
        System.out.println("The account balance is: "+acc_balance);
    }
    void withdraw(int a)throws InsufficientBalance
    {    
        
        if((acc_balance-a)<1000)
        throw new InsufficientBalance();
        else
        acc_balance-=a;
        System.out.println("The account balance is: "+acc_balance);
    }
    void display()
    {
        System.out.println("Name: "+name);
        System.out.println("Account Number: "+acc_no);
        System.out.println("type: "+type);
        System.out.println("Mobile number: "+mobile_no);
        System.out.println("Account balance: "+acc_balance);

    }
    class NegativeAmount extends Exception
    {
        
        public String toString()
        {
            return "Negative Amount";
        }
    }
    class InsufficientBalance extends Exception{
        
        public String toString()
        {
            return "InsufficientBalance";
        }
    }
    public static void main(String args[]) {
    Account ob = new Account("Sanmoy", 12212, 'S', 909980931, 2000);
    try {
        ob.deposit(-100);
    } catch (NegativeAmount e) {
        System.out.println("Error: " + e);
    }
    
    try {
        ob.deposit(200);
    } catch (NegativeAmount e) {
        System.out.println("Error: " + e);
    }
    
    try {
        ob.withdraw(2300);
    } catch (InsufficientBalance e) {
        System.out.println("Error: " + e);
    }
    
    try {
        ob.withdraw(300);
    } catch (InsufficientBalance e) {
        System.out.println("Error: " + e);
    }
    
    try {
        ob.withdraw(100);
    } catch (InsufficientBalance e) {
        System.out.println("Error: " + e);
    }
    
    ob.display();
}

}