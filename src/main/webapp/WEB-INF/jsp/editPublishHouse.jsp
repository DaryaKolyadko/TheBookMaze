<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fom" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/img/logo_small.ico"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>Edit publish house</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-11 col-lg-offset-1 text-left">
            <h2>Edit Publish House</h2>
            <div class="container top-sm-margin col-lg-offset-4 col-lg-8 text-center">
                <form:form class="col-lg-6" modelAttribute="publishHouseForm" action="/PublishHouses/EditPublishHouse"
                           method="post">
                    <form:input path="idPublishHouse" hidden="true"/>
                    <form:errors path="name" class="has-error"/>
                    <form:input path="name" class="form-control bottom-sm-margin"
                                placeholder="Name" autofocus="true"/>
                    <button class="btn btn-info submit-button" type="submit">Finish</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>