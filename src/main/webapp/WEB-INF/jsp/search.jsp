<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/img/logo_small.ico"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap-select.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/search.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap-select.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>Search</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<script type="text/javascript">
    selectMenuItem('#menu_search')
</script>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 text-left">
            <h2>Search</h2>
            <div class="container top-sm-margin">
                <div class="col-lg-5">
                    <img src="${pageContext.servletContext.contextPath}/resources/img/search/search.jpg"
                         class="search-img">
                </div>
                <div class="col-lg-4">
                    <form:form modelAttribute="searchForm" action="/SearchAction" method="POST">
                        <div class="form-group">
                            <form:label path="name">By name</form:label>
                            <form:input path="name" type="text" class="form-control" autofocus="true"/>
                        </div>
                        <div class="form-group">
                            <form:label path="author">By author</form:label>
                            <form:input type="text" path="author" class="form-control"/>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<form:label path="category">By category:</form:label>--%>
                            <%--<form:select path="category" class="selectpicker" name="category"--%>
                                         <%--data-live-search="true">--%>
                                <%--<form:option value="">None</form:option>--%>
                                <%--<c:forEach var="category" items="${categories}">--%>
                                    <%--<form:option value="${category.name}">${category.name}</form:option>--%>
                                <%--</c:forEach>--%>
                            <%--</form:select>--%>
                        <%--</div>--%>
                        <form:input path="category" value="" hidden="true"/>
                        <div class="form-group">
                            <form:label path="description">By words in description</form:label>
                            <form:input type="text" path="description" class="form-control"/>
                        </div>
                        <div class="col-lg-12 top-sm-margin bottom-super-lg-margin">
                            <button class="btn btn-success col-lg-offset-3 col-lg-5" type="submit">Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>