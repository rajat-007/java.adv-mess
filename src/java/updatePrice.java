/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAJAT DUBEY
 */
public class updatePrice extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
                       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","tsunadesama");
                        String day=request.getParameter("day");
                         int price=Integer.parseInt(request.getParameter("price"));
                           Statement st=con.createStatement();
                                    String s="update price set price="+price+" where day='"+day+"'";
                                     int i=st.executeUpdate(s);
                                   if(i>0)
                                   {
                                       out.println("Price Updated");
                                       Statement stmt=con.createStatement();
                                       String sr="select * from price;";
                                       ResultSet rs=stmt.executeQuery(sr);int t=0;String tot="Tot";
                                       while(rs.next())
                                       {
                                           t=t+rs.getInt(2);
                                       }
                                       Statement st1=con.createStatement();
                                       String n="update price set price="+t+" where day='"+tot+"';";
                                       int d=st1.executeUpdate(n);
                                       if(d>0)
                                       {
                            RequestDispatcher rd=request.getRequestDispatcher("Adminsign.html");
                         
                         rd.include(request, response);
                                       }
                                   }
                         
           
        }
        catch(Exception e)
        {
            out.println(e);
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
        processRequest(request, response);
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
