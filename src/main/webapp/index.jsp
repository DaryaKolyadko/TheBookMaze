<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/img/logo_small.ico"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/about.css"/>
    <title>About The Book Maze</title>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
</head>
<body>
<%@include file="WEB-INF/jsp/include/menu.jsp" %>
<%--<h2>Hello World, from TheBookMaze!</h2>--%>
<%--<c:if test="${not empty quote}">--%>
<%--${quote.type}: ${quote.value.quote}--%>
<%--</c:if>--%>
<script type="text/javascript">
    selectMenuItem('#menu_about')
</script>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 text-left about-div">
            <div class="about-header">Welcome in The Book Maze!</div>
            <div class="green-text-normal-size">This is a place where you can forget about the waste of time!
                Today you haven't go to the library to find out if the book that
                you are interested in is in stock. This site will help you in this!
                You can reserve the book you want from anywhere in the world where you
                can be online! And if you prefer e-books there is a perfect opportunity for you!
                Our site also allow you to download some books. Have fun and relax!
            </div>
            <img src="resources/img/about/maze-1.jpg" class="img-thumbnail rotate-1" width="33%">
            <img src="resources/img/about/maze-2.jpg" class="img-thumbnail" width="30%">
            <img src="resources/img/about/maze-3.jpg" class="img-thumbnail rotate-2" width="33%">
            <a class="col-lg-offset-5 btn btn-info" href="<c:url value="/Catalogue"/> ">Go to catalogue >></a>
        </div>
    </div>
</div>
</body>
</html>