
package model;

import java.util.ArrayList;
import java.util.List;

public class VatThe extends HinhHopChuNhat{
    
    public VatThe(ToaDo[] toaDoCacDinh) {
        super(toaDoCacDinh);
    }

    @Override
    public ToaDo[] getToaDoCacDinh() {
        return super.getToaDoCacDinh(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static List<VatThe> taoListVatThe(int soVatThe, String[] vatTheS) {
        List<VatThe> listVatThe = new ArrayList<>();
        
        for (int i=0; i<soVatThe; i++) {
            ToaDo[] toaDoVatThe = ToaDo.toaDoStrToArr(vatTheS[i]);
            
            VatThe vt = new VatThe(toaDoVatThe);
            listVatThe.add(vt);
        }
        
        return listVatThe;
    }
}
