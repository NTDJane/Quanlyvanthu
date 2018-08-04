/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Helpers;

import Model.Congvanden;
import Model.Congvandi;
import Model.Nguoidung;
import Model.Tinhtrangxuly;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class Congvanquerry {

    private Connection ketnoi;
    private ResultSet ketqua;
    //  Congvan congvan = new Congvan();

    public Congvanquerry() throws IOException {
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

    public ArrayList<Congvanden> Laytatcadanhsachcongvan() throws SQLException {
        String sql = "select * from QuanLyVanThu.Congvanden";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        this.ketqua = ps.executeQuery();

        ArrayList<Congvanden> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));

            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            // congvan.setNoigoi(this.ketqua.getInt("Noigoi"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));

            list.add(congvan);
        }
        return list;
    }

    public ArrayList<Congvanden> Laytatcadanhsachcongvanphantrang(int begin, int end) throws SQLException {
        String sql = "select * from QuanLyVanThu.Congvanden limit ?,?";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setInt(1, begin);
        ps.setInt(2, end);

        this.ketqua = ps.executeQuery();

        ArrayList<Congvanden> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));

            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            // congvan.setNoigoi(this.ketqua.getInt("Noigoi"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));

            list.add(congvan);
        }
        return list;
    }

    public ArrayList<Congvanden> Laytatcadanhsachcongvantimkiemcophantrang(String tukhoa, int coquanbanhanh, int Tinhtranghieuluc, String ngaybatdau, String ngayketthuc, int begin, int end) throws SQLException {
        String sql = "SELECT * FROM QuanLyVanThu.Congvanden where Trichdan like '%" + tukhoa + "%' and Coquansoanthaobanhanh like '%" + coquanbanhanh + "%' or Tinhtranghieuluc like '%" + Tinhtranghieuluc + "%' and Ngaybanhanh between '" + ngaybatdau + "' and '" + ngayketthuc + "'  limit ?,? ";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setInt(1, begin);
        ps.setInt(2, end);

        this.ketqua = ps.executeQuery();

        ArrayList<Congvanden> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));

            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            // congvan.setNoigoi(this.ketqua.getInt("Noigoi"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));

            list.add(congvan);
        }
        return list;
    }

    public ArrayList<Congvanden> Laytatcadanhsachcongvanchuaxulycophantrang(int begin, int end) throws SQLException {
        String sql = "SELECT * FROM QuanLyVanThu.Congvanden where Tinhtranghieuluc=6 or Tinhtranghieuluc=4 limit ?,? ";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setInt(1, begin);
        ps.setInt(2, end);

        this.ketqua = ps.executeQuery();

        ArrayList<Congvanden> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));

            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            // congvan.setNoigoi(this.ketqua.getInt("Noigoi"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));

            list.add(congvan);
        }
        return list;
    }

    public void Capnhattrangthaixulycongvan(int trangthai, int macongvan) throws SQLException {
        String sql = "UPDATE `QuanLyVanThu`.`Congvanden` SET `Tinhtranghieuluc`=? WHERE `idThuoctinhcongvan`=?";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setInt(1, trangthai);
        ps.setInt(2, macongvan);

        ps.executeUpdate();

    }

    public void Phancongnguoixulycongvan(int manguoiduocphancong, int macongvan, String thoihanxuly) throws SQLException {
        String sql = "UPDATE `QuanLyVanThu`.`Congvanden` SET  Nguoixuly= ?,  Tinhtranghieuluc='3', Thoigianxulycongvan=? WHERE `idThuoctinhcongvan`=?";

        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setInt(1, manguoiduocphancong);
        ps.setInt(3, macongvan);
        ps.setString(2, thoihanxuly);

        ps.executeUpdate();
    }

    public ArrayList<Congvanden> Danhsachcongvanduocdoctheonguoixulyvaphanquyen(int begin, int limit, int manguoixuly, int phanquyen) throws SQLException {
        String sql = "SELECT * FROM QuanLyVanThu.Congvanden where    " + phanquyen + "<=3 OR Nguoixuly=? LIMIT " + begin + " ," + limit + "";
        PreparedStatement ps = ketnoi.prepareStatement(sql);

        ps.setInt(1, manguoixuly);

        this.ketqua = ps.executeQuery();

        ArrayList<Congvanden> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));

            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            // congvan.setNoigoi(this.ketqua.getInt("Noigoi"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));

            list.add(congvan);
        }
        return list;
    }

    public ArrayList<Tinhtrangxuly> Laytrangthaicongvan() throws SQLException {
        String sql = "SELECT * FROM QuanLyVanThu.Trangthaixuly ;";
        PreparedStatement prepar = ketnoi.prepareCall(sql);

        this.ketqua = prepar.executeQuery();
        ArrayList<Tinhtrangxuly> list = new ArrayList<>();
        while (this.ketqua.next()) {
            Tinhtrangxuly tinhtrang = new Tinhtrangxuly(this.ketqua.getInt("idTrangthaixuly"), this.ketqua.getString("Tentrangthai"));
            list.add(tinhtrang);

        }
        return list;

    }

    public ArrayList<Congvanden> Laydanhsachcongvanchonguoixuly(int manguoixuly, int begin, int limit) throws SQLException {
        String sql = "select * from QuanLyVanThu.Congvanden where Nguoixuly=?  and Tinhtranghieuluc=3 LIMIT " + begin + " ," + limit + "";
        PreparedStatement ps = ketnoi.prepareStatement(sql);
        ps.setInt(1, manguoixuly);
        this.ketqua = ps.executeQuery();

        ArrayList<Congvanden> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));

            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            // congvan.setNoigoi(this.ketqua.getInt("Noigoi"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));

            list.add(congvan);
        }
        return list;
    }

    public Congvanden Laycongvantheoidvasohieu(int macongvan, String sohieucongvan) throws SQLException {
        String sql = "select * from QuanLyVanThu.Congvanden where idThuoctinhcongvan=? and Sohieu=?";
        PreparedStatement ps = ketnoi.prepareStatement(sql);
        ps.setInt(1, macongvan);
        ps.setString(2, sohieucongvan);
        this.ketqua = ps.executeQuery();

        // ArrayList<Congvan> list = new ArrayList<>();
        if (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan").replace("\n", "<br>"));
            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            // congvan.setNoigoi(this.ketqua.getInt("Noigoiden"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));

            return congvan;
        }

        return null;

    }

    public void Themcongvan(Congvanden congvan) throws SQLException {
        String sql = "insert into Congvanden(Sohieu,Coquansoanthaobanhanh,Trichdan,Ngaybanhanh,Nguoiky,Tinhtranghieuluc,Duongtai,Thoigiancongvanden)  values(?,?,?,?,?,?,?,?)";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setString(1, congvan.getSohieu());
        prepar.setInt(2, congvan.getNoibanhanh());
        prepar.setString(3, congvan.getTrichdan());
        prepar.setString(4, congvan.getNgaybanhanh());
        prepar.setString(5, congvan.getNguoiky());
        prepar.setString(7, congvan.getDuongtai());
        prepar.setString(8, congvan.getThoigiancongvanden());
        prepar.setInt(6, congvan.getTinhtranghieuluc());
        prepar.executeUpdate();

    }

    /*Nho chinh sua lai noi luu file cua cong van*/
    public void Taobancopytufilecu(InputStream inputstreamfile, String Tenfile) {
        //InputStream inputstream = null;
        OutputStream outputstream = null;
        try {
            //  File filegoc=new File(duongdanfilecu);
            // File filemoi=new File("/home/nguyendoan/NetBeansProjects/ProjectVideo/Quanlyvanthu/web/File/"+Tenfile+".pdf");
            outputstream = new FileOutputStream(new File("/home/nguyendoan/Baocaothuctap/Quan_Ly_Van_Thu/Quanlyvanthu/4.SourceCode/Quanlyvanthucode/web/File/" + Tenfile));
            // inputstream=new FileInputStream(filegoc);
            // outputstream=new FileOutputStream(filemoi);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputstreamfile.read(buffer)) > 0) {
                outputstream.write(buffer, 0, length);

            }

            inputstreamfile.close();
            outputstream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Kiemtracongvanhethan(int idcongvan, String thoigianhientai) throws SQLException {
        String sql = "update Congvanden set Tinhtranghieuluc=4 where idThuoctinhcongvan=?  and Tinhtranghieuluc=3 and ?>Thoigianxulycongvan ;";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setInt(1, idcongvan);
        prepar.setString(2, thoigianhientai);
        prepar.executeUpdate();

    }

    /* Ket thuc querry  cho phan cong van den*/
 /* Bat dau cho phan cong van di */
    public ArrayList<Congvandi> Laydanhsachcongvandiphantrang(int begin, int limit) throws SQLException {
        String sql = "select * from Congvandi limit ?,?";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setInt(1, begin);
        prepar.setInt(2, limit);

        this.ketqua = prepar.executeQuery();
        ArrayList<Congvandi> list = new ArrayList<>();
        while (this.ketqua.next()) {
            Congvandi congvan = new Congvandi();
            congvan.setIdcongvan(this.ketqua.getInt("idCongvandi"));
            congvan.setSohieuvanbandi(this.ketqua.getString("Sohieuvanbandi"));
            congvan.setDonvibanhanh(this.ketqua.getInt("Donvibanhanh"));
            congvan.setDuongdan(this.ketqua.getString("Duongdanvanban"));
            congvan.setNgaycongvandi(this.ketqua.getString("Ngaycongvandi"));
            congvan.setNgayphathanh(this.ketqua.getString("Ngayphathanh"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));
            congvan.setNoinhan(this.ketqua.getString("Noinhan"));

            list.add(congvan);
        }
        return list;
    }

    public ArrayList<Congvandi> Laydanhsachcongvandi() throws SQLException {
        String sql = "select * from Congvandi ";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);

        this.ketqua = prepar.executeQuery();
        ArrayList<Congvandi> list = new ArrayList<>();
        while (this.ketqua.next()) {
            Congvandi congvan = new Congvandi();
            congvan.setIdcongvan(this.ketqua.getInt("idCongvandi"));
            congvan.setSohieuvanbandi(this.ketqua.getString("Sohieuvanbandi"));
            congvan.setDonvibanhanh(this.ketqua.getInt("Donvibanhanh"));
            congvan.setDuongdan(this.ketqua.getString("Duongdanvanban"));
            congvan.setNgaycongvandi(this.ketqua.getString("Ngaycongvandi"));
            congvan.setNgayphathanh(this.ketqua.getString("Ngayphathanh"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));
            congvan.setNoinhan(this.ketqua.getString("Noinhan"));

            list.add(congvan);
        }
        return list;
    }

    public Congvandi Laythongtincongvanditheoidvasohieu(int idcongvan, String sohieu) throws SQLException {
        String sql = "select * from Congvandi where idCongvandi=? and Sohieuvanbandi=?";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setInt(1, idcongvan);
        prepar.setString(2, sohieu);

        this.ketqua = prepar.executeQuery();
        ArrayList<Congvandi> list = new ArrayList<>();
        if (this.ketqua.next()) {
            Congvandi congvan = new Congvandi();
            congvan.setIdcongvan(this.ketqua.getInt("idCongvandi"));
            congvan.setSohieuvanbandi(this.ketqua.getString("Sohieuvanbandi"));
            congvan.setDonvibanhanh(this.ketqua.getInt("Donvibanhanh"));
            congvan.setDuongdan(this.ketqua.getString("Duongdanvanban"));
            congvan.setNgaycongvandi(this.ketqua.getString("Ngaycongvandi"));
            congvan.setNgayphathanh(this.ketqua.getString("Ngayphathanh"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));
            congvan.setNoinhan(this.ketqua.getString("Noinhan"));
            return congvan;
        }
        return null;
    }

    public void Themcongvandi(Congvandi congvandi) throws SQLException {

        String sql = "INSERT INTO `QuanLyVanThu`.`Congvandi` (`Sohieuvanbandi`, `Ngayphathanh`, `Donvibanhanh`, `Nguoiky`, `Trichdan`, `Ngaycongvandi`, `Noinhan`, `Duongdanvanban`) VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setString(1, congvandi.getSohieuvanbandi());
        prepar.setString(2, congvandi.getNgayphathanh());
        prepar.setInt(3, congvandi.getDonvibanhanh());
        prepar.setString(4, congvandi.getNguoiky());
        prepar.setString(5, congvandi.getTrichdan());
        prepar.setString(6, congvandi.getNgaycongvandi());
        prepar.setString(7, congvandi.getNoinhan());
        prepar.setString(8, congvandi.getDuongdan());

        prepar.executeUpdate();

    }

    public String Laytentrangthaitheomacongvan(int macongvan) throws SQLException {
        String sql = "SELECT Tentrangthai FROM QuanLyVanThu.Congvanden join Trangthaixuly on(Congvanden.Tinhtranghieuluc=Trangthaixuly.idTrangthaixuly)  where idThuoctinhcongvan=?";
        PreparedStatement prepar = ketnoi.prepareStatement(sql);
        prepar.setInt(1,macongvan);
        this.ketqua = prepar.executeQuery();
        if (this.ketqua.next()) {
            return this.ketqua.getString("Tentrangthai");
        }
        return null;
    }

    public ArrayList<Congvanden> Laydanhsachcongvanphancongchonhanvientrongkhoangthoigian(int manhanvien, String thoigiandau, String thoigiansau) throws SQLException {
        String sql = "select * from QuanLyVanThu.Congvanden where Nguoixuly=? and Thoigianxulycongvan  between ? and ?";
        PreparedStatement ps = ketnoi.prepareStatement(sql);
        ps.setInt(1, manhanvien);
        ps.setString(2, thoigiandau);
        ps.setString(3, thoigiansau);
        this.ketqua = ps.executeQuery();

        ArrayList<Congvanden> list = new ArrayList<>();

        while (this.ketqua.next()) {
            Congvanden congvan = new Congvanden();
            congvan.setSothutu(this.ketqua.getInt("idThuoctinhcongvan"));
            congvan.setSohieu(this.ketqua.getString("Sohieu"));
            congvan.setNoibanhanh(this.ketqua.getInt("Coquansoanthaobanhanh"));
            congvan.setDuongtai(this.ketqua.getString("Duongtai"));
            congvan.setTrichdan(this.ketqua.getString("Trichdan"));

            congvan.setNgayapdung(this.ketqua.getString("Ngayapdung"));
            congvan.setNgaybanhanh(this.ketqua.getString("Ngaybanhanh"));
            congvan.setNgayhethieuluc(this.ketqua.getString("Ngayhethieuluc"));
            congvan.setNguoiky(this.ketqua.getString("Nguoiky"));
            congvan.setNguoixuly(this.ketqua.getInt("Nguoixuly"));
            congvan.setTinhtranghieuluc(this.ketqua.getInt("Tinhtranghieuluc"));
            congvan.setThoigianxuly(this.ketqua.getString("Thoigianxulycongvan"));

            list.add(congvan);
        }
        return list;
    }

    public static void main(String[] args) throws IOException, SQLException {

        Congvanquerry querry = new Congvanquerry();
        Nguoidungquerry nguoidung=new Nguoidungquerry();
        //Congvan congvan=new Congvan();
        //  querry.Phancongnguoixulycongvan(3, 10, "2018-07-31");
        //  System.out.println(querry.Laycongvantheoidvasohieu(28, "27/2015/N&#272;-CP").toString());
//        ArrayList<Congvanden> danhsach = new ArrayList<>();
//        danhsach = querry.Laydanhsachcongvanphancongchonhanvientrongkhoangthoigian(8, "2018-08-01", "2018-08-02");
//        for (Congvanden congvan : danhsach) {
//            System.out.println(congvan.toString());
//        }
        //      querry.Taobancopytufilecu("/home/nguyendoan/Documents/1.pdf", "Filecopy");
        // Congvan(String Sohieu, int Noibanhanh, String Trichdan, String Ngaybanhanh, String Nguoiky, String Duongtai, String Noigoi, String Thoigiancongvanden) {
//  Congvandi congvan=new Congvandi("17/2016 / TTLT-BGDDT-BTTTT","2018-08-07","Nguyen Trung Doan",1,"JOINT CIRCULAR \n" +
//"Regulation organize examinations and \n" +
//"certification of information technology applications\n" +
//"\n" +
//"Pursuant to the Education Law dated 14 June 2005; Law amending and supplementing a number of articles of the Education Law dated November 25, 2009;\n" +
//"\n" +
//"Pursuant to the Law on Information Technology dated 29 June 2006;\n" +
//"\n" +
//"Pursuant to the Government's Decree No. 75/2006 / ND-CP of August 2, 2006, detailing and guiding the implementation of a number of articles of the Education Law; Decree No. 31/2011 / ND-CP dated May 11, 2011 of the Government amending and supplementing a number of articles of the Government's Decree No. 75/2006 / ND-CP of August 2, 2006 detailing and guiding the implementation of a number of articles of the Education Law; Decree No. 07/2013 / ND-CP dated 9 January 2013 of the Government amending Point b, Clause 13, Article 1 of the Government's Decree No. 31/2011 / ND-CP dated 11 May 2011 amending and supplementing a number of articles of the Government's Decree No. 75/2006 / ND-CP of August 2, 2006, detailing and guiding the implementation of a number of articles of the Education Law;\n" +
//"\n" +
//"Pursuant to the Government's Decree No. 32/2008 / ND-CP of March 19, 2008, defining the functions, tasks, powers and organizational structure of the Ministry of Education and Training;\n" +
//"\n" +
//"Pursuant to the Government's Decree No. 132/2013 / ND-CP of October 16, 2013, defining the functions, tasks, powers and organizational structure of the Ministry of Information and Communications;\n" +
//"\n" +
//"Secretary Ministry of Education and Training and the Minister of Information and Communication issued a joint circular specified operating organization and the certification exam to use information technology.","2018-09-10","FPT Telecom","/home/nguyendoan/NetBeansProjects/ProjectVideo/Quanlyvanthu/web/File/ 1.pdf");
//    querry.Themcongvandi(congvan);
//
        String ngaydau ="2018-07-31";
        String ngaysau = "2018-08-04";
        ArrayList<Nguoidung> danhsachnhanvien =nguoidung.Laydanhsachnhanvien();
       // ArrayList<Tinhtrangxuly> danhsachtrangthai = new ArrayList<>();
        Congvanquerry congvan = new Congvanquerry();
        String trichdan = "";
        String trangthai = "";
        ArrayList<Congvanden> danhsach = new ArrayList<Congvanden>();
        
        for (Nguoidung nhanvien : danhsachnhanvien) {
            System.out.println(nhanvien.getHoten());
            danhsach = congvan.Laydanhsachcongvanphancongchonhanvientrongkhoangthoigian(nhanvien.getIdcanhan(), ngaydau, ngaysau);
            for (Congvanden congvanden : danhsach) {
                trangthai = congvan.Laytentrangthaitheomacongvan(congvanden.getSothutu());
                System.out.println(congvanden.getSohieu()+"Trangthai:"+trangthai);
            }
            
        }
    }

    }
