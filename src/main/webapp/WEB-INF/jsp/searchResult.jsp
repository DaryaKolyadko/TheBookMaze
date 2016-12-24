<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bookList.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>Search result:</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 text-left">
            <h2>Search results</h2>
            <div>
                <b>Book name:</b> '${searchQuery.name}'<br>
                <b>Author:</b> '${searchQuery.author}'<br>
                <%--<b>Category:</b> '${searchQuery.category}'<br>--%>
                <b>Description:</b> '${searchQuery.description}'<br>
            </div>
            <c:if test="${empty books}">
                <br>
                <h3>No results</h3>
            </c:if>
            <div class="container top-sm-margin">
                <c:forEach var="book" items="${books}">
                    <div class="col-md-2 col-lg-2">
                        <figure>
                            <a href="<c:url value='/Catalogue/Category/${book.category.idCategory}/Book/${book.idBook}'/>"
                               class="thumbnail">
                                <c:choose>
                                    <c:when test="${not empty book.imageUrl}">
                                        <img src='<cl:url src="${book.imageUrl}" width="190" height="240" secure="true"/>'
                                             class="img-responsive"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img src='${pageContext.servletContext.contextPath}/resources/img/book/defbookcover-min.jpg'
                                             width="190" height="240" class="img-responsive"/>
                                    </c:otherwise>
                                </c:choose>
                            </a>
                            <figcaption>
                                <a href="<c:url value='/Catalogue/Category/${book.category.idCategory}/Book/${book.idBook}'/>"><span
                                        class="book-label">${book.name}</span></a>
                            </figcaption>
                        </figure>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
