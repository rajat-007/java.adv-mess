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
import javax.servlet.http.HttpSession;

/**
 *
 * @author RAJAT DUBEY
 */
public class newpassServlet extends HttpServlet {

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
        try  {
            Class.forName("com.mysql.jdbc.Driver");
                       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","tsunadesama");
                        String pass=request.getParameter("upass");
                        HttpSession session=request.getSession(false);
                        int id=(int)session.getAttribute("uid");
                         Statement st=con.createStatement();
                                    String s="select * from adminmaster;";
                                     ResultSet rs=st.executeQuery(s);
                                     while(rs.next())
                                     {
                                         if(rs.getInt(1)==id)
                                         {
                                             Statement stmt=con.createStatement();
                                             String p="update adminmaster set password='"+pass+"' where adminId="+id+";";
                                             int i=stmt.executeUpdate(p);
                                             if(i>0)
                                             {
                                             out.println("Password Reset Successful!!! Login Now");
                                              RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
                         
                         rd.include(request, response);
                                             }
                                             else
                                             {
                                                 out.println("Invalid Credentials");
                                                  RequestDispatcher rd=request.getRequestDispatcher("newpass.html");
                         
                         rd.include(request, response);
                                             }
                                         }
                                     }
        }
        catch(Exception e)
        {
            e.printStackTrace(out);
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
