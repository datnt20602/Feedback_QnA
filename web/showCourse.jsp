<%-- 
    Document   : showCourse
    Created on : Mar 15, 2023, 5:27:44 PM
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
        <link rel="stylesheet" href="CSS/showCourse.css"/>
    </head>
    <body>
        <div class="all">
            <!-- Navbar -->
            <div class="w3-top">
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
                <div class="list-items">
                    <c:if test="${isStudent}">
                        <c:if test="${!modQna}">
                            <c:forEach var="i" items="${data}">
                                <a href="feedbackQna?id=${i.getCourseId()}&uid=${i.getLectureId()}"><div class="item">
                                        <img src="${i.getImage()}" alt="alt"/>
                                        <div class="item-content">
                                            <h4 style="color: #FA809F">${i.getName()}</h4>
                                            <p style="color: #FA809F"><label style="font-weight: bold;color: black">Teacher: </label>${i.getTeacher()}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:if>
                        <c:if test="${modQna}">
                            <c:forEach var="i" items="${data}">
                                <a href="qna?id=${i.getCourseId()}&uid=${i.getLectureId()}"><div class="item">
                                        <img src="${i.getImage()}" alt="alt"/>
                                        <div class="item-content">
                                            <h4 style="color: #FA809F">${i.getName()}</h4>
                                            <p style="color: #FA809F"><label style="font-weight: bold;color: black">Teacher: </label>${i.getTeacher()}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:if>
                    </c:if>
                    <c:if test="${!isStudent}">
                        <c:if test="${!modQna}">
                            <c:forEach var="i" items="${data}">
                                <a href="feedbackQna?id=${i.getCourseId()}&uid=${i.getStudentId()}"><div class="item">
                                        <img src="${i.getImage()}" alt="alt"/>
                                        <div class="item-content">
                                            <h4 style="color: #FA809F">${i.getName()}</h4>
                                            <p style="color: #FA809F"><label style="font-weight: bold;color: black">Teacher: </label>${i.getTeacher()}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:if>
                        <c:if test="${modQna}">
                            <c:forEach var="i" items="${data}">
                                <a href="qna?id=${i.getCourseId()}&uid=${i.getStudentId()}"><div class="item">
                                        <img src="${i.getImage()}" alt="alt"/>
                                        <div class="item-content">
                                            <h4 style="color: #FA809F">${i.getName()}</h4>
                                            <p style="color: #FA809F"><label style="font-weight: bold;color: black">Teacher: </label>${i.getTeacher()}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
