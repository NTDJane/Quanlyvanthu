/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Helpers;

import Model.Congvanden;
import Model.Nguoidung;
import Tool.MD5;
//import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyendoan
 */
public class Nguoidungquerry {

    private Connection ketnoi;
    private ResultSet ketqua;
    //  Congvan congvan = new Congvan();

    public Nguoidungquerry() throws IOException {
        Properties thongtin = new Properties();
        InputStream khoitao = getClass().getResourceAsStream("InformationDatabase.properties");
        thongtin.load(khoitao);
        khoitao.close();
        String driver = thongtin.getProperty("driver.name");
        String server = thongtin.getProperty("server.name");
        String username = thongtin.getProperty("user.name");
        String userpassword = thongtin.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Congvanquerry.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ketnoi = (Connection) DriverManager.getConnection(server, username, userpassword);
        } catch (SQLException ex) {
            Logger.getLogger(Congvanquerry.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Nguoidung Dangnhapnguoidung(String email, String password) throws SQLException {

        String sql = "select * from Thongtincanhan where Email=? and Password=?";
        PreparedStatement preparedstatement = ketnoi.prepareStatement(sql);

        preparedstatement.setString(1, email);
        preparedstatement.setString(2, password);

        this.ketqua = preparedstatement.executeQuery();

        // ArrayList<Nguoidung> list=new ArrayList<>();
        while (this.ketqua.next()) {
            Nguoidung nguoidung = new Nguoidung();
            nguoidung.setIdcanhan(ketqua.getInt("idThongtincanhan"));
            nguoidung.setHoten(ketqua.getString("Hoten"));
            nguoidung.setDiachi(ketqua.getString("Diachi"));
            nguoidung.setCoquan(ketqua.getInt("Coquancongtac"));
            nguoidung.setNgaysinh(ketqua.getString("Ngaysinh"));
            nguoidung.setEmail(ketqua.getString("Email"));
            nguoidung.setPassword(ketqua.getString("Password"));
            nguoidung.setSodienthoai(ketqua.getInt("Sodienthoai"));
            nguoidung.setGioitinh(ketqua.getInt("Gioitinh"));
            nguoidung.setQuyenhanh(ketqua.getInt("Phanquyen"));
            // list.add(nguoidung);
            return nguoidung;
        }
        return null;

    }

    public ArrayList<Nguoidung> Danhsachnguoidung() throws SQLException {

        String sql = "select * from Thongtincanhan ";
        PreparedStatement preparedstatement = ketnoi.prepareStatement(sql);

        this.ketqua = preparedstatement.executeQuery();

        ArrayList<Nguoidung> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Nguoidung nguoidung = new Nguoidung();
            nguoidung.setIdcanhan(ketqua.getInt("idThongtincanhan"));
            nguoidung.setHoten(ketqua.getString("Hoten"));
            nguoidung.setDiachi(ketqua.getString("Diachi"));
            nguoidung.setCoquan(ketqua.getInt("Coquancongtac"));
            nguoidung.setNgaysinh(ketqua.getString("Ngaysinh"));
            nguoidung.setEmail(ketqua.getString("Email"));
            nguoidung.setPassword(ketqua.getString("Password"));
            nguoidung.setSodienthoai(ketqua.getInt("Sodienthoai"));
            nguoidung.setGioitinh(ketqua.getInt("Gioitinh"));
            nguoidung.setQuyenhanh(ketqua.getInt("Phanquyen"));
            list.add(nguoidung);

        }
        return list;

    }

    public ArrayList<Nguoidung> Danhsachnguoidungcuacongty(int macongty, int phanquyen) throws SQLException {

        String sql = "select * from Thongtincanhan where Coquancongtac=? and Phanquyen>? ";
        PreparedStatement preparedstatement = ketnoi.prepareStatement(sql);
        preparedstatement.setInt(1, macongty);
        preparedstatement.setInt(2, phanquyen);
        this.ketqua = preparedstatement.executeQuery();

        ArrayList<Nguoidung> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Nguoidung nguoidung = new Nguoidung();
            nguoidung.setIdcanhan(ketqua.getInt("idThongtincanhan"));
            nguoidung.setHoten(ketqua.getString("Hoten"));
            nguoidung.setDiachi(ketqua.getString("Diachi"));
            nguoidung.setCoquan(ketqua.getInt("Coquancongtac"));
            nguoidung.setNgaysinh(ketqua.getString("Ngaysinh"));
            nguoidung.setEmail(ketqua.getString("Email"));
            nguoidung.setPassword(ketqua.getString("Password"));
            nguoidung.setSodienthoai(ketqua.getInt("Sodienthoai"));
            nguoidung.setGioitinh(ketqua.getInt("Gioitinh"));
            nguoidung.setQuyenhanh(ketqua.getInt("Phanquyen"));
            list.add(nguoidung);

        }
        return list;

    }

