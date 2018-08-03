/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Congvanquerry;
import Database_Helpers.Nguoidungquerry;
import Model.Nguoidung;
import Model.Tinhtrangxuly;
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

/**
 *
 * @author nguyendoan
 */
@WebServlet(name = "Danhsachphancong", urlPatterns = {"/Danhsachphancong"})
public class Danhsachphancong extends HttpServlet {

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
            out.println("<title>Servlet Danhsachphancong</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Danhsachphancong at " + request.getContextPath() + "</h1>");
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
        String ngaydau = request.getParameter("From");
        String ngaysau = request.getParameter("To");
        Nguoidung nguoidung = new Nguoidung();
        ArrayList<Nguoidung> danhsachnhanvien = new ArrayList<>();
        ArrayList<Tinhtrangxuly> danhsachtrangthai = new ArrayList<>();
        Nguoidungquerry nguoidungquerry = new Nguoidungquerry();
        Congvanquerry congvanquerry = new Congvanquerry();
        try {
            danhsachnhanvien = nguoidungquerry.Laydanhsachnhanvien();
            danhsachtrangthai = congvanquerry.Laytrangthaicongvan();

        } catch (SQLException ex) {
            Logger.getLogger(Danhsachphancong.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("Danhsachtrangthai", danhsachtrangthai);
        request.setAttribute("Danhsachnhanvien", danhsachnhanvien);
        request.setAttribute("From", ngaydau);
        request.setAttribute("To", ngaysau);

        String url = "/Ketquathongke.jsp";
        RequestDispatcher Request=request.getRequestDispatcher(url);
        Request.forward(request, response);

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
        processRequest(request, response);
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