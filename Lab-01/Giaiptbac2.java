import java.util.Scanner;
public class Giaiptbac2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Giai phuong trinh ax^2+bx+c=0\n");
        System.out.print("Nhap 3 so a, b, c: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double delta = b * b - 4.0 * a * c;
        if(delta == 0.0) {
            double x = -b/ (2.0 * a);
            System.out.println("x = " + x);
        }else if(delta > 0.0){
            double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
            System.out.println("x1 = " + x1 + " x2 = " + x2);
        }else {
            System.out.println("Phuong trinh vo nghiem");
        }
        in.close();
    }
}