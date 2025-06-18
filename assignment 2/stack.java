//question 6
public class stack {
    int arr[];
    stack(int n)
    {
        arr=new int[n];
    }
    public static void main(String[] args) {
        stack o=new stack(30);
        int top=0;
        o.arr[top++]=10;
        o.arr[top++]=20;
        o.arr[top++]=30;
        o.arr[top++]=15;
        o.arr[top++]=9;
        System.out.println("Printing the stack");
        for(int i=0;i<top;i++)
        {
            System.out.println(o.arr[i]);
        }
        System.out.println("poped element: "+o.arr[--top]);
        System.out.println("poped element: "+o.arr[--top]);
        System.out.println("poped element: "+o.arr[--top]);
        System.out.println("remaining elements: ");
        for(int i=0;i<=top;i++)
        {
            System.out.println(o.arr[i]);
        }
        



    }
}
