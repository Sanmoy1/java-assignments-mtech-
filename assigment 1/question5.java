public class question5 {
    public static void main(String[] args) {
        int arr[]=new int[15];
        for(int i=0;i<15;i++)
        {
            arr[i]=i*2;
        }
        System.out.println("original array");
        for(int i=0;i<15;i++)
        {
            System.out.println(arr[i]);
        }
        for(int i=0;i<15/2;i++)
        {
            int t=arr[i];
            arr[i]=arr[14-i];
            arr[14-i]=t;

        }
        System.out.println("reserse array");
        for(int i=0;i<15;i++)
        {
            System.out.println(arr[i]);
        }

    }
    
}
