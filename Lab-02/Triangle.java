import java.util.Scanner;
public class Triangle {
    public static void Triangle(int n)
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j< 2*n-1; j++ )
            {
                if ((j >= n-i-1) && (j <= n+i-1))
                System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        System.out.println("Nhap n la chieu cao cua tam giac: ");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        Triangle(n);
    }
}