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
    <title>Authors</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-11 col-lg-offset-1 text-left">
            <h2>Authors</h2>
            <div class="container top-sm-margin col-lg-offset-3 col-lg-6 text-center">
                <div class="top-padding bottom-sm-margin text-left">
                    <div class="button-row-parent">
                        <a class="btn btn-success" href="<c:url value='/Authors/AddAuthor'/>">
                            <span class="glyphicon glyphicon-plus"></span> Add author</a>
                    </div>
                </div>
                <div class="panel">
                    <div class="panel-body">
                        <table class="table borderless">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="author" items="${authors}" varStatus="authorsIter">
                                <tr>
                                    <th scope="row">${authorsIter.count}</th>
                                    <td>${author.firstName}</td>
                                    <td>${author.lastName}</td>
                                    <td>
                                        <form action="/Authors/DeleteAuthor/${author.idAuthor}"
                                              id="deleteForm${author.idAuthor}"
                                              method="post" hidden>
                                        </form>
                                        <div class="btn-group">
                                            <a href="/Authors/EditAuthor/${author.idAuthor}"
                                               class="btn btn-default">
                                                    <span class="glyphicon glyphicon-edit"
                                                          style="color: black;"></span>
                                            </a>
                                            <a href="#" onclick="$('#deleteForm${author.idAuthor}').submit()"
                                               class="btn btn-danger">
                                                    <span class="glyphicon glyphicon-trash"
                                                          style="color: white;"></span>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>