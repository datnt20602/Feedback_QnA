<%-- 
    Document   : home
    Created on : Feb 27, 2023, 9:57:59 PM
    Author     : jiggnguyen
--%>
<%@page import="model.Student"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/login.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>

        <div class="box">
            <div class="container">
                <form action="login" method="POST">
                    <div class="top">
                        <span>FPT University Feedback and Q&A</span>
                        <header>Login</header>
                    </div>

                    <div class="input-field">
                        <input type="text" class="input" placeholder="Username" id="" name="email">
                        <i class='bx bx-user' ></i>
                    </div>

                    <div class="input-field">
                        <input type="Password" class="input" placeholder="Password" id="" name="password">
                        <i class='bx bx-lock-alt'></i>
                    </div>

                    <div class="input-field">
                        <input type="submit" class="submit" value="Login" name="home">
                    </div>
                    <h3 style="color: white">${err}</h3>

                    <div class="two-col">
                        <div class="one">
                            <input type="checkbox" name="" id="check">
                            <label for="check"> Remember Me</label>
                        </div>
                        <div class="two">
                            <label><a href="#"></a></label>
                        </div>
                    </div>
                </form>

            </div>
        </div>  


    </body>
</html>
