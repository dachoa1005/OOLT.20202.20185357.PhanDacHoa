import java.util.Scanner;
public class Giaipt2an {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("a11x+a12y=b1\na21x+a22y=b2\n");
        System.out.print("Nhap vao cac so a11, a12, a21, a22, b1, b2: ");
        int a11= in.nextInt();
        int a12= in.nextInt();
        int a21= in.nextInt();
        int a22= in.nextInt();
        int b1= in.nextInt();
        int b2= in.nextInt();
        int det = (a11 * a22 - a12 * a21); 
         int det1 = (b1 * a22 - b2 * a21);
        int det2 = (a11 * b2 - a21 * b1);
        if(det!=0) {
            float x = (float) det1 / det;
            float y = (float) det2 / det;
            System.out.print("x=" + x + " y=" + y);
        }
        else if(det==0) {
            if(det1 == det2 && det== det1) {
                System.out.println("infinitely many solutions");
            }
            System.out.println("Error");
        }
        in.close();
    }
}