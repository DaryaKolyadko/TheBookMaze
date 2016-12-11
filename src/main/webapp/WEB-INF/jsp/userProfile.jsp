<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
                        <div class="pull-right">
                            <%--<c:if test="${profile.id eq userContainer.object.id}">--%>
                            <form id="form-edit-profile" method="get"
                                  action="<c:url value="/EditProfile"/>" hidden>
                                <input type="text" name="login" value="${profile.login}">
                            </form>
                            <button class="btn btn-default"
                                    onclick="$('#form-edit-profile').submit()">
                                <span class="glyphicon icon-edit"></span>
                            </button>
                            <%--</c:if>--%>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12 col-lg-12 bottom-sm-margin">
                                <div class="col-lg-5">
                                    <img src='<cl:url src="katherine-mcnamara-supports-girl-up-campaign-09_id6olb.jpg"
                                width="160" height="160" secure="true"/>' class="img-responsive img-circle img-thumbnail"/>
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
                                            <td>${profile.birthDate}</td>
                                            <%--<td><fmt:formatDate type="date" value="${profile.birthDate}" pattern="MM/dd/yyyy"/></td>--%>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <a class="btn-lg btn-info btn-reserved" href="<c:url value="/${profile.login}/Reserved"/>">My reserved books</a>
                                </div>
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