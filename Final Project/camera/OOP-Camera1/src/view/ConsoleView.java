package view;

import controller.AppController;
import java.util.Scanner;
import model.Phong;
import model.ToaDo;

public class ConsoleView {
    public static Scanner sc = new Scanner(System.in);
    
    public void showMessage(String s) {
        System.out.println(s);
    }
    
    public int showMenu(){
        System.out.println("---------MENU---------");
        System.out.println("1. Nhập thông tin phòng, vật thể, camera theo format cho trước.");
        System.out.println("2. Kiểm tra tính hợp lệ của các vật thể đã nhập.");
        System.out.println("3. Kiểm tra tính hợp lệ của các camera đã nhập.");
        System.out.println("4. Kiểm tra điểm bất kỳ có nằm trong phòng và thuộc vật thể nào hay không.");
        System.out.println("0. Thoát chương trình.");
        
        System.out.print("Lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public Object[] getInput() {
        String toaDoPhongS = sc.nextLine();
        
        int soVatThe = Integer.parseInt(sc.nextLine());
        String[] vatTheS = new String[soVatThe];
        for (int i=0; i<soVatThe; i++) vatTheS[i] = sc.nextLine();
        
        int soCamera  = Integer.parseInt(sc.nextLine());
        String[] cameraS = new String[soCamera];
        for (int i=0; i<soCamera; i++) cameraS[i] = sc.nextLine();
        
        return new Object[]{
            toaDoPhongS, soVatThe, vatTheS, soCamera, cameraS
        };
    }
    
    public ToaDo get1Diem() {
        System.out.print("Nhập 3 toạ độ của 1 diểm bất kỳ (cách nhau 1 dấu cách): ");
        String toaDoS = sc.nextLine();
        String[] split = toaDoS.split(" ");
        return new ToaDo(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
    }
}
