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
    <title>Publish Houses</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-11 col-lg-offset-1 text-left">
            <h2>Publish Houses</h2>
            <div class="container top-sm-margin col-lg-offset-3 col-lg-6 text-center">
                <div class="top-padding bottom-sm-margin text-left">
                    <div class="button-row-parent">
                        <a class="btn btn-success" href="<c:url value='/PublishHouses/AddPublishHouse'/>">
                            <span class="glyphicon glyphicon-plus"></span> Add publish house</a>
                    </div>
                </div>
                <div class="panel">
                    <div class="panel-body">
                        <table class="table borderless">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="publishHouse" items="${publishHouses}" varStatus="publishHousesIter">
                                <tr>
                                    <th scope="row">${publishHousesIter.count}</th>
                                    <td>${publishHouse.name}</td>
                                    <td>
                                        <form action="/PublishHouses/DeletePublishHouse/${publishHouse.idPublishHouse}"
                                              id="deleteForm${publishHouse.idPublishHouse}"
                                              method="post" hidden>
                                        </form>
                                        <div class="btn-group">
                                            <a href="/PublishHouses/EditPublishHouse/${publishHouse.idPublishHouse}"
                                               class="btn btn-default">
                                                    <span class="glyphicon glyphicon-edit"
                                                          style="color: black;"></span>
                                            </a>
                                            <a href="#"
                                               onclick="$('#deleteForm${publishHouse.idPublishHouse}').submit()"
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