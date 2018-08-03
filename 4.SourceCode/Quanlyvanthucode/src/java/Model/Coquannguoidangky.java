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
public class Coquannguoidangky {
    private int idCoquan;
    private String Tencoquan;
    private String Diachi;
    private int Sodienthoai;

    public Coquannguoidangky(String Tencoquan, String Diachi, int Sodienthoai) {
        this.Tencoquan = Tencoquan;
        this.Diachi = Diachi;
        this.Sodienthoai = Sodienthoai;
    }

    public int getIdCoquan() {
        return idCoquan;
    }

    public String getTencoquan() {
        return Tencoquan;
    }

    public String getDiachi() {
        return Diachi;
    }

    public int getSodienthoai() {
        return Sodienthoai;
    }

    public void setIdCoquan(int idCoquan) {
        this.idCoquan = idCoquan;
    }

    public void setTencoquan(String Tencoquan) {
        this.Tencoquan = Tencoquan;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public void setSodienthoai(int Sodienthoai) {
        this.Sodienthoai = Sodienthoai;
    }

    @Override
    public String toString() {
        return "Coquannguoidangky{" + "idCoquan=" + idCoquan + ", Tencoquan=" + Tencoquan + ", Diachi=" + Diachi + ", Sodienthoai=" + Sodienthoai + '}';
    }

    public Coquannguoidangky() {
    }
    
    
}
