/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nguyendoan
 */
public class Tinhtrangxuly {
    private int idXuly;
    private String Tentrangthai;

    public int getIdXuly() {
        return idXuly;
    }

    public String getTentrangthai() {
        return Tentrangthai;
    }

    public void setIdXuly(int idXuly) {
        this.idXuly = idXuly;
    }

    public void setTentrangthai(String Tentrangthai) {
        this.Tentrangthai = Tentrangthai;
    }

    public Tinhtrangxuly(int idXuly, String Tentrangthai) {
        this.idXuly = idXuly;
        this.Tentrangthai = Tentrangthai;
    }

    @Override
    public String toString() {
        return "Tinhtrangxuly{" + "idXuly=" + idXuly + ", Tentrangthai=" + Tentrangthai + '}';
    }
    
}
