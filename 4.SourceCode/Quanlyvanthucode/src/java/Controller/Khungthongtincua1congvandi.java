/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Congvanquerry;
import Model.Congvanden;
import Model.Congvandi;
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

/**
 *
 * @author nguyendoan
 */
@WebServlet(name = "Khungthongtincua1congvandi", urlPatterns = {"/Khungthongtincua1congvandi"})
public class Khungthongtincua1congvandi extends HttpServlet {

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
            out.println("<title>Servlet Khungthongtincua1congvandi</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Khungthongtincua1congvandi at " + request.getContextPath() + "</h1>");
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
        int idcongvan=Integer.parseInt(request.getParameter("idcongvan"));
        String sohieu=request.getParameter("sohieu");
       
        Congvanquerry congvanquerry=new Congvanquerry();
       // System.out.println(idcongvan+sohieu);
        try {
            Congvandi congvan=congvanquerry.Laythongtincongvanditheoidvasohieu(idcongvan, sohieu);
            request.setAttribute("Thongtincua1congvan", congvan);
        } catch (SQLException ex) {
            Logger.getLogger(Khungthongtincua1congvan.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url="/Singledispatchto.jsp";
        RequestDispatcher dispatch=request.getRequestDispatcher(url);
        dispatch.forward(request, response);
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
