<%-- 
    Document   : showFeedback
    Created on : Mar 15, 2023, 6:55:06 PM
    Author     : dmngh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/showFeedback.css"/>
    </head>
    <body>
        <div class="all">
            <!-- Navbar -->
            <div class="w3-top header">
                <div class="w3-bar w3-black w3-card">
                    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                    <a href="login" class="w3-bar-item w3-button w3-padding-large">HOME</a>
                    <a href="course" class="w3-bar-item w3-button w3-padding-large w3-hide-small">COURSE</a>
                    <a href="course" class="w3-bar-item w3-button w3-padding-large w3-hide-small">FEEDBACK</a>
                    <a href="course?mod=qna" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Q&A</a>
                    <a href="logout" class="w3-bar-item w3-button w3-hover-red w3-right w3-padding-large w3-hide-small">Logout <i class="fa fa-sign-out"></i></a>
                </div>
            </div>
            <div class="main">
                <div class="feedback">
                    <div style="text-align: center;" class="head-conver">
                        <h3 style="color: #465DFF;">Feedback</h3>
                    </div>
                    <c:if test="${isStudent}">
                        <div class="body-conver">
                            <div class="conver">
                                <c:forEach var="i" items="${listFeedback}">
                                    <div style="width: 100%; padding: 20px;margin-bottom: 10px;background-color: #EAEAEA;border-radius: 5px;" class="feedback-content">
                                        <p style="padding: 5px;">${i.getContent()}</p>
                                    </div>
                                </c:forEach>
                            </div>
                            <form action="feedback" method="GET">
                                <div class="form-send">
                                    <input style="display: none;" type="text" name="cid" value="${param.id}">
                                    <input style="display: none;" type="text" name="uid" value="${param.uid}">
                                    Teaching Skill:
                                    <input type="radio" name="op" value="Very good"> Very good
                                    <input type="radio" name="op" checked="" value="Good"> Good
                                    <input type="radio" name="op" value="Bad"> Bad
                                    <input type="radio" name="op" value="Very bad"> Very bad<br>
                                    <br><!-- comment -->
                                    Answering student:
                                    <input type="radio" name="op1" value="In class"> In class
                                    <input type="radio" name="op1" checked="" value="After class"> After class
                                    <input type="radio" name="op1" value="Online"> Online
                                    <input type="radio" name="op1" value="Not"> Not<br>
                                    <label for="grade"> Grade for lecture:(between 1 and 10):</label>
                                    <input type="number" id="grade" name="grade" min="1" max="10"><br>
                                    <input type="text" name="text" required="" placeholder="Feedback..."> <button style="cursor: pointer;" type="submit">Send <ion-icon name="send-outline"></ion-icon></button>
                                </div>
                            </form>
                        </div>

                    </c:if>
                    <c:if test="${!isStudent}">
                        <div class="body-conver">
                            <div class="conver">
                                <c:forEach var="i" items="${listFeedback}">
                                    <div style="width: 100%; padding: 20px;margin-bottom: 10px;background-color: #EAEAEA;border-radius: 5px;" class="feedback-content">
                                        <p style="padding: 5px;">${i.getContent()}</p>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <script>
            function showForm(id) {
                var questionId = document.getElementById(id);
                var answer = document.getElementById("answer-div");
                answer.classList.toggle("show");
                questionId.classList.toggle("select");
                var input = document.getElementById("answerId");
                input.value = id;
            }
        </script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>
