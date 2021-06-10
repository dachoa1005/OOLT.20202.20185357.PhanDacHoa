
package model;

import java.util.List;

public class Phong extends HinhHopChuNhat{
    private List<VatThe> listVatThe;
    private List<Camera> listCamera;

    public Phong() {
        super();
    }

    public Phong(ToaDo[] toaDoCacDinh, List<VatThe> listVatThe, List<Camera> listCamera) {
        super(toaDoCacDinh);
        this.listVatThe = listVatThe;
        this.listCamera = listCamera;
    }

    public List<VatThe> getListVatThe() {
        return listVatThe;
    }

    public void setListVatThe(List<VatThe> listVatThe) {
        this.listVatThe = listVatThe;
    }

    public List<Camera> getListCamera() {
        return listCamera;
    }

    public void setListCamera(List<Camera> listCamera) {
        this.listCamera = listCamera;
    }

    @Override
    public String toString() {
        String s = "";
        s+="Toa do phong:\n" + super.toString() + "\n";
        for (int i=0; i<listVatThe.size(); i++) {
            s += "Vat the " + (i+1) + ":\n" + listVatThe.get(i).toString() + "\n";
        }
        s += "Camera:\n";
        for (Camera vt : listCamera) {
            s += vt.toString() + "\n";
        }
        return s;
    }
    
    
}
