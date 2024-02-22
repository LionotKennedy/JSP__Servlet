<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/style.css" />
        <!-- <link rel="stylesheet" href="bootstrap/styles.css"> -->
        <title>Formulaire</title>
    </head>

    <body>
        <div class="container">
            <!-- formulaire -->
            <form action="registre" method="post">
                <p>Welcome</p>

                <input type="name" placeholder="Name" id="name" name="name" value="" />
                <br />

                <input type="email" placeholder="Email" id="email" name="email" value="" />
                <br />
                <input type="password" placeholder="password" id="password" name="password" value="" />
                <br />
                <input type="password" placeholder="repete your password" id="repete" name="repete" value="" />
                <br />

                <input type="submit" value="registre" name="signup" id="signup" /><br />
                <!-- <button type="submit" class="in">Create</button> -->
                <a href="#">Forget ?</a>
                <!--        <a href="operation/read.html">se connecter</a>-->
                <a href="login.jsp">se connecter</a>
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
