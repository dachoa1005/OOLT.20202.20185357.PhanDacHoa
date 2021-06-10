
package model;

import java.util.ArrayList;
import java.util.List;

public class Camera {
    private ToaDo toaDo;
    private double gocRong;
    private double gocCao;

    public ToaDo getToaDo() {
        return toaDo;
    }

    public void setToaDo(ToaDo toaDo) {
        this.toaDo = toaDo;
    }

    public double getGocRong() {
        return gocRong;
    }

    public void setGocRong(double gocRong) {
        this.gocRong = gocRong;
    }

    public double getGocCao() {
        return gocCao;
    }

    public void setGocCao(double gocCao) {
        this.gocCao = gocCao;
    }
    
    public static List<Camera> taoListCamera(int soCamera, String[] cameraS){
        // param cameraS: (0, 0.5, 0.5) 90 90
        //                (1, 1, 0.5) 90 90 
        List<Camera> listCamera = new ArrayList<>();
        
        for(int i=0; i<soCamera; i++) {
            String[] s = cameraS[i].split(" ");
            
            // s[0] = "(0,"  ----   s[1] = "0.5,"   ----   s[2] = "0.5)"
            double toaDo[] = new double[3];
            for (int j=0; j<3; j++) {
                String t = "";
                for (char c : s[j].toCharArray())
                    if (Character.isDigit(c) || c == '.') t+=c;
                toaDo[j] = Double.parseDouble(t);
            }
          
            Camera cam = new Camera();
            cam.setGocRong(Double.parseDouble(s[3]));
            cam.setGocCao(Double.parseDouble(s[4]));
            cam.setToaDo(new ToaDo(toaDo[0], toaDo[1], toaDo[2]));
            
            listCamera.add(cam);
        }
        
        return listCamera;
    }

    @Override
    public String toString() {
        return "Camera{" + "toaDo=" + toaDo + ", gocRong=" + gocRong + ", gocCao=" + gocCao + '}';
    }
    
}
