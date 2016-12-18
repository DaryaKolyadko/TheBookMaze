<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/catalogue.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <title>Catalogue</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<script type="text/javascript">
    selectMenuItem('#menu_catalogue')
</script>
<div class="container-fluid text-center main-wrapper" style="padding-top: 20px">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 text-left about-div">
            <h2>Book Catalogue</h2>
            <%--<sec:authorize access="hasRole('USER')">--%>
            <div class="top-padding bottom-padding left-lg-margin">
                <div class="button-row-parent">
                    <a class="btn btn-success" href="<c:url value='/Catalogue/AddCategory'/>">Add category</a>
                    <a class="btn btn-warning" href="<c:url value='/Catalogue/AddBook'/>">Add book</a>
                </div>
            </div>
            <%--</sec:authorize>--%>
            <div class="container top-sm-margin">
                <c:forEach items="${categories}" var="category">
                    <div class="col-md-3 col-lg-3">
                        <figure>
                            <a href="<c:url value='/Catalogue/Category/${category.idCategory}'/>" class="thumbnail">
                                <c:choose>
                                    <c:when test="${not empty category.imageUrl}">
                                        <img src='<cl:url src="${category.imageUrl}" width="190" height="240" secure="true"/>'
                                             class="img-responsive"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img src='${pageContext.servletContext.contextPath}/resources/img/book/defbookcover-min.jpg'
                                             width="190" height="240" class="img-responsive"/>
                                    </c:otherwise>
                                </c:choose>

                            </a>
                            <figcaption>
                                <a href="<c:url value='/Catalogue/Category/${category.idCategory}'/>"><span
                                        class="category-label">${category.name}</span></a>
                            </figcaption>
                        </figure>
                    </div>
                </c:forEach>

                <%--<div class="col-md-3 col-lg-3">--%>
                <%--<figure>--%>
                <%--<a href="<c:url value='/Catalogue/Category/Classics'/>" class="thumbnail">--%>
                <%--<img src='<cl:url src="81afb861-684c-45fc-a180-130f9245b631_yix0mx.jpg" width="190" height="240" secure="true"/>'--%>
                <%--class="img-responsive"/>--%>
                <%--</a>--%>
                <%--<figcaption>--%>
                <%--<a href="<c:url value='/Catalogue/Category/Classics'/>"><span class="category-label">Classics</span></a>--%>
                <%--</figcaption>--%>
                <%--</figure>--%>
                <%--</div>--%>
                <%--<div class="col-md-3 col-lg-3">--%>
                <%--<figure>--%>
                <%--<a href="<c:url value='/Catalogue/Category/Young_adult'/>" class="thumbnail">--%>
                <%--&lt;%&ndash;<img src='<cl:url src="11870085_vjs8sa.jpg" width="190" height="240" secure="true"/>'&ndash;%&gt;--%>
                <%--&lt;%&ndash;class="img-responsive"/>&ndash;%&gt;--%>
                <%--<img src='<cl:url src="11870085_vjs8sa.jpg" width="190" height="240" secure="true"/>'--%>
                <%--class="img-responsive"/>--%>
                <%--</a>--%>
                <%--<figcaption>--%>
                <%--<a href="<c:url value='/Catalogue/Category/Young_adult'/>"><span class="category-label">Young adult</span></a>--%>
                <%--</figcaption>--%>
                <%--</figure>--%>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>