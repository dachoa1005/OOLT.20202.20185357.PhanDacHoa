package model;

public class HinhHopChuNhat {
    private ToaDo[] toaDoCacDinh = new ToaDo[8];

    public HinhHopChuNhat() {
    }

    public HinhHopChuNhat(ToaDo[] toaDoCacDinh) {
        this.toaDoCacDinh = toaDoCacDinh;
    }

    public ToaDo[] getToaDoCacDinh() {
        return toaDoCacDinh;
    }

    public double theTich() {
        return Math.abs(ToaDo.tichVoHuong(ToaDo.tichCoHuong(ToaDo.toaDoVector(toaDoCacDinh[0], toaDoCacDinh[1]), ToaDo.toaDoVector(toaDoCacDinh[0], toaDoCacDinh[3])), ToaDo.toaDoVector(toaDoCacDinh[0], toaDoCacDinh[4])));
    }

    @Override
    public String toString() {
        String s = "";
        int ind=-1;
        for (ToaDo t : toaDoCacDinh) {
            ind++;
            s += "Dinh " + ind + ": ToaDo{" + "x=" + t.getX() + ", y=" + t.getY() + ", z=" + t.getZ() + '}' + '\n'; 
        }
        return s;
    }
    
}
