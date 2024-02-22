
package controller;

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
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import java.sql.*;


@WebServlet("/admin/cntu")
public class ControllerUpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static Connection connex = null;
    public static PreparedStatement prepare = null;
    RequestDispatcher dispatcher = null;
    public String status;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
      
        String id = request.getParameter("idUpdate");
        String nom = request.getParameter("nameUpdate");
        String solde = request.getParameter("soldeUpdate");
        String sta = request.getParameter("statusUpdate");
        HttpSession session = request.getSession();
        

        PrintWriter out = response.getWriter();
        
        
        float x = Float.parseFloat(solde);
       
       if (x < 1000) {
           status = "insuffisant";
       } else if (x <= 1000 || x <= 5000) {
           status = "moyen";
           
       } else {
           status = "éléve";
       }
        out.print(id);
        out.print(nom);
        out.print(solde);
        out.print(status);
       
            if (nom.equals("")) {
                out.print("Veuiller remplir le champs de le nom");
            } else if (solde.equals("")) {
                out.print("Veuiller remplir le champs de le nom");
            } else {
                try {
                    Class.forName("org.postgresql.Driver");
                    connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JSP", "postgres", "lionot");

                    if (connex != null) {
                        out.print("Connexion is stable");
//                        out.print(PassWord);
//                        out.print(PWrepete);
                        String Query = "UPDATE comptes SET nameClient = '"+nom+"',soldeClient = '" +solde+ "',soldeStatus = '" +status+ "' WHERE idClient = '" +id+ "' ";
                        prepare = connex.prepareStatement(Query);
                        int rowCount = prepare.executeUpdate();
                        dispatcher = request.getRequestDispatcher("home.jsp");
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
                } finally {
                        connex.close();
                    
                }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerUpdateServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControllerUpdateServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerUpdateServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControllerUpdateServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
