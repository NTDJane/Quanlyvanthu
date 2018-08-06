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
public class Phanquyen {
    private int idquyen;
    private String Tenquyen;

    public Phanquyen() {
    }

    public int getIdquyen() {
        return idquyen;
    }

    public String getTenquyen() {
        return Tenquyen;
    }

    public void setIdquyen(int idquyen) {
        this.idquyen = idquyen;
    }

    public void setTenquyen(String Tenquyen) {
        this.Tenquyen = Tenquyen;
    }

    @Override
    public String toString() {
        return "Phanquyen{" + "idquyen=" + idquyen + ", Tenquyen=" + Tenquyen + '}';
    }
    
    
}
