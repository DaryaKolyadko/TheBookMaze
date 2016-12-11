<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script src="${pageContext.servletContext.contextPath}/resources/js/signUp.js"></script>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/datepicker3.min.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap-datepicker.min.js"></script>
    <title>Sign Up</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-11 col-lg-11 col-lg-offset-1 text-left">
            <h2>Sign Up In The Book Maze</h2>
            <div class="container top-sm-margin col-lg-offset-4 col-lg-8 text-center">
                <form:form class="col-lg-6" modelAttribute="userForm" action="/SignUp" method="post">
                    <form:errors path="firstName" class="has-error"/>
                    <form:input path="firstName" class="form-control bottom-sm-margin"
                                placeholder="First name" autofocus="true"/>
                    <form:errors path="lastName" class="has-error"/>
                    <form:input path="lastName"
                                class="form-control bottom-sm-margin"
                                placeholder="Last name"/>
                    <form:errors path="login" class="has-error"/>
                    <form:input path="login" class="form-control bottom-sm-margin"
                                placeholder="Login"/>
                    <form:errors path="password" class="has-error"/>
                    <form:password path="password"
                                   class="form-control bottom-sm-margin"
                                   placeholder="Password"/>
                    <form:errors path="passwordConfirm" class="has-error"/>
                    <form:password path="passwordConfirm"
                                   class="form-control bottom-sm-margin"
                                   placeholder="Confirm password"/>
                    <form:errors path="birthDate" class="has-error"/>
                    <div class="input-group date bottom-sm-margin" id="birthday-picker" data-provider="datepicker">
                        <form:input id="picker" class="form-control" placeholder="Birth date"
                                    path="birthDate" readonly="true"/>
                        <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                    <button class="btn btn-info submit-button" type="submit">Sign Up</button>
                </form:form>
            </div>
            <div class="top-lg-margin text-center">
                <span class="sign-up-log-in-offer">Have an account...?</span>
                <a href="<c:url value='/LogIn'/>" class="btn btn-success">Log In</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>