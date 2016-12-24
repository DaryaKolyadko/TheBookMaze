<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/img/logo_small.ico"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/whhg.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/userProfile.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>User: ${profile.firstName} ${profile.lastName}</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-9 col-lg-offset-1 text-left">
            <div class="col-sm-12 col-md-7 col-lg-7 col-sm-offset-0 col-md-offset-3 col-lg-offset-3">
                <div class="panel panel-warning user-panel">
                    <div class="panel-heading clearfix">
                        <span class="panel-title">User profile</span>
                        <%--<div class="pull-right">--%>
                            <%--<c:if test="${profile.login eq user.username}">--%>
                                <%--<a href='<c:url value="/UserProfile/Edit/${profile.login}"/>'--%>
                                   <%--class="btn btn-default">--%>
                                <%--<span class="glyphicon glyphicon-edit"--%>
                                      <%--style="color: black;"></span>--%>
                                <%--</a>--%>
                            <%--</c:if>--%>
                        <%--</div>--%>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12 col-lg-12 bottom-sm-margin">
                                <div class="col-lg-5">
                                    <c:choose>
                                        <c:when test="${not empty profile.imageUrl}">
                                            <img src='<cl:url src="${profile.imageUrl}" width="160" height="160" secure="true"/>'
                                                 class="img-responsive img-circle img-thumbnail"/>
                                        </c:when>
                                        <c:otherwise>
                                            <img src='${pageContext.servletContext.contextPath}/resources/img/avatar/default_avatar.png'
                                                 width="160" height="160" class="img-responsive img-circle img-thumbnail"/>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="col-lg-7 text-center">
                                    <table class="table borderless">
                                        <tbody>
                                        <tr>
                                            <td class="profile-title">Login</td>
                                            <td>${profile.login}</td>
                                        </tr>
                                        <tr>
                                            <td class="profile-title">First name</td>
                                            <td>${profile.firstName}</td>
                                        </tr>
                                        <tr>
                                            <td class="profile-title">Last name</td>
                                            <td>${profile.lastName}</td>
                                        </tr>
                                        <tr>
                                            <td class="profile-title">Birth date</td>
                                            <td><fmt:formatDate type="date" value="${profile.birthDate}"
                                                                pattern="MM/dd/yyyy"/></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <sec:authorize access="isAuthenticated()">
                                        <a class="btn-lg btn-info btn-reserved"
                                           href="<c:url value="/UserProfile/${profile.login}/Reserved"/>">Reserved
                                            books</a>
                                    </sec:authorize></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>