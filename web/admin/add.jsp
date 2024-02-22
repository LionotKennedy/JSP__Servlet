<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
    <link href="../style/style1.css" rel="stylesheet" type="text/css" />
    <script src="../SweetAlert/sweetarte.js" type="text/javascript"></script>
  </head>
  <body>
    <div class="container">
      <form method="post" action="cnt" class="register-form" id="login-form" onsubmit="return submitForm(this);">
        <div class="form-group">
          <label for="username"
            ><i class="zmdi zmdi-account material-icons-name"></i
          ></label>
          <input
            type="text"
            name="name"
            id="ClientName"
            placeholder="Votre Nom"
          />
        </div>
        <div class="form-group">
          <label for=""><i class="zmdi zmdi-lock"></i></label>
          <input
            type="text"
            name="solde"
            id="solde"
            placeholder="Votre Solde"
          />
        </div>
        <div class="form-group form-button">
          <input
            type="submit"
            name="valide"
            id="valide"
            class="form-submit"
            value="Valider"
          />
        </div>
        <div class="form-group form-button h">
          <input
            type="button"
            name="annule"
            id="annule"
            class="form-submit"
            value="Annuler"
          />
        </div>
        <div class="">
          <a class="dropdown-item lien teste1" href="../admin/home.jsp"
            ><span class="teste">Annuler</span></a
          >
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
   

      document.addEventListener("DOMContentLoaded", function() {
        var successMessage = '<%= request.getAttribute("mpa") %>';
        if (successMessage) {
          document.getElementById("ClientName").value = "";
          document.getElementById("solde").value = "";
        }
      });
    </script>
  </body>
</html>
