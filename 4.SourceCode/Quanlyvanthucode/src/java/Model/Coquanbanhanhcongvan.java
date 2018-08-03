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
public class Coquanbanhanhcongvan {
    private int Idcoquan;
    private String Tencoquan;
    private int Sodienthoai;
    private String Diachi;

    public Coquanbanhanhcongvan() {
    }

    public void setIdcoquan(int Idcoquan) {
        this.Idcoquan = Idcoquan;
    }

    public void setTencoquan(String Tencoquan) {
        this.Tencoquan = Tencoquan;
    }

    public void setSodienthoai(int SoFax) {
        this.Sodienthoai = SoFax;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public int getIdcoquan() {
        return Idcoquan;
    }

    public String getTencoquan() {
        return Tencoquan;
    }

    public int getSoDienthoai() {
        return Sodienthoai;
    }

    public String getDiachi() {
        return Diachi;
    }

    @Override
    public String toString() {
        return "Coquan{" + "Idcoquan=" + Idcoquan + ", Tencoquan=" + Tencoquan + ", SoDienthoai=" + Sodienthoai + ", Diachi=" + Diachi + '}';
    }

    public Coquanbanhanhcongvan(String Tencoquan, int Sodienthoai, String Diachi) {
        this.Tencoquan = Tencoquan;
        this.Sodienthoai = Sodienthoai;
        this.Diachi = Diachi;
    }

    public Coquanbanhanhcongvan(int Idcoquan, String Tencoquan, int Sodienthoai, String Diachi) {
        this.Idcoquan = Idcoquan;
        this.Tencoquan = Tencoquan;
        this.Sodienthoai = Sodienthoai;
        this.Diachi = Diachi;
    }

    
    
    
}
