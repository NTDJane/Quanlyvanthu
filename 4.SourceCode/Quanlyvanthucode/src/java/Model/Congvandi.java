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
public class Congvandi {
    private int idcongvan;
    private String Sohieuvanbandi;
    private String Ngayphathanh;
    private String Nguoiky;
    private int Donvibanhanh;
    private String Trichdan;
    private String Ngaycongvandi;
    private String Noinhan;
    private String Duongdan;

    public Congvandi() {
    }

    
    
    
    public int getIdcongvan() {
        return idcongvan;
    }

    public String getSohieuvanbandi() {
        return Sohieuvanbandi;
    }

    public String getNgayphathanh() {
        return Ngayphathanh;
    }

    public String getNguoiky() {
        return Nguoiky;
    }

    public int getDonvibanhanh() {
        return Donvibanhanh;
    }

    public String getTrichdan() {
        return Trichdan;
    }

    public String getNgaycongvandi() {
        return Ngaycongvandi;
    }

    public String getNoinhan() {
        return Noinhan;
    }

    public String getDuongdan() {
        return Duongdan;
    }

    public void setIdcongvan(int idcongvan) {
        this.idcongvan = idcongvan;
    }

    public void setSohieuvanbandi(String Sohieuvanbandi) {
        this.Sohieuvanbandi = Sohieuvanbandi;
    }

    public void setNgayphathanh(String Ngayphathanh) {
        this.Ngayphathanh = Ngayphathanh;
    }

    public void setNguoiky(String Nguoiky) {
        this.Nguoiky = Nguoiky;
    }

    public void setDonvibanhanh(int Donvibanhanh) {
        this.Donvibanhanh = Donvibanhanh;
    }

    public void setTrichdan(String Trichdan) {
        this.Trichdan = Trichdan;
    }

    public void setNgaycongvandi(String Ngaycongvandi) {
        this.Ngaycongvandi = Ngaycongvandi;
    }

    public void setNoinhan(String Noinhan) {
        this.Noinhan = Noinhan;
    }

    public void setDuongdan(String Duongdan) {
        this.Duongdan = Duongdan;
    }

    public Congvandi(String Sohieuvanbandi, String Ngayphathanh, String Nguoiky, int Donvibanhanh, String Trichdan, String Ngaycongvandi, String Noinhan, String Duongdan) {
        this.Sohieuvanbandi = Sohieuvanbandi;
        this.Ngayphathanh = Ngayphathanh;
        this.Nguoiky = Nguoiky;
        this.Donvibanhanh = Donvibanhanh;
        this.Trichdan = Trichdan;
        this.Ngaycongvandi = Ngaycongvandi;
        this.Noinhan = Noinhan;
        this.Duongdan = Duongdan;
    }

    @Override
    public String toString() {
        return "Congvandi{" + "idcongvan=" + idcongvan + ", Sohieuvanbandi=" + Sohieuvanbandi + ", Ngayphathanh=" + Ngayphathanh + ", Nguoiky=" + Nguoiky + ", Donvibanhanh=" + Donvibanhanh + ", Trichdan=" + Trichdan + ", Ngaycongvandi=" + Ngaycongvandi + ", Noinhan=" + Noinhan + ", Duongdan=" + Duongdan + '}';
    }
    
    
    
    
    
    
}
