/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database_Helpers.Congvanquerry;
import Database_Helpers.Coquanquerry;
import Model.Congvanden;
import Model.Coquanbanhanhcongvan;
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
@WebServlet(name = "Timkiemcongvanden", urlPatterns = {"/Timkiemcongvanden"})
public class Timkiemcongvanden extends HttpServlet {

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
            out.println("<title>Servlet Timkiemcongvanden</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Timkiemcongvanden at " + request.getContextPath() + "</h1>");
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
       String tukhoa=request.getParameter("keyword");
       String ngaybatdau=request.getParameter("From");
       String ngayketthuc=request.getParameter("To");
       int trangthai=Integer.parseInt(request.getParameter("status"));
       int coquan=Integer.parseInt(request.getParameter("agency"));
       Congvanquerry congvanquerry=new Congvanquerry();
        ArrayList<Congvanden> danhsachcongvan=new ArrayList<>();
         ArrayList<Coquanbanhanhcongvan> danhsachcoquan = new ArrayList<>();
       // ArrayList<Congvan> danhsachcongvanphantrang=new ArrayList<>();
        int pages=1;
        int count=0;
        int begin=0;
        int limit=0;
         if(request.getParameter("pages")!=null)
            {
                pages = Integer.parseInt(request.getParameter("pages"));
            }
            else
         {
                pages = 1;
         }
        try {
          danhsachcongvan=congvanquerry.Laytatcadanhsachcongvantimkiemcophantrang(tukhoa, coquan, trangthai, ngaybatdau, ngayketthuc, 1,6);;
            count=danhsachcongvan.size();
            if(count<=6){
                begin=1;
                limit=count;
                
            }else{
                
                begin=(pages-1)*6;
                limit=6;
            }
            danhsachcongvan=congvanquerry.Laytatcadanhsachcongvantimkiemcophantrang(tukhoa, coquan, trangthai, ngaybatdau, ngayketthuc, begin,limit);
            
           
            
          //  request.setAttribute("Tongsoluongcongvan", "List of dispatchs:  "+count);
         //   request.setAttribute("view", view);
        //    request.setAttribute("Danhsachcongvan",Danhsachcongvan);
            request.setAttribute("count", count);
           Coquanquerry coquanquerry=new Coquanquerry();
          danhsachcoquan = coquanquerry.Laydanhsachcoquanbanhanh();
            ArrayList<Tinhtrangxuly> danhsachtrangthai = congvanquerry.Laytrangthaicongvan();
            request.setAttribute("Danhsachcoquan", danhsachcoquan);

            //  request.setAttribute("Tongsoluongcongvan", "List of dispatchs:  "+count);
            //   request.setAttribute("view", view);
               request.setAttribute("Danhsachtrangthai",danhsachtrangthai);
            
            request.setAttribute("Danhsachtatcacongvan", danhsachcongvan);
        } catch (SQLException ex) {
            Logger.getLogger(Danhsachcongvanden.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url="/Trangtimkiem.jsp";
        RequestDispatcher dis=request.getRequestDispatcher(url);
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
        String tukhoa=request.getParameter("keyword");
       String ngaybatdau=request.getParameter("From");
       String ngayketthuc=request.getParameter("To");
       int trangthai=Integer.parseInt(request.getParameter("status"));
       int coquan=Integer.parseInt(request.getParameter("agency"));
       Congvanquerry congvanquerry=new Congvanquerry();
        ArrayList<Congvanden> danhsachcongvan=new ArrayList<>();
         ArrayList<Coquanbanhanhcongvan> danhsachcoquan = new ArrayList<>();
       // ArrayList<Congvan> danhsachcongvanphantrang=new ArrayList<>();
        int pages=1;
        int count=0;
        int begin=0;
        int limit=0;
         if(request.getParameter("pages")!=null)
            {
                pages = Integer.parseInt(request.getParameter("pages"));
            }
            else
         {
                pages = 1;
         }
        try {
          danhsachcongvan=congvanquerry.Laytatcadanhsachcongvantimkiemcophantrang(tukhoa, coquan, trangthai, ngaybatdau, ngayketthuc, 1,6);;
            count=danhsachcongvan.size();
            if(count<=6){
                begin=1;
                limit=count;
                
            }else{
                
                begin=(pages-1)*6;
                limit=6;
            }
            danhsachcongvan=congvanquerry.Laytatcadanhsachcongvantimkiemcophantrang(tukhoa, coquan, trangthai, ngaybatdau, ngayketthuc, begin,limit);
            
           
            
          //  request.setAttribute("Tongsoluongcongvan", "List of dispatchs:  "+count);
         //   request.setAttribute("view", view);
        //    request.setAttribute("Danhsachcongvan",Danhsachcongvan);
            request.setAttribute("count", count);
           Coquanquerry coquanquerry=new Coquanquerry();
          danhsachcoquan = coquanquerry.Laydanhsachcoquanbanhanh();
            ArrayList<Tinhtrangxuly> danhsachtrangthai = congvanquerry.Laytrangthaicongvan();
            request.setAttribute("Danhsachcoquan", danhsachcoquan);

            //  request.setAttribute("Tongsoluongcongvan", "List of dispatchs:  "+count);
            //   request.setAttribute("view", view);
               request.setAttribute("Danhsachtrangthai",danhsachtrangthai);
            
            request.setAttribute("Danhsachtatcacongvan", danhsachcongvan);
        } catch (SQLException ex) {
            Logger.getLogger(Danhsachcongvanden.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url="/Trangtimkiem.jsp";
        RequestDispatcher dis=request.getRequestDispatcher(url);
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
