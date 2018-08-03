/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Congvanquerry;
import Model.Congvanden;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author nguyendoan
 */
@WebServlet(name = "Themvaocosodulieu", urlPatterns = {"/Themvaocosodulieu"})
@MultipartConfig(maxFileSize = 16177215)
public class Themvaocosodulieucongvanden extends HttpServlet {

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
        String sohieucongvan = request.getParameter("sohieu");
        String ngaybanhanh = request.getParameter("Daypublic");
        String nguoiky = request.getParameter("husmansign");
        String thoidiemnhan = request.getParameter("timerecive");
        String noigoiden = request.getParameter("placesent");
        String trichdan = request.getParameter("Subcontent");
        int coquanbanhanh = Integer.parseInt(request.getParameter("whereissued"));
        Congvanquerry congvanquerry = new Congvanquerry();
        InputStream inputstream = null;
        javax.servlet.http.Part filePart = request.getPart("Link");
        String tenfile = filePart.getName();
        if (filePart != null) {
            // prints out some information for debugging

            // obtains input stream of the upload file
            inputstream = filePart.getInputStream();

            congvanquerry.Taobancopytufilecu(inputstream, sohieucongvan);
        }
//        Congvanden congvan = new Congvanden(sohieucongvan, coquanbanhanh, trichdan, ngaybanhanh, nguoiky, "File/" + tenfile, noigoiden, thoidiemnhan);
        String url = "/Soanthaocongvanden";
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
        String sohieucongvan = request.getParameter("sohieu");
        String ngaybanhanh = request.getParameter("Daypublic");
        String nguoiky = request.getParameter("husmansign");
        String thoidiemnhan = request.getParameter("timerecive");
        String trichdan = request.getParameter("Subcontent");
        int coquanbanhanh = Integer.parseInt(request.getParameter("whereissued"));
        Congvanquerry congvanquerry = new Congvanquerry();
        InputStream inputstream = null;
        javax.servlet.http.Part filePart = request.getPart("Link");
        String tenfile = (String) Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        if (filePart != null) {
            // prints out some information for debugging

            // obtains input stream of the upload file
            inputstream = filePart.getInputStream();

            congvanquerry.Taobancopytufilecu(inputstream, tenfile);
        }
        Congvanden congvan=new Congvanden(sohieucongvan, coquanbanhanh, trichdan, ngaybanhanh, nguoiky, "File/" + tenfile,  thoidiemnhan);
        congvan.setTinhtranghieuluc(6);
        try {
            congvanquerry.Themcongvan(congvan);
        } catch (SQLException ex) {
            Logger.getLogger(Themvaocosodulieucongvanden.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "/Soanthaocongvanden";
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
