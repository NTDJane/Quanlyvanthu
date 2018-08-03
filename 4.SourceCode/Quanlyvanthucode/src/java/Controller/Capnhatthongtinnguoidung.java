/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Nguoidungquerry;
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
import javax.servlet.http.HttpSessionActivationListener;

/**
 *
 * @author nguyendoan
 */
@WebServlet(name = "Capnhatthongtinnguoidung", urlPatterns = {"/Capnhatthongtinnguoidung"})
public class Capnhatthongtinnguoidung extends HttpServlet {

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
            out.println("<title>Servlet Capnhatthongtinnguoidung</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Capnhatthongtinnguoidung at " + request.getContextPath() + "</h1>");
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
        String url = "/Capnhatthongtinnguoidung.jsp";

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
       HttpSession session = request.getSession(); ;
        Nguoidung nguoidung=(Nguoidung)session.getAttribute("nguoidung");

        
        String ten=request.getParameter("name");
        String email=request.getParameter("email");
        String matkhaumoi=MD5.encryption(request.getParameter("password"));
        String ngaysinh=request.getParameter("dayofbirth");
        int sodienthoai=Integer.parseInt(request.getParameter("phonenumber"));
        String diachi=request.getParameter("adress");
        
        Nguoidungquerry nguoidungquerry=new Nguoidungquerry();
        Nguoidung nguoidungmoi=new Nguoidung(nguoidung.getIdcanhan(), ten, diachi, ngaysinh,email, sodienthoai);
        
        try {
            nguoidungquerry.Capnhatnguoidung(nguoidungmoi);
        } catch (SQLException ex) {
            Logger.getLogger(Capnhatthongtinnguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
        
        String url = "/Capnhatthongtinnguoidung.jsp";

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
