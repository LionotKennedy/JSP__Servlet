<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/style_1.css" />
    <!-- <link rel="stylesheet" href="bootstrap/styles.css"> -->
    
    <link href="style/sidebars.css" rel="stylesheet" />
    <link href="style/personal.css" rel="stylesheet" />
    <link href="style/style.css" rel="stylesheet" />
    
    <title>Formulaire</title>
  </head>

  <body>
    <div class="container">
      <!-- formulaire -->
     
      <form action="admin" method="post">
        <p>Welcome</p>

        <input type="email" placeholder="Email" id="email" name="email" value="" />
        <br />
        <input
          type="password"
          placeholder="PassWord"
          id="password"
          name="password"
          value=""
        />
        <br />
        <input type="submit" value="connexion" name="signin" id="signin" />
        <br />
        <a href="#">Forget ?</a>
        <!--<a href="operation/read.jsp">Crée compte</a>-->
        <a href="registration.jsp">create accountr</a>
      </form>

      <!-- ombres -->

      <div class="drop drop_1"></div>
      <div class="drop drop_2"></div>
      <div class="drop drop_3"></div>
      <div class="drop drop_4"></div>
      <div class="drop drop_5"></div>
    </div>
  </body>
</html>
