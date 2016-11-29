<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/img/logo_small.ico"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/loginAndSignUp.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>Log In</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-11 col-lg-11 col-lg-offset-1 text-left">
            <h2>Log In The Book Maze</h2>
            <div class="container top-sm-margin col-lg-offset-4 text-center">
                <form class="col-lg-4" action="<c:url value='/LogIn'/>" method="post">
                    <input id="inputLogin" class="form-control bottom-sm-margin" placeholder="Login" required autofocus>
                    <input type="password" id="inputPassword" class="form-control bottom-sm-margin"
                           placeholder="Password" required>
                    <button class="btn btn-success submit-button" type="submit">Log in</button>
                </form>
            </div>
            <div class="top-lg-margin text-center">
                <span class="sign-up-log-in-offer">Have no account...?</span><a href="<c:url value='/SignUp'/>" class="btn btn-info">Sign Up</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>