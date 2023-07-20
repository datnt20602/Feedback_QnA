<%-- 
    Document   : showQnaLecture
    Created on : Mar 20, 2023, 7:47:12 PM
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
        <link rel="stylesheet" href="CSS/showQna.css"/>
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
            <div class="lbang">
                
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Student Id</th>
                            <th>Question</th>
                            <th>Answer</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="count" value="${1}"/>
                        <c:forEach var="i" items="${listQna}">
                            <tr>
                                <td>${count}</td>
                                <td>${i.getStudentId()}</td>
                                <td>${i.getQuestion()}</td>
                                <c:if test="${i.getAnswer() != null && !i.getAnswer().isEmpty()}">
                                    <td>${i.getAnswer()}</td>
                                </c:if>
                                <c:if test="${i.getAnswer() == null || i.getAnswer().isEmpty()}">
                                    <td>
                                        <button id="${i.getId()}" style="cursor: pointer;" onclick="showForm(${i.getId()})">Answer</button>
                                        <form style="display: none;" id="form${i.getId()}" class="answer-form" action="qna" method="POST">
                                            <div class="form-send">
                                                <input style="display: none;" type="text" name="cid" value="${param.id}">
                                                <input style="display: none;" type="text" name="uid" value="${param.uid}">
                                                <input style="display: none;" id="answerId" type="text" name="qnaId">
                                                <input type="text" name="text" required="" placeholder="Answer..."> <button style="cursor: pointer;" type="submit">Send <ion-icon name="send-outline"></ion-icon></button>
                                            </div>
                                        </form>
                                    </td>
                                </c:if>
                                <td>${i.getDate()}</td>
                                <c:set var="count" value="${count+1}"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script>
            function showForm(id) {
                var questionId = document.getElementById(id);
                var idForm = "form" + id + "";
                var answer = document.getElementById(idForm);
                if (answer.style.display == "block") {
                    answer.style.display = "none";
                } else {
                    answer.style.display = "block";
                }
                questionId.classList.toggle("select");
                var input = document.getElementById("answerId");
                input.value = id;
            }
        </script>
    </body>
</html>
