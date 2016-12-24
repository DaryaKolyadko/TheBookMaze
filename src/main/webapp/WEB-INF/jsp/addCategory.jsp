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
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <link href="${pageContext.servletContext.contextPath}/resources/css/lib/fileinput.min.css" media="all"
          rel="stylesheet" type="text/css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/plugins/canvas-to-blob.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/plugins/sortable.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/fileinput.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.ui.widget.js"></script>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.iframe-transport.js"></script>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.fileupload.js"></script>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.cloudinary.js"></script>

    <%--<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.ui.widget.js"></script>--%>
    <%--<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.iframe-transport.js"></script>--%>
    <%--<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.fileupload.js"></script>--%>
    <%--<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.cloudinary.js"></script>--%>
    <title>Add Category</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-11 col-lg-offset-1 text-left">
            <%--<cl:jsinclude/>--%>
            <%--<cl:jsconfig/>--%>
            <h2>New Category</h2>
            <div class="container top-sm-margin col-lg-offset-4 col-lg-8 text-center">
                <form:form class="col-lg-6" modelAttribute="categoryForm" action="/Catalogue/AddCategory"
                           method="post">
                    <form:errors path="name" class="has-error"/>
                    <form:input path="name" class="form-control bottom-sm-margin"
                                placeholder="Category name" autofocus="true"/>
                    <form:input path="imageUrl" type="file" class="file file-loading"
                                data-show-upload="false" data-show-caption="true"
                                data-allowed-file-extensions='["jpg", "png", "jpeg"]'
                                placeholder="Category cover" name="imageUrl"/>
                    <%--<cl:upload resourceType="auto" fieldName="imageUrl"/>--%>
                    <button class="btn btn-info submit-button top-lg-margin" type="submit">Finish</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
