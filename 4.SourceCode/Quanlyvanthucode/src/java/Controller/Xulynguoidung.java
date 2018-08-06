/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Coquanquerry;
import Database_Helpers.Nguoidungquerry;
import Model.Coquannguoidangky;
import Model.Nguoidung;
import Tool.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguyendoan
 */
@WebServlet(name = "Nguoidung", urlPatterns = {"/Nguoidung"})
public class Xulynguoidung extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Nguoidung</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Nguoidung at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        HttpSession session = request.getSession();
        String url = "/Danhsachcongvanden";
        Coquanquerry coquan = new Coquanquerry();
        Nguoidung nguoidung = new Nguoidung();
        Nguoidungquerry nguoidungdungquerry = new Nguoidungquerry();
        switch (command) {
            case "Register":
                String name = request.getParameter("name");
                String mail = request.getParameter("email");
                String password = MD5.encryption(request.getParameter("password"));
                String ngaysinh = request.getParameter("dayofbirth");
                int sodienthoai = Integer.parseInt(request.getParameter("phonenumber"));
                String diachi = request.getParameter("adress");
                int goitinh = Integer.parseInt(request.getParameter("gender"));

                String Tencoquan = request.getParameter("namecompane");
                int Sodienthoai = Integer.parseInt(request.getParameter("fax"));
                String Diachicoquan = request.getParameter("addresscompane");

                //  Coquannguoidangky coquandangky=new Coquannguoidangky(Tencoquan, Diachicoquan, Sodienthoai);
                //  nguoidung = new Nguoidung(name, diachi, ngaysinh, goitinh, mail, password, sodienthoai);
                try {
                    if (nguoidungdungquerry.Themnguoidung(nguoidung)) {
                        coquan.Themcoquan(Tencoquan, Diachicoquan, Sodienthoai);
                        session.setAttribute("nguoidung", nguoidung);
                        url = "/Soanthaocongvanden";

                    } else {
                        url = "/Khungdangky";
                        request.setAttribute("Loi", "Registration failed!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Xulynguoidung.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "Login":
                String email = request.getParameter("mail");
                String matkhau = MD5.encryption(request.getParameter("password"));

                 {
                    try {
                        nguoidung = nguoidungdungquerry.Dangnhapnguoidung(email, matkhau);
                    } catch (SQLException ex) {
                        Logger.getLogger(Xulynguoidung.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (nguoidung == null) {
                    request.setAttribute("Loi", "Error your email or password!");
                    url = "/Khungdangnhap";

                } else {
                    session.setAttribute("nguoidung", nguoidung);
                    url = "/Danhsachcongvanden";
                }
                break;

        }
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        HttpSession session = request.getSession();
        String url = "";
        Coquanquerry coquan = new Coquanquerry();
        Nguoidung nguoidung = new Nguoidung();
        Nguoidungquerry nguoidungdungquerry = new Nguoidungquerry();
        int macoquan = 0;

        String email = request.getParameter("mail");
        String matkhau = MD5.encryption(request.getParameter("password"));

        {
            try {
                nguoidung = nguoidungdungquerry.Dangnhapnguoidung(email, matkhau);
            } catch (SQLException ex) {
                Logger.getLogger(Xulynguoidung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (nguoidung == null) {
            request.setAttribute("Loi", "Error your email or password!");
            url = "/Khungdangnhap";

        } else {
            session.setAttribute("nguoidung", nguoidung);
            url = "/Trangchu.jsp";
        }
        RequestDispatcher dis = request.getRequestDispatcher(url);

        dis.forward(request, response);
    }



/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
