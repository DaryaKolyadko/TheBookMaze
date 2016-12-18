<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bookProfile.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>Book: ${book.name}</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper">
    <div class="row">
        <%--<div class="alert alert-danger">--%>
            <%--<a class="close" data-dismiss="alert" href="#">×</a>--%>
            <%--<form:errors path="id"/>--%>
        <%--</div>--%>
        <div class="col-sm-12 col-md-12 col-lg-9 col-lg-offset-1 text-left">
            <div class="col-lg-4">
                <c:choose>
                    <c:when test="${not empty book.imageUrl}">
                        <img src='<cl:url src="${book.imageUrl}" width="306" height="470" secure="true"/>'
                             class="img-responsive bottom-sm-margin"/>
                    </c:when>
                    <c:otherwise>
                        <img src='${pageContext.servletContext.contextPath}/resources/img/book/defbookcover-min.jpg'
                             width="306" height="470" class="img-responsive bottom-sm-margin"/>
                    </c:otherwise>
                </c:choose>
                <div class="button-row-parent">
                    <c:if test="${not empty book.ebookUrl}">
                        <a class="btn btn-success" href="<cl:url src='${book.ebookUrl}'
                    secure='true' resourceType='raw'/>" download>Download</a>
                    </c:if>
                    <sec:authorize access="hasRole('USER')">
                        <%--TODO--%>
                        <%--<c:if test="${not empty availablelibraryCopies}">--%>
                        <form:form method="post" class="right-button"
                                   action="/Catalogue/Category/${book.category.idCategory}/Book/${book.idBook}/Reserve"
                                   modelAttribute="libraryBook">
                            <form:hidden path="libraryBookId"/>
                        <button class="btn btn-warning" type="submit">Reserve</button>
                        <%--</c:if>--%>
                        </form:form>
                    </sec:authorize>
                </div>
            </div>
            <div class="col-lg-offset-1 col-lg-5">
                <span class="book-title">${book.name}</span>
                <table class="table borderless top-lg-margin">
                    <tbody>
                    <tr>
                        <td class="attr-title">Authors</td>
                        <td>
                            <c:forEach items="${book.authors}" var="author">
                                ${author.firstName} ${author.lastName}<br>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td class="attr-title">Publish house</td>
                        <td>${book.publishHouse.name}</td>
                    </tr>
                    <tr>
                        <td class="attr-title">Publish year</td>
                        <td>${book.publishYear}</td>
                    </tr>
                    <tr>
                        <td class="attr-title">Pages</td>
                        <td>${book.pageNum}</td>
                    </tr>
                    </tbody>
                </table>
                <div>
                    ${book.description}
                </div>
            </div>
        </div>
    </div>
    <%--<div class="row">--%>
    <%--<div class="col-sm-12 col-md-12 col-lg-9 col-lg-offset-1 text-left">--%>
    <%--<div class="col-lg-4">--%>
    <%--<img src='<cl:url src="11870085_vjs8sa.jpg" width="306" height="470" secure="true"/>'--%>
    <%--class="img-responsive bottom-sm-margin"/>--%>
    <%--<div class="button-row-parent">--%>
    <%--<a class="btn btn-success" href="<cl:url src='The_fault_in_our_stars_pdf_download_wmpgue.pdf'--%>
    <%--secure='true' resourceType='raw'/>" download>Download</a>--%>
    <%--<a class="btn btn-warning right-button" href="<c:url value='Reserve'/>">Reserve</a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-lg-offset-1 col-lg-5">--%>
    <%--<span class="book-title">The Fault in Our Stars</span>--%>
    <%--<table class="table borderless top-lg-margin">--%>
    <%--<tbody>--%>
    <%--<tr>--%>
    <%--<td class="attr-title">Author</td>--%>
    <%--<td>John Green</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td class="attr-title">Publish house</td>--%>
    <%--<td>Dutton books</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td class="attr-title">Publish year</td>--%>
    <%--<td>2012</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td class="attr-title">Pages</td>--%>
    <%--<td>318</td>--%>
    <%--</tr>--%>
    <%--</tbody>--%>
    <%--</table>--%>
    <%--<div>--%>
    <%--Despite the tumor-shrinking medical miracle that has bought her a few years, Hazel has never been--%>
    <%--anything but terminal, her final chapter inscribed upon diagnosis. But when a gorgeous plot twist--%>
    <%--named Augustus Waters suddenly appears at Cancer Kid Support Group, Hazel’s story is about to be--%>
    <%--completely rewritten.--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
</div>
</body>
</html>