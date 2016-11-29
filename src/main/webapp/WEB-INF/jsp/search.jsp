<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <form action="<c:url value='/Search'/>" method="POST">
                        <div class="form-group">
                            <label for="byName">By name</label>
                            <input type="text" name="byName" id="byName" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="byAuthor">By author</label>
                            <input type="text" name="byAuthor" id="byAuthor" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="category">By category</label>
                            <select class="selectpicker form-control" name="categoryId" id="category"
                                    data-live-search="true">
                                <%--data-new-value="${uncompleted.sectionId}">--%>
                                <%--<c:forEach var="section" items="${sections}">--%>
                                <%--<option value="${section.id}">${section.name}</option>--%>
                                <%--</c:forEach>--%>
                                <option value="1">Classics</option>
                                <option value="2">Young adult</option>
                            </select>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox">e-books only</label>
                        </div>
                        <div class="col-lg-12 top-sm-margin bottom-super-lg-margin">
                            <button class="btn btn-success col-lg-offset-3 col-lg-5" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>