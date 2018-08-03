/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.logging.Logger;

/**
 *
 * @author nguyendoan
 */
public class Congvanden {

    private int Sothutu;
    private String Sohieu;
    private int Noibanhanh;
    private String Trichdan;
    private String Ngaybanhanh;
    private String Ngayapdung;
    private String Nguoiky;
    private String Ngayhethieuluc;
    private int Tinhtranghieuluc;
    private String Duongtai;
    private int Nguoixuly;
    private String Thoigiancongvanden;
    private String Thoigianxuly;

    public Congvanden() {
    }

    public Congvanden(String Sohieu, int Noibanhanh, String Trichdan, String Ngaybanhanh, String Nguoiky, String Duongtai, String Thoigiancongvanden) {
        this.Sohieu = Sohieu;
        this.Noibanhanh = Noibanhanh;
        this.Trichdan = Trichdan;
        this.Ngaybanhanh = Ngaybanhanh;
        this.Nguoiky = Nguoiky;
        this.Duongtai = Duongtai;
        this.Thoigiancongvanden = Thoigiancongvanden;
    }

    public String getThoigianxuly() {
        return Thoigianxuly;
    }

    public void setThoigianxuly(String Thoigianxuly) {
        this.Thoigianxuly = Thoigianxuly;
    }

    public void setSothutu(int Sothutu) {
        this.Sothutu = Sothutu;
    }

    public void setSohieu(String Sohieu) {
        this.Sohieu = Sohieu;
    }

    public void setNoibanhanh(int Noibanhanh) {
        this.Noibanhanh = Noibanhanh;
    }

    public void setTrichdan(String Trichdan) {
        this.Trichdan = Trichdan;
    }

    public void setNgaybanhanh(String Ngaybanhanh) {
        this.Ngaybanhanh = Ngaybanhanh;
    }

    public void setNgayapdung(String Ngayapdung) {
        this.Ngayapdung = Ngayapdung;
    }

    public void setNguoiky(String Nguoiky) {
        this.Nguoiky = Nguoiky;
    }

    public void setNgayhethieuluc(String Ngayhethieuluc) {
        this.Ngayhethieuluc = Ngayhethieuluc;
    }

    public void setTinhtranghieuluc(int Tinhtranghieuluc) {
        this.Tinhtranghieuluc = Tinhtranghieuluc;
    }

    public void setDuongtai(String Duongtai) {
        this.Duongtai = Duongtai;
    }

    public void setNguoixuly(int Nguoixuly) {
        this.Nguoixuly = Nguoixuly;
    }

    public void setThoigiancongvanden(String Thoigiancongvanden) {
        this.Thoigiancongvanden = Thoigiancongvanden;
    }

    public int getSothutu() {
        return Sothutu;
    }

    public String getSohieu() {
        return Sohieu;
    }

    public int getNoibanhanh() {
        return Noibanhanh;
    }

    public String getTrichdan() {
        return Trichdan;
    }

    public String getNgaybanhanh() {
        return Ngaybanhanh;
    }

    public String getNgayapdung() {
        return Ngayapdung;
    }

    public String getNguoiky() {
        return Nguoiky;
    }

    public String getNgayhethieuluc() {
        return Ngayhethieuluc;
    }

    public int getTinhtranghieuluc() {
        return Tinhtranghieuluc;
    }

    public String getDuongtai() {
        return Duongtai;
    }

    public int getNguoixuly() {
        return Nguoixuly;
    }

    public String getThoigiancongvanden() {
        return Thoigiancongvanden;
    }

    public Congvanden(int Sothutu, String Sohieu, int Noibanhanh, String Trichdan, String Ngaybanhanh, String Ngayapdung, String Nguoiky, String Ngayhethieuluc, int Tinhtranghieuluc, String Duongtai, int Nguoixuly, String Thoigiancongvanden) {
        this.Sothutu = Sothutu;
        this.Sohieu = Sohieu;
        this.Noibanhanh = Noibanhanh;
        this.Trichdan = Trichdan;
        this.Ngaybanhanh = Ngaybanhanh;
        this.Ngayapdung = Ngayapdung;
        this.Nguoiky = Nguoiky;
        this.Ngayhethieuluc = Ngayhethieuluc;
        this.Tinhtranghieuluc = Tinhtranghieuluc;
        this.Duongtai = Duongtai;
        this.Nguoixuly = Nguoixuly;
        this.Thoigiancongvanden = Thoigiancongvanden;
    }

    @Override
    public String toString() {
        return "Congvanden{" + "Sothutu=" + Sothutu + ", Sohieu=" + Sohieu + ", Noibanhanh=" + Noibanhanh + ", Trichdan=" + Trichdan + ", Ngaybanhanh=" + Ngaybanhanh + ", Ngayapdung=" + Ngayapdung + ", Nguoiky=" + Nguoiky + ", Ngayhethieuluc=" + Ngayhethieuluc + ", Tinhtranghieuluc=" + Tinhtranghieuluc + ", Duongtai=" + Duongtai + ", Nguoixuly=" + Nguoixuly + ", Thoigiancongvanden=" + Thoigiancongvanden + ", Thoigianxuly=" + Thoigianxuly + '}';
    }

   

}
