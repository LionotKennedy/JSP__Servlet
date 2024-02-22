<%-- 
    Document   : add
    Created on : 4 févr. 2024, 23:15:01
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../style/style1.css" rel="stylesheet" type="text/css"/>
        <script src="../SweetAlert/sweetarte.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
        <form method="post" action="cntu" class="register-form"
              id="login-form"  onsubmit="return submitForm(this);">
              <%
               Connection connex;
               ResultSet resul;
               PreparedStatement prepare;
               
               Class.forName("org.postgresql.Driver");
               connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JSP", "postgres", "lionot");
                
                String id = request.getParameter("idClient");
               // prepare = connex.prepareStatement("SELECT * FROM comptes WHERE idClient = ?");
                String query = "SELECT * FROM comptes WHERE idClient = '"+id+"'";
                prepare = connex.prepareStatement(query);
                //prepare.setString(1, id);
                resul = prepare.executeQuery();
                while(resul.next())
                {
            %>
            <div class="form-group h">
                <label for="username"><i
                        class="zmdi zmdi-account material-icons-name"></i></label> <input
                    type="text" name="idUpdate" id="ClientName"
                    placeholder="Votre identifier" value="<%=resul.getString("idClient")%>" />
            </div>
            <div class="form-group">
                <label for="username"><i
                        class="zmdi zmdi-account material-icons-name"></i></label> <input
                    type="text" name="nameUpdate" id="ClientName"
                    placeholder="Votre Nom" value="<%=resul.getString("nameClient")%>" />
            </div>
            <div class="form-group">
                <label for=""><i class="zmdi zmdi-lock"></i></label> <input
                    type="text" name="soldeUpdate" id="solde"
                    placeholder="Votre Solde" value="<%=resul.getString("soldeClient")%>" />
            </div>
            <div class="form-group h">
                <label for=""><i class="zmdi zmdi-lock"></i></label> <input
                    type="text" name="statusUpdate" id="solde"
                    placeholder="Votre status Solde" value="<%=resul.getString("soldeStatus")%>" />
            </div>
            <%
            }
            %>
            <div class="form-group form-button">
                <input type="submit" name="val" id="val"
                       class="form-submit" value="Valider" />
            </div>
            <div class="">
                <a class="dropdown-item lien teste1" href="../admin/home.jsp"><span class="teste">Annuler</span></a>
              </div>
        </form>
        <div class="drop drop_1"></div>
        <div class="drop drop_2"></div>
        <div class="drop drop_3"></div>
        <div class="drop drop_4"></div>
        <div class="drop drop_5"></div>
    </div>
    <script>
            function submitForm(form) {
            swal({
            title: "Good job!",
            text: "You clicked the button",
            icon: "success",
            button: "OK",
        }).then((isOkay) => {
                if (isOkay) {
                    form.submit();
                }
            });
            return false;
        }
    </script>
    </body>
</html>
