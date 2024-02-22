
package com.uniquedeveloper.registration;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.HeadlessException;

// starting connexion database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
// Ending database connexion


@WebServlet("/registre")
public class RegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static Connection connex = null;
    public static PreparedStatement prepare = null;
    RequestDispatcher dispatcher = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);
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
        // processRequest(request, response);

        // ****** Starting ******//
        // PrintWriter out = response.getWriter();
        // out.print("Working");
        String UserName = request.getParameter("name");
        String Email = request.getParameter("email");
        String PassWord = request.getParameter("password");
        String PWrepete = request.getParameter("repete");

        PrintWriter out = response.getWriter();
        out.print(UserName);
        out.print(Email);
        out.print(PassWord);
        out.print(PWrepete);

        if (PassWord == null ? PWrepete == null : !PassWord.equals(PWrepete)) {
            out.print("different");
            out.print(PassWord);
            out.print(PWrepete);
            dispatcher = request.getRequestDispatcher("registration.jsp");
        } else if (PassWord == null ? PWrepete != null : PassWord.equals(PWrepete)) {

            if (Email.equals("")) {
                out.print("Veuiller remplir le champs de Email");
            } else if (PassWord.equals("")) {
                out.print("Veuiller remplir le champs de la mot de passe");
            }else if (UserName.equals("")) {
                out.print("Veuiller remplir le champs de le nom");
            }else if (PWrepete.equals("")) {
                out.print("Veuiller remplir le champs de la confirmation mot de passe");
            } else {
                try {
                    Class.forName("org.postgresql.Driver");
                    connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JSP", "postgres", "lionot");

                    if (connex != null) {
                        out.print("Connexion is stable");
                        out.print(PassWord);
                        out.print(PWrepete);
                        String Query = "INSERT INTO users (UserName,Password,Email) VALUES (?,?,?)";
                        prepare = connex.prepareStatement(Query);
                        prepare.setString(1, UserName);
                        prepare.setString(2, PassWord);
                        prepare.setString(3, Email);
                        int rowCount = prepare.executeUpdate();
                        dispatcher = request.getRequestDispatcher("registration.jsp");
                        if (rowCount > 0) {
                            request.setAttribute("status", "success");
                        } else {
                            request.setAttribute("status", "failed");
                        }
                        dispatcher.forward(request, response);
                    } else {
                        out.print("Connexion is failed");
                    }
                } catch (HeadlessException | SQLException e) {
                    out.print("error in database loading ");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        connex.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
