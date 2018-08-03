/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Nguoidungquerry;
import Model.Nguoidung;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ServerletThemnhanvien", urlPatterns = {"/ServerletThemnhanvien"})
public class ServerletThemnhanvien extends HttpServlet {

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
            out.println("<title>Servlet ServerletThemnhanvien</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServerletThemnhanvien at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Nguoidungquerry nguoidungquerry = new Nguoidungquerry();
        Nguoidung nguoidung = (Nguoidung) session.getAttribute("nguoidung");
        ArrayList<Nguoidung> danhsachnhanvien = new ArrayList<>();
        try {

            danhsachnhanvien = nguoidungquerry.Danhsachnguoidungcuacongty(nguoidung.getCoquan(), nguoidung.getQuyenhanh());
            request.setAttribute("Danhsachnhanvien", danhsachnhanvien);
        } catch (SQLException ex) {
            Logger.getLogger(Soanthaocongvanden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url = "/Themnhanvien.jsp";

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
        HttpSession session = request.getSession();
        Nguoidungquerry nguoidungquerry = new Nguoidungquerry();
        Nguoidung nguoidung = (Nguoidung) session.getAttribute("nguoidung");
        ArrayList<Nguoidung> danhsachnhanvien = new ArrayList<>();
        try {

            danhsachnhanvien = nguoidungquerry.Danhsachnguoidungcuacongty(nguoidung.getCoquan(), nguoidung.getQuyenhanh());
            request.setAttribute("Danhsachnhanvien", danhsachnhanvien);
        } catch (SQLException ex) {
            Logger.getLogger(Soanthaocongvanden.class.getName()).log(Level.SEVERE, null, ex);
        }

        String url = "/Themnhanvien.jsp";

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
