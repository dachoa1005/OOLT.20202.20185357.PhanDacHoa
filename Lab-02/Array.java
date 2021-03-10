import java.util.*;
public class Array {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double A[]=new double[1000];
        int i;
        int n;
        Random rand = new Random();
        for(i=0;i<1000;i++)
        {
            A[i]=rand.nextInt(9999);
        }
        System.out.print("Nhap n la so phan tu cua mang: n= ");
        n = keyboard.nextInt();
        double B[]=new double[n];
        for(i=0;i<n;i++)
        {
            
            System.out.print("B["+i+"]= ");
            String tmp = keyboard.next();
            if(tmp.equals("$"))
            {
                B[i]=A[i];
            }else{
                B[i]=Double.parseDouble(tmp);
            }
        }
        Arrays.sort(B);
        System.out.println("Mang sau khi sap xep: ");
        double sum=0;
        for(i=0;i<B.length;i++)
        {   
            sum+=B[i];
            System.out.print(B[i]+" ");
        }
        System.out.println("\nTong cua mang: "+sum);
        System.out.println("Trung binh cong: "+sum/B.length);
        keyboard.close();
    }
}