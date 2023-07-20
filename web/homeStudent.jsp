<%-- 
    Document   : nameStudent
    Created on : Feb 27, 2023, 9:56:52 PM
    Author     : jiggnguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/home.css">
        <title>Student Home Page</title>
    </head>
    <body>
        <header>
            <div class="logo">
                <image src="IMAGE/fu.png" height="100%" width="15%" alt=""/>
                <ul>
                    <li><a class="home-link" href="login">Home</a></li>
                    <li><a class="home-link" href="course">Course</a></li>
                    <li><a class="home-link" href="course">Feedback</a></li>
                    <li><a class="home-link" href="course?mod=qna">Q&A</a></li>
                    <li style="margin-left: 20%;"><a style="color: red;" class="home-link" href="logout">Logout</a></li>
                </ul>
            </div>
        </header>
        <div id="main">
            <article>
                <div class="banner">
                    <h2>FPT EDUCATION</h2>
                    <h3> FEEDBACK AND QUESTION&ANSWER</h3>
                </div>
            </article>
            <nav>Welcome ${user.getName()}.</nav>

        </div>
        <footer>Copyright by Nguyen Tien Dat HE160751 </footer>
    </body>

</html>
