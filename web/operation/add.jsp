<%-- 
    Document   : add
    Created on : 4 févr. 2024, 23:15:01
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../bootstrap/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form method="post" action="cnt" class="register-form"
              id="login-form">
            <div class="form-group">
                <label for="username"><i
                        class="zmdi zmdi-account material-icons-name"></i></label> <input
                    type="text" name="name" id="ClientName"
                    placeholder="Votre Nom" />
            </div>
            <div class="form-group">
                <label for=""><i class="zmdi zmdi-lock"></i></label> <input
                    type="text" name="solde" id="solde"
                    placeholder="Votre Solde" />
            </div>
            <div class="form-group form-button">
                <input type="submit" name="valide" id="valide"
                       class="form-submit" value="Valider" />
            </div>
            <div class="form-group form-button">
                <input type="reset" name="annule" id="annule"
                       class="form-submit" value="Annuler" />
            </div>
            <div class="">
                <button><a class="dropdown-item" href="../admin/home.jsp">Annuler</a></button>
            </div>
        </form>
    </body>
</html>
