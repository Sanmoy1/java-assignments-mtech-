public class question6 {
    public static void main(String[] args) {
        int a[][]=new int[3][2];
        int b[][]=new int[3][2];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                a[i][j]=i+j;
                b[i][j]=i*j;
            }
        }
        

        System.out.println("added matrix:");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.print(a[i][j]+b[i][j]+" ");
            }
            System.out.println();
        }

        
    }
}
