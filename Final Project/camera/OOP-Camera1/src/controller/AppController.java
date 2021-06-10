
package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Camera;
import model.Phong;
import model.ToaDo;
import model.VatThe;
import view.ConsoleView;

public class AppController {
    private Phong phong;
    private ConsoleView view;

    public AppController() {
        phong = new Phong();
        view = new ConsoleView();
    }

    public AppController(Phong phong, ConsoleView view) {
        this.phong = phong;
        this.view = view;
    }
    
    public void run() {
        int choice = view.showMenu();
        switch (choice) {
            case 0:
                view.showMessage("Cảm ơn vì đã theo dõi.");
                System.exit(0);
            case 1:
                view.showMessage("Nhập input:");
                creatRoomFromInput();
                run();
            case 2:
                int ret[] = checkVatThe();
                if (ret[0] == 0) view.showMessage("Các vật thể đã nhập là hợp lệ.");
                if (ret[0] == 1) view.showMessage("Vật thể thứ " + (ret[1]+1) + " không phải là hình hộp chữ nhật. Vui lòng chọn 1 để nhập lại dữ liệu!");
                if (ret[0] == 2) view.showMessage("Vật thể thứ " + (ret[1]+1) + " không nằm trong phòng đã nhập. Vui lòng chọn 1 để nhập lại dữ liệu!");
                if (ret[0] == 3) view.showMessage("Vật thể thứ " + (ret[1]+1) + " không tiếp xúc với sàn và cũng không nằm trên bất kỳ vật thể nào khác. Vui lòng chọn 1 để nhập lại dữ liệu!");
                run();
            case 3:
                int ret1[] = checkCamera();
                if (ret1[0] == 1) view.showMessage("Camera thứ " + (ret1[1]+1) + " không nằm trong phòng đã nhập. Vui lòng chọn 1 để nhập lại dữ liệu!");
                else view.showMessage("Các camera đã nhập là hợp lệ.");
                run();
            case 4:
                ToaDo X = view.get1Diem();
                if (!checkDiemThuocPhong(X)) view.showMessage("Điểm đã nhập không nằm trong phòng.");
                else {
                    view.showMessage("Điểm đã nhập nằm trong phòng.");
                    int[] ret2 = checkDiemThuocVT(X);
                    if (ret2[0] == 0) view.showMessage("Điểm đã nhập không thuộc bất kỳ vật thể nào.");
                    else {
                        String s = "";
                        s += "Điểm đã nhập thuộc vật thể thứ ";
                        for (int i=1; i<ret2.length-1; i++) s += ret2[i] + ", ";
                        s += ret2[ret2.length-1] + ".";
                        view.showMessage(s);
                    }
                }
                run();
            default:
                view.showMessage("Chỉ lựa chọn 0->4.");
                run();
        }
    }

    public void creatRoomFromInput() {
        Object[] input = view.getInput();
        
        String toaDoPhongS = (String) input[0];
        int soVatThe = (int) input[1];
        String[] vatTheS = (String[]) input[2];
        int soCamera = (int) input[3];
        String[] cameraS = (String[]) input[4];
        
        List<VatThe> listVatThe = VatThe.taoListVatThe(soVatThe, vatTheS);
        
        List<Camera> listCamera = Camera.taoListCamera(soCamera, cameraS);
        
        phong = new Phong(ToaDo.toaDoStrToArr(toaDoPhongS), listVatThe, listCamera);
        System.out.println(phong.toString());
    }
    
    public int[] checkVatThe() {
        List<VatThe> listVatThe = this.phong.getListVatThe();
        
        for (int i=0; i<listVatThe.size(); i++) {
            ToaDo[] dinh = listVatThe.get(i).getToaDoCacDinh();
            
            if (!isHHCN(dinh)) return new int[]{1, i};
            
            if (!isInRoom(dinh)) return new int[]{2, i};
            
            if (tiepXuc(dinh)[0] == 0) return new int[]{3,i};
        }
        return new int[]{0};
    }
    
    public boolean isHHCN(ToaDo[] t) {
        // (0, 0, 0) (2, 0, 0) (2, 1, 0) (0, 1, 0) (0, 0, 1) (2, 0, 1) (2, 1, 1) (0, 1, 1)
        if(!(t[0].getZ() == t[1].getZ() && t[1].getZ() == t[2].getZ() && t[2].getZ() == t[3].getZ()
        && t[4].getZ() == t[5].getZ() && t[5].getZ() == t[6].getZ() && t[6].getZ() == t[7].getZ()))
            return false;
        for (int i=0; i<4; i++)
            if (!(t[i].getX() == t[i+4].getX() && t[i].getY() == t[i+4].getY()))
                return false;
        return true;
         
    }
    
