<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
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
    <link href="${pageContext.servletContext.contextPath}/resources/css/lib/fileinput.min.css" media="all"
          rel="stylesheet" type="text/css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/plugins/canvas-to-blob.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/plugins/sortable.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/fileinput.min.js"></script>
    <title>Edit User Profile</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-11 col-lg-11 col-lg-offset-1 text-left">
            <h2>Edit User Profile</h2>
            <div class="container top-sm-margin col-lg-offset-4 col-lg-8 text-center">
                <form:form class="col-lg-6" modelAttribute="userForm" action="/UserProfile/Edit" method="post">
                    <form:errors path="firstName" class="has-error"/>
                    <form:input path="firstName" class="form-control bottom-sm-margin"
                                placeholder="First name" autofocus="true"/>
                    <form:errors path="lastName" class="has-error"/>
                    <form:input path="lastName"
                                class="form-control bottom-sm-margin"
                                placeholder="Last name"/>
                    <form:input path="login" class="form-control bottom-sm-margin"
                                placeholder="Login" readonly="true"/>
                    <form:errors path="libraryId" class="has-error"/>
                    <form:input path="libraryId"
                                class="form-control bottom-sm-margin"
                                placeholder="Library id"/>
                    <form:errors path="birthDate" class="has-error"/>
                    <div class="input-group date bottom-sm-margin" id="birthday-picker" data-provider="datepicker">
                        <form:input id="picker" class="form-control" placeholder="Birth date"
                                    path="birthDate" readonly="true"/>
                        <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                    <label>Current avatar:</label>
                    <c:choose>
                        <c:when test="${not empty userForm.imageUrl}">
                            <img src='<cl:url src="${userForm.imageUrl}" width="90" height="140" secure="true"/>'
                                 class="img-responsive top-sm-margin bottom-sm-margin"/>
                        </c:when>
                        <c:otherwise>
                            <img src='${pageContext.servletContext.contextPath}/resources/img/book/defbookcover-min.jpg'
                                 width="90" height="140" class="img-responsive top-sm-margin bottom-sm-margin"/>
                        </c:otherwise>
                    </c:choose>
                    <form:input path="imageUrl" type="file" class="file file-loading"
                                data-show-upload="false" data-show-caption="true"
                                data-allowed-file-extensions='["jpg", "png", "jpeg"]'
                                name="imageUrl"/>
                    <button class="btn btn-info submit-button top-sm-margin" type="submit">Finish</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>