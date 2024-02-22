
package com.uniquedeveloper.registration;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.HeadlessException;

// starting connexion database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
// Ending database connexion


/**
 *
 * @author hp
 */
@WebServlet("/admin")
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static Connection connex = null;
    public static PreparedStatement prepare = null;
    public static ResultSet resul = null;
    // RequestDispatcher dispatcher = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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

        String Email = request.getParameter("email");
        String PassWord = request.getParameter("password");
        HttpSession session = request.getSession();
        

        PrintWriter out = response.getWriter();
        out.print(Email);
        out.print(PassWord);
//        out.print(PassWord);

        if (Email.equals("")) {
        out.print("Veuiller remplir le champs de la nom");
        } else if (PassWord.equals("")) {
        out.print("Veuiller remplir le champs de la mot de passe");
        } 
        else {
             try {
                Class.forName("org.postgresql.Driver");
                connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JSP", "postgres", "lionot");

                if (connex != null) {
                    out.print("Connexion is stable");
                    out.print(PassWord);
                    out.print(Email);
                    String Query = "SELECT * FROM users WHERE PassWord = ? and Email = ?";
                    prepare = connex.prepareStatement(Query);
                    prepare.setString(1, PassWord);
                    prepare.setString(2, Email);
                    resul = prepare.executeQuery();
                    if(resul.next())
                    {
                        session.setAttribute("name", resul.getString("UserName"));
                    //  dispatcher = request.getRequestDispatcher("index.jsp");
                    // dispatcher = request.getRequestDispatcher("admin/index.jsp");
                    // dispatcher = request.getRequestDispatcher("JSP_Projet");
                    
                    response.sendRedirect("admin/index.jsp");
                    //  request.getRequestDispatcher("admin/index.jsp").forward(request, response);
                    }else {
                        request.setAttribute("status", "failed");
                    // dispatcher = request.getRequestDispatcher("/");
                    }
                    // dispatcher.forward(request, response);
                } else {
                    out.print("Connexion is failed");
                }
            } catch (HeadlessException | SQLException e) {
                out.print("error in database loading ");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
