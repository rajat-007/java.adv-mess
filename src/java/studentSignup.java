

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class studentSignup extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
                       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","tsunadesama");
                       String id=request.getParameter("id");
                       String name=request.getParameter("pname");
                       long mobile=Long.parseLong(request.getParameter("mob"));
                       String ftype=request.getParameter("ftype");
                       String course=request.getParameter("course");
                       String doj=request.getParameter("doj");
                       String email=request.getParameter("email");
                       String person=request.getParameter("person");
                        Statement st= con.createStatement();
                        int amount=0;
		       String s="insert into userdetails values('"+id+"','"+name+"','"+course+"',"+mobile+",'"+ftype+"',"+amount+",'"+doj+"','"+email+"','"+person+"');";
		       int d= st.executeUpdate(s);
                        if(d>0)
                       {
                           out.println("You are successfully registered!!! Login Now");
                            RequestDispatcher rd=request.getRequestDispatcher("Student.html");
                         
                         rd.include(request, response);
                       }
                        else
                        {
                          out.println("Invalid registration!!!");
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
