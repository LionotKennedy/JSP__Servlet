package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
import ConnexionDB.Connexion;
import jakarta.servlet.ServletConfig;
import java.sql.*;

@WebServlet("/admin/cnt")
public class ControllerServlet extends HttpServlet {

    public String status;
    private Connection connex;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.connex = Connexion.getConn();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String UserName = request.getParameter("name");
        String Solde = request.getParameter("solde");

        out.print(UserName);
        out.print(Solde);

        float x = Float.parseFloat(Solde);

        if (x < 1000) {
            status = "insuffisant";
        } else if (x <= 1000 || x <= 5000) {
            status = "moyen";

        } else {
            status = "éléve";
        }

        if (connex != null) {

            try {
                Client customer = new Client(UserName, x, status);
                if (customer.insert(connex) == 1) {
                    // Utilisez la redirection au lieu du transfert de requête
                    response.sendRedirect("home.jsp");
                }

            } catch (NumberFormatException e) {
                out.print("<h1>asio plan numerique any kwh bro</h1>");
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
