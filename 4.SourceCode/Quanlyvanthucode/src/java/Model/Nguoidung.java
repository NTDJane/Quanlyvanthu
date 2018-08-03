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
public class Nguoidung {

    private int Idcanhan;
    private String Hoten;
    private String Diachi;
    private String Ngaysinh;
    private int Gioitinh;
    private int Coquan;
    private String Email;
    private String Password;
    private int Sodienthoai;
    private int Quyenhanh;

    public Nguoidung() {
    }

    public Nguoidung(int Idcanhan, String Hoten, String Diachi, String Ngaysinh, String Email, int Sodienthoai) {
        this.Idcanhan = Idcanhan;
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.Ngaysinh = Ngaysinh;
        this.Email = Email;
       
        this.Sodienthoai = Sodienthoai;
    }

    
    
    public Nguoidung(String Hoten, String Diachi, String Ngaysinh, int Gioitinh, int Coquan, String Email, String Password, int Sodienthoai,int quyenhanh) {
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.Ngaysinh = Ngaysinh;
        this.Gioitinh = Gioitinh;
        this.Coquan=Coquan;
        this.Email = Email;
        this.Password = Password;
        this.Sodienthoai = Sodienthoai;
        this.Quyenhanh=quyenhanh;
    }
    
    

    public Nguoidung(int Idcanhan, String Hoten, String Diachi, String Ngaysinh, int Gioitinh, int Coquan, String Email, String Password, int Sodienthoai, int Quyenhanh) {
        this.Idcanhan = Idcanhan;
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.Ngaysinh = Ngaysinh;
        this.Gioitinh = Gioitinh;
        this.Coquan = Coquan;
        this.Email = Email;
        this.Password = Password;
        this.Sodienthoai = Sodienthoai;
        this.Quyenhanh = Quyenhanh;
    }

   

    public String getHoten() {
        return Hoten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public int getGioitinh() {
        return Gioitinh;
    }

    public int getCoquan() {
        return Coquan;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public int getSodienthoai() {
        return Sodienthoai;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public void setGioitinh(int Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public void setCoquan(int Coquan) {
        this.Coquan = Coquan;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setSodienthoai(int Sodienthoai) {
        this.Sodienthoai = Sodienthoai;
    }

    public int getIdcanhan() {
        return Idcanhan;
    }

    public void setIdcanhan(int Idcanhan) {
        this.Idcanhan = Idcanhan;
    }

    public int getQuyenhanh() {
        return Quyenhanh;
    }

    public void setQuyenhanh(int Quyenhanh) {
        this.Quyenhanh = Quyenhanh;
    }

    @Override
    public String toString() {
        return "Nguoidung{" + "Idcanhan=" + Idcanhan + ", Hoten=" + Hoten + ", Diachi=" + Diachi + ", Coquan=" + Coquan + ", Email=" + Email + ", Password=" + Password + ", Quyenhanh=" + Quyenhanh + '}';
    }

    

}