    public boolean Themnguoidung(Nguoidung nguoidung) throws SQLException {
        String sql = "insert into Thongtincanhan(Hoten,Diachi,Ngaysinh,Gioitinh,Coquancongtac,Email,Password,Sodienthoai,Phanquyen) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setString(1, nguoidung.getHoten());
        prepar.setString(2, nguoidung.getDiachi());
//        Date d = new Date();
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        prepar.setString(3, nguoidung.getNgaysinh());
        prepar.setInt(4, nguoidung.getGioitinh());
        prepar.setInt(5, nguoidung.getCoquan());
        prepar.setString(6, nguoidung.getEmail());
        prepar.setString(7, nguoidung.getPassword());
        prepar.setInt(8, nguoidung.getSodienthoai());
        prepar.setInt(9, nguoidung.getQuyenhanh());
        prepar.executeUpdate();

        this.ketqua = prepar.getGeneratedKeys();
        int key = 0;
        if (this.ketqua.next()) {
            key = this.ketqua.getInt(1);
            nguoidung.setIdcanhan(key);
            return true;
        }
        return false;
    }

    public void Themnhanviencongty(String hoten, String email, int macoquan) throws SQLException {
        String sql = "INSERT INTO `QuanLyVanThu`.`Thongtincanhan` (`Hoten`, `Coquancongtac`, `Email`, `Password`, `Phanquyen`) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setString(1, hoten);
        prepar.setInt(2, macoquan);
        prepar.setString(3, email);
        prepar.setString(4, MD5.encryption("123"));
        prepar.setInt(5, 4);
        prepar.executeUpdate();

    }

    public void Capnhatnguoidung(Nguoidung nguoidung) throws SQLException {
        String sql = "update Thongtincanhan set Hoten=?,Diachi=?,Ngaysinh=?,Email=?,Password=?,Sodienthoai=? where idThongtincanhan=?";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setString(1, nguoidung.getHoten());
        prepar.setString(2, nguoidung.getDiachi());
        prepar.setString(3, nguoidung.getNgaysinh());
       // prepar.setInt(4, nguoidung.getGioitinh());
        // prepar.setInt(5, nguoidung.getNghenghiep());
    //    prepar.setInt(6, nguoidung.getCoquan());
        prepar.setString(4, nguoidung.getEmail());
        prepar.setString(5, nguoidung.getPassword());
        prepar.setInt(6, nguoidung.getSodienthoai());
        prepar.setInt(7, nguoidung.getIdcanhan());
        prepar.executeUpdate();

    }

    public void Xoanguoidung(int Manguoidung) throws SQLException {
        String sql = "DELETE FROM Thongtincanhan WHERE idThongtincanhan=?;";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setInt(1, Manguoidung);
        prepar.executeUpdate();

    }

