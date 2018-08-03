/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Coquanquerry;
import Model.Coquanbanhanhcongvan;
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
@WebServlet(name = "Capnhatcoquanbanhanhcongvan", urlPatterns = {"/Capnhatcoquanbanhanhcongvan"})
public class Capnhatcoquanbanhanhcongvan extends HttpServlet {

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
            out.println("<title>Servlet Capnhatcoquanbanhanhcongvan</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Capnhatcoquanbanhanhcongvan at " + request.getContextPath() + "</h1>");
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
           int Idcoquan=( Integer.parseInt(request.getParameter("idcoquanbanhanh")));
        Coquanquerry coquan=new Coquanquerry();
        Coquanbanhanhcongvan coquanbanhanh;
        
        try {
            
            coquanbanhanh=coquan.Laydanhthongtincuamotcoquan(Idcoquan);
            request.setAttribute("Thongtincuacoquan", coquanbanhanh);
            
            ArrayList<Coquanbanhanhcongvan> danhsachcoquan = new ArrayList<>();
            danhsachcoquan = coquan.Laydanhsachcoquanbanhanh();
            request.setAttribute("Danhsachcoquan", danhsachcoquan);
        } catch (SQLException ex) {
            Logger.getLogger(Capnhatcoquanbanhanhcongvan.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        String url = "/ServletCoquanbanhanh";
        
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
        int Idcoquan=( Integer.parseInt(request.getParameter("idcoquanbanhanh")));
        Coquanquerry coquan=new Coquanquerry();
        Coquanbanhanhcongvan coquanbanhanh;
        
        try {
            
            coquanbanhanh=coquan.Laydanhthongtincuamotcoquan(Idcoquan);
            request.setAttribute("Thongtincuacoquan", coquanbanhanh);
            
        } catch (SQLException ex) {
            Logger.getLogger(Capnhatcoquanbanhanhcongvan.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        String url = "/Capnhatcoquanbanhanh";
        
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
