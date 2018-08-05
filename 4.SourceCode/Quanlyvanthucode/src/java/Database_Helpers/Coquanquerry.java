/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Helpers;

import Model.Congvanden;
import Model.Coquanbanhanhcongvan;
import Model.Coquannguoidangky;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyendoan
 */
public class Coquanquerry {

    private Connection ketnoi;
    private ResultSet ketqua;
    //  Congvan congvan = new Congvan();

    public Coquanquerry() throws IOException {
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

    public ArrayList<Coquanbanhanhcongvan> Laydanhsachcoquanbanhanh() throws SQLException {
        String sql = "select * from QuanLyVanThu.Coquanbanhanhcongvan";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        this.ketqua = ps.executeQuery();

        ArrayList<Coquanbanhanhcongvan> list = new ArrayList<>();
        while (this.ketqua.next()) {
            Coquanbanhanhcongvan coquan = new Coquanbanhanhcongvan();

            coquan.setIdcoquan(ketqua.getInt("IdCoquanbanhanh"));
            coquan.setTencoquan(ketqua.getString("TenCoQuan"));
            coquan.setDiachi(ketqua.getString("Diachi"));
            coquan.setSodienthoai(ketqua.getInt("Sodienthoai"));
            list.add(coquan);

        }
        return list;
    }

    public ArrayList<Coquanbanhanhcongvan> Laydanhsachcoquannguoidungdangky() throws SQLException {
        String sql = "select * from QuanLyVanThu.Phongbandangky";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        this.ketqua = ps.executeQuery();

        ArrayList<Coquanbanhanhcongvan> list = new ArrayList<>();
        while (this.ketqua.next()) {
            Coquanbanhanhcongvan coquan = new Coquanbanhanhcongvan();

            coquan.setIdcoquan(ketqua.getInt("Idcoquan"));
            coquan.setTencoquan(ketqua.getString("Tencoquan"));
            coquan.setDiachi(ketqua.getString("Diachicoquan"));
            coquan.setSodienthoai(ketqua.getInt("Sodienthoai"));
            list.add(coquan);

        }
        return list;
    }

    public void Capnhatthongtincoquanbanhanhcongvan(Coquanbanhanhcongvan coquan) throws SQLException {
        String sql = "UPDATE `QuanLyVanThu`.`Coquanbanhanhcongvan` SET `TenCoQuan`=?, `DiaChi`=?, `Sodienthoai`=?   WHERE `idCoquanbanhanh`=?";
        PreparedStatement ps = ketnoi.prepareStatement(sql);
        ps.setString(1, coquan.getTencoquan());
        ps.setInt(4, coquan.getIdcoquan());
        ps.setString(2, coquan.getDiachi());
        ps.setInt(3, coquan.getSoDienthoai());
        ps.executeUpdate();

    }

    public Coquanbanhanhcongvan Laydanhthongtincuamotcoquan(int macoquanbanhanh) throws SQLException {
        String sql = "SELECT * FROM QuanLyVanThu.Coquanbanhanhcongvan where idCoquanbanhanh=?";

        PreparedStatement ps = ketnoi.prepareStatement(sql);
        ps.setInt(1, macoquanbanhanh);

        this.ketqua = ps.executeQuery();

        ArrayList<Coquanbanhanhcongvan> list = new ArrayList<>();
        if (this.ketqua.next()) {
            Coquanbanhanhcongvan coquan = new Coquanbanhanhcongvan();

            coquan.setIdcoquan(ketqua.getInt("Idcoquanbanhanh"));
            coquan.setTencoquan(ketqua.getString("Tencoquan"));
            coquan.setDiachi(ketqua.getString("Diachi"));
            coquan.setSodienthoai(ketqua.getInt("Sodienthoai"));
            return coquan;

        }
        return null;
    }

    public void Themcoquanbanhanh(Coquanbanhanhcongvan coquan) throws SQLException {
        String sql = "INSERT INTO `QuanLyVanThu`.`Coquanbanhanhcongvan` (`TenCoQuan`, `DiaChi`, `Sodienthoai`) VALUES (?, ?, ?);";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setString(1, coquan.getTencoquan());
        ps.setString(2, coquan.getDiachi());
        ps.setInt(3, coquan.getSoDienthoai());
        ps.executeUpdate();
    }

    public Coquannguoidangky Laythongtincoquannguoidangky(int macoquan) throws SQLException {

        String sql = "SELECT * FROM QuanLyVanThu.Phongbandangky where idcoquan=?";

        PreparedStatement ps = ketnoi.prepareStatement(sql);
        ps.setInt(1, macoquan);

        this.ketqua = ps.executeQuery();

        ArrayList<Coquanbanhanhcongvan> list = new ArrayList<>();
        if (this.ketqua.next()) {
            Coquannguoidangky coquan = new Coquannguoidangky();

            coquan.setIdCoquan(ketqua.getInt("idcoquan"));
            coquan.setTencoquan(ketqua.getString("Tencoquan"));
            coquan.setDiachi(ketqua.getString("Diachicoquan"));
            coquan.setSodienthoai(ketqua.getInt("Sodienthoai"));
            return coquan;
        }
        return null;

    }

    public void Themcoquan(String Tencoquan, String diachi, int sodienthoai) throws SQLException {
        String sql = "INSERT INTO `QuanLyVanThu`.`Phongbandangky` (`Tencoquan`, `Diachicoquan`, `Sodienthoai`) VALUES (?, ?, ?);";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setString(1, Tencoquan);
        ps.setString(2, diachi);
        ps.setInt(3, sodienthoai);
        ps.executeUpdate();

    }

    public String Laytencoquannguoidunghientai(int macoquanhientai) throws SQLException {
        String sql = "SELECT Tencoquan FROM QuanLyVanThu.Phongbandangky where idcoquan=?";
        PreparedStatement ps = ketnoi.prepareStatement(sql);
        ps.setInt(1,macoquanhientai);
        this.ketqua=ps.executeQuery();
        if(ketqua.next()){
        return this.ketqua.getString("Tencoquan");
        }
       
        return null;

    }
    
    

    public static void main(String[] args) throws IOException, SQLException {

        Coquanquerry querry = new Coquanquerry();

//        ArrayList<Coquanbanhanhcongvan> danhsach = new ArrayList<>();
//        danhsach = querry.Laydanhsachcoquanbanhanh();
//        for (Coquanbanhanhcongvan coquan : danhsach) {
//            System.out.println(coquan.toString());
//        }
 //       querry.Themcoquan("Saigon", "Binh Thanh", 12345678);
          System.out.print(querry.Laytencoquannguoidunghientai(1));
    }

}
