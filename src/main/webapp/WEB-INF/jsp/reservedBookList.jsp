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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bookList.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>Reserved by: ${profile.login}</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 text-left">
            <h2>Reserved by: ${profile.login}</h2>
            <div class="container top-sm-margin">
                <div class="panel">
                    <div class="panel-body">
                        <table class="table borderless">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Library book ID</th>
                                <th>Book name</th>
                                <th>Cover</th>
                                <th>Reserve date</th>
                                <th>Return deadline</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="record" items="${reservedList}" varStatus="recordsIter">
                                <tr>
                                    <th scope="row">${recordsIter.count}</th>
                                    <td>${record.libraryBook.idLibraryBook}</td>
                                    <td>
                                        <a href='<c:url value='/Catalogue/Category/${record.libraryBook.book.category.idCategory}/Book/${record.libraryBook.book.idBook}'/>'>
                                                ${record.libraryBook.book.name}</a></td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${not empty record.libraryBook.book.imageUrl}">
                                                <img src='<cl:url src="${record.libraryBook.book.imageUrl}" width="40" height="59" secure="true"/>'
                                                     class="img-responsive bottom-sm-margin"/>
                                            </c:when>
                                            <c:otherwise>
                                                <img src='${pageContext.servletContext.contextPath}/resources/img/book/defbookcover-min.jpg'
                                                     width="40" height="59" class="img-responsive bottom-sm-margin"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td><fmt:formatDate type="date" value="${record.reserveDate}"
                                                        pattern="MM/dd/yyyy"/></td>
                                    <td><fmt:formatDate type="date" value="${record.returnDeadline}"
                                                        pattern="MM/dd/yyyy"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <%--<div class="col-md-2 col-lg-2">--%>
                    <%--<figure>--%>
                    <%--<a href="<c:url value='Young_adult/Book/2'/>" class="thumbnail">--%>
                    <%--<img src='<cl:url src="11870085_vjs8sa.jpg" width="140" height="180" secure="true"/>'--%>
                    <%--class="img-responsive"/>--%>
                    <%--</a>--%>
                    <%--<figcaption>--%>
                    <%--<a href="<c:url value='Young_Adult/Book/2'/>"><span class="book-label">The Fault in Our Stars</span></a>--%>
                    <%--</figcaption>--%>
                    <%--</figure>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>