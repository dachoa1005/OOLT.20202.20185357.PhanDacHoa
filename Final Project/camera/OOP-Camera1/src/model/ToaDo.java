package model;

import java.util.ArrayList;
import java.util.List;

public class ToaDo {
    private double x;
    private double y;
    private double z;

    public ToaDo() {
    }
    
    public ToaDo(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    public static ToaDo[] toaDoStrToArr(String toaDoCacDinhStr) {
        //param:(0, 0, 0) (2, 0, 0) (2, 1, 0) (0, 1, 0) (0, 0, 1) (2, 0, 1) (2, 1, 1) (0, 1, 1)
        List<Double> list = new ArrayList();
        
        String[] split = toaDoCacDinhStr.split(" ");
        
        String toaDo="";
        for (String s : split) {
            for (char c : s.toCharArray())
                if (Character.isDigit(c) || c == '.') toaDo+=c;
            list.add(Double.parseDouble(toaDo));
            toaDo="";
        }
        
        ToaDo[] toaDoCacDinhArr = new ToaDo[8];
        int index=0;
        for (int i=0; i<8; i++)
            toaDoCacDinhArr[i] = new ToaDo(list.get(index++), list.get(index++), list.get(index++));
        return toaDoCacDinhArr;
    }
    
    public static double khoangCach(ToaDo A, ToaDo B) {
        return Math.sqrt((A.getX()-B.getX())*(A.getX()-B.getX())+(A.getY()-B.getY())*(A.getY()-B.getY())+(A.getZ()-B.getZ())*(A.getZ()-B.getZ()));
    }
    
    public static ToaDo toaDoVector(ToaDo A, ToaDo B) {
        return new ToaDo(B.getX()-A.getX(), B.getY()-A.getY(), B.getZ()-A.getZ());
    }
    
    public static double tichVoHuong(ToaDo vt1, ToaDo vt2) {
        return vt1.getX()*vt2.getX() + vt1.getY()*vt2.getY() + vt1.getZ()*vt2.getZ();
    }
    
    public static ToaDo tichCoHuong(ToaDo vt1, ToaDo vt2) {
        return new ToaDo(vt1.getY()*vt2.getZ()-vt1.getZ()*vt2.getY(), vt1.getX()*vt2.getZ()-vt1.getZ()*vt2.getX(), vt1.getX()*vt2.getY()-vt1.getY()*vt2.getX());
    }
    
    public static double theTichChopTamGiac(ToaDo A, ToaDo B, ToaDo C, ToaDo D) {
        return Math.abs(tichVoHuong(tichCoHuong(toaDoVector(A, B), toaDoVector(A, C)), toaDoVector(A, D)))/6;
    }
    public static double theTichChopChuNhat(ToaDo S, ToaDo A, ToaDo B, ToaDo C, ToaDo D) {
        return 2 * theTichChopTamGiac(S, A, B, C);
    }
    
    public static  double[] phuongTrinhMatPhang(ToaDo A, ToaDo B, ToaDo C, ToaDo D) {
        ToaDo mnp = tichCoHuong(toaDoVector(A, B), toaDoVector(A, D));
        double m = mnp.getX();
        double n = mnp.getY();
        double p = mnp.getZ();
        double q = -m*A.getX()-n*A.getY()-p*A.getZ();
        return new double[]{m, n, p, q};
    }
    
    public static double khoangCachDiemDenMatPhang(ToaDo S, double[] ptmp) {
        double m = ptmp[0], n = ptmp[1], p = ptmp[2], q = ptmp[3];
        return Math.abs(m*S.getX()+n*S.getY()+p*S.getZ()+q)/Math.sqrt(m*m+n*n+p*p);
    }
    
    public static double theTichChopChuNhat2(ToaDo S, ToaDo A, ToaDo B, ToaDo C, ToaDo D) {
        return khoangCachDiemDenMatPhang(S, phuongTrinhMatPhang(A, B, C, D)) * khoangCach(A, B) * khoangCach(A, D) / 3;
    }
    
    public static double dienTichTamGiac(ToaDo A, ToaDo B, ToaDo C) {
        return Math.abs((B.getX()-A.getX())*(C.getY()-C.getY())-(C.getX()-A.getX())*(B.getY()-A.getY()))/2;
    }

    @Override
    public String toString() {
        return "ToaDo{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
}