    public boolean check1DiemThuocHHCN (double theTichHHCN, ToaDo X, ToaDo[] t){
        // kiểm tra điểm X có nằm trong HHCN có 8 toạ độ t 
        double tongV6Chop = 0;
        tongV6Chop += ToaDo.theTichChopChuNhat2(X, t[0], t[1], t[2], t[3]);
        tongV6Chop += ToaDo.theTichChopChuNhat2(X, t[1], t[2], t[6], t[5]);
        tongV6Chop += ToaDo.theTichChopChuNhat2(X, t[4], t[5], t[6], t[7]);
        tongV6Chop += ToaDo.theTichChopChuNhat2(X, t[0], t[3], t[7], t[4]);
        tongV6Chop += ToaDo.theTichChopChuNhat2(X, t[2], t[3], t[7], t[6]);
        tongV6Chop += ToaDo.theTichChopChuNhat2(X, t[0], t[1], t[5], t[4]);
//        view.showMessage("Vhhcn="+theTichHHCN);
//        view.showMessage("V6chop="+tongV6Chop);
        if (Math.abs(tongV6Chop - theTichHHCN) <= 0.000001) return true;
        return false;
    }
    
    public boolean isInRoom(ToaDo[] dinh) {
        // đến đây vật thể đã là HHCN
        ToaDo[] t = phong.getToaDoCacDinh();
        double theTichPhong = phong.theTich();
        // xét lần lượt 8 đỉnh, mỗi đỉnh tính V 6 chóp cộng lại so sánh với V phòng
        for (int i=0; i<8; i++)  {
            if (!check1DiemThuocHHCN(theTichPhong, dinh[i], t)) return false;
        }
        return true;
    }
    
    public int[] tiepXuc(ToaDo[] dinh) {
        // đến đây vật thể đã là HHCN và nằm trong phòng
        ToaDo[] t = phong.getToaDoCacDinh();
        // kiểm tra tiếp xúc sàn
        // kiểm tra dinh[0] thuộc ABCD không?
        if (ToaDo.theTichChopChuNhat2(dinh[0], t[0], t[1], t[2], t[3]) == 0) {
            return new int[]{1}; // tiếp xúc sàn
        }
        // không tx sàn, ktra nằm trên vật
        List<VatThe> listVatThe = this.phong.getListVatThe();
        for (int j=0; j<listVatThe.size(); j++) {
            // kiểm tra dinh[0] thuộc mặt trên (4567) của vt j không?
            ToaDo[] tt = listVatThe.get(j).getToaDoCacDinh();
            if (ToaDo.theTichChopChuNhat2(dinh[0], tt[4], tt[5], tt[6], tt[7]) == 0) {
                // nằm trên vật. kiểm tra nốt dinh[0->3] có cái nào nằm trong HCN 4567 không?
                for (int i=0; i<4; i++) {
                    // diện tích HCN mặt trên
                    double s4567 = 2 * ToaDo.dienTichTamGiac(tt[4], tt[5], tt[6]);
                    // tính diện tích 4 tam giác từ điểm dinh[i] đến từng cạnh
                    double si45 = ToaDo.dienTichTamGiac(dinh[i], tt[4], tt[5]);
                    double si56 = ToaDo.dienTichTamGiac(dinh[i], tt[5], tt[6]);
                    double si67 = ToaDo.dienTichTamGiac(dinh[i], tt[6], tt[7]);
                    double si74 = ToaDo.dienTichTamGiac(dinh[i], tt[7], tt[4]);
                    // chỉ cần 1 trong 4 điểm của đáy dinh[] nằm trong HCN mặt trên của vt là ok
                    if (si45 + si56 + si67 + si74 == s4567) return new int[]{2, j};
                }

            }
        }
        return new int[]{0};
    }
    
    public int[] checkCamera() {
        // Cam có nằm trong phòng hay không?
        ToaDo[] t = phong.getToaDoCacDinh();
        List<Camera> cam = phong.getListCamera();
        
        double theTichPhong = phong.theTich();
        
        for (int i=0; i<cam.size(); i++) {
            ToaDo diem = cam.get(i).getToaDo();
            if (!check1DiemThuocHHCN(theTichPhong, diem, t)) return new int[]{1,i};
        }
        return new int[]{0};
    }
    
    public boolean checkDiemThuocPhong(ToaDo X) {
        ToaDo[] t = phong.getToaDoCacDinh();
        
        double theTichPhong = phong.theTich();
        
        if (check1DiemThuocHHCN(theTichPhong, X, t)) return true;
        return false;
    }
    
    public int[] checkDiemThuocVT(ToaDo X) {
        List<VatThe> listVatThe = this.phong.getListVatThe();
        List<Integer> listVTthoaManX = new ArrayList<>();
        for (int i=0; i<listVatThe.size(); i++) {
            VatThe vt = listVatThe.get(i);
            
            ToaDo[] t = vt.getToaDoCacDinh();
            
            double theTichVT = vt.theTich();
            
            if (check1DiemThuocHHCN(theTichVT, X, t)) listVTthoaManX.add(i);
        }
        if (listVTthoaManX.isEmpty()) return new int[]{0};
        else {
            int[] ret = new int[listVTthoaManX.size()+1];
            ret[0] = 1;
            for (int i=1; i<ret.length; i++)
                ret[i] = listVTthoaManX.get(i-1);
            return ret;
        }
    }
}
