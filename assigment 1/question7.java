public class question7 {
    public static void main(String[] args) {
        char a[]={'H','E','L','L','O'};
        for(int i=0;i<a.length/2;i++)
        {
            char t=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=t;
        }
        
        System.out.println(a);
    }
}