    public String Laytencongtynguoidangky(int macongty) throws SQLException {
        String sql = "SELECT Tencoquan FROM QuanLyVanThu.Thongtincanhan  join QuanLyVanThu.Phongbandangky on(Thongtincanhan.Coquancongtac=Phongbandangky.idcoquan) where idThongtincanhan=?";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setInt(1, macongty);
        this.ketqua = prepar.executeQuery();
        if (ketqua.next()) {
            return ketqua.getString("Tencoquan");
        }
        return null;
    }

    public int Laymacongtynguoidangky(String tencongty) throws SQLException {
        String sql = "SELECT idcoquan FROM  QuanLyVanThu.Phongbandangky  where Tencoquan=?";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setString(1, tencongty);
        this.ketqua = prepar.executeQuery();
        if (ketqua.next()) {
            return Integer.parseInt(ketqua.getString("idcoquan"));
        }
        return 0;
    }

    public String Laytenphanquyennguoidung(int maphanquyen) throws SQLException {
        String sql = "SELECT Tenloai FROM QuanLyVanThu.Thongtincanhan join Loainguoidung on(Thongtincanhan.Phanquyen=Loainguoidung.idLoainguoidung) where Phanquyen=?";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setInt(1, maphanquyen);
        this.ketqua = prepar.executeQuery();
        if (ketqua.next()) {
            return ketqua.getString("Tenloai");
        }
        return null;
    }
    
    public ArrayList<Nguoidung> Laydanhsachnhanvien() throws SQLException{
    String sql="SELECT * FROM QuanLyVanThu.Thongtincanhan where Phanquyen=4;";
    PreparedStatement preparedstatement = ketnoi.prepareStatement(sql);
        
       
        this.ketqua = preparedstatement.executeQuery();

        ArrayList<Nguoidung> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Nguoidung nguoidung = new Nguoidung();
            nguoidung.setIdcanhan(ketqua.getInt("idThongtincanhan"));
            nguoidung.setHoten(ketqua.getString("Hoten"));
            nguoidung.setDiachi(ketqua.getString("Diachi"));
            nguoidung.setCoquan(ketqua.getInt("Coquancongtac"));
            nguoidung.setNgaysinh(ketqua.getString("Ngaysinh"));
            nguoidung.setEmail(ketqua.getString("Email"));
            nguoidung.setPassword(ketqua.getString("Password"));
            nguoidung.setSodienthoai(ketqua.getInt("Sodienthoai"));
            nguoidung.setGioitinh(ketqua.getInt("Gioitinh"));
            nguoidung.setQuyenhanh(ketqua.getInt("Phanquyen"));
            list.add(nguoidung);

        }
        return list;
    
    
    }

    public static void main(String[] args) throws IOException, SQLException {

        Nguoidungquerry querry = new Nguoidungquerry();

//       Nguoidung danhsach = new Nguoidung();
//        danhsach = querry.Dangnhapnguoidung("nguyenntrungdoan79@gmail.com", "123");
//        
        //    System.out.println(querry.Laytencongtynguoidangky(1));
//         Nguoidung nguoidung = new Nguoidung();
//         nguoidung.setIdcanhan(72);
//         nguoidung.setDiachi("DongLang");
//         nguoidung.setHoten("Nhat Dang");
//         nguoidung.setNgaysinh("1996-02-21");
//         nguoidung.setPassword(MD5.encryption("123"));
//         nguoidung.setEmail("nhatdang@gmail.com");
       //  nguoidung.setSodienthoai(09283937);
       // nguoidung.setSodienthoai(0989876);
//        nguoidung.setIdcanhan(2);
 //       querry.Capnhatnguoidung(nguoidung);
        ArrayList<Nguoidung> list = new ArrayList<>();
        list = querry.Laydanhsachnhanvien();
        for (Nguoidung nhanvien : list) {
System.out.println(nhanvien.toString());
        }
   // querry.Themnhanviencongty("HaiHai", "haihai@gmail.com",2);
    }
}
