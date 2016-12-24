<%@ taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fom" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/img/logo_small.ico"/>
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap-select.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/lib/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/basic.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/bootstrap-select.min.js"></script>
    <link href="${pageContext.servletContext.contextPath}/resources/css/lib/fileinput.min.css" media="all"
          rel="stylesheet" type="text/css"/>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/plugins/canvas-to-blob.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/plugins/sortable.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lib/fileinput.min.js"></script>
    <title>Edit Book</title>
</head>
<body>
<%@include file="include/menu.jsp" %>
<div class="container-fluid text-center main-wrapper">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-11 col-lg-offset-1 text-left">
            <%--<cl:jsinclude/>--%>
            <%--<cl:jsconfig/>--%>
            <h2>Edit Book</h2>
            <div class="container top-sm-margin col-lg-offset-4 col-lg-8 text-center">
                <form:form class="col-lg-6" modelAttribute="bookForm" action="/Catalogue/AddBook"
                           method="post">
                    <form:errors path="name" class="has-error"/>
                    <form:input path="name" class="form-control bottom-sm-margin"
                                placeholder="Book name" autofocus="true"/>
                    <div class="form-group">
                        <form:label path="categoryId">Category:</form:label>
                        <form:select path="categoryId" class="selectpicker" name="categoryId"
                                     data-live-search="true" >
                            <c:forEach var="category" items="${categories}">
                                <form:option value="${category.idCategory}">${category.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="authorIdSet">Author(s):</form:label>
                        <form:select path="authorIdSet" class="selectpicker" name="authorIdList"
                                     data-live-search="true" multiple="true">
                            <c:forEach var="author" items="${authors}">
                                <form:option
                                        value="${author.idAuthor}">${author.firstName} ${author.lastName}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <form:textarea path="description" class="form-control bottom-sm-margin"
                                   placeholder="Description"/>
                    <form:errors path="pageNum" class="has-error"/>
                    <form:input path="pageNum" class="form-control bottom-sm-margin"
                                placeholder="Page number"/>
                    <form:errors path="publishYear" class="has-error"/>
                    <form:input path="publishYear" class="form-control bottom-sm-margin"
                                placeholder="Publish year"/>
                    <form:errors path="publishYear" class="has-error"/>
                    <div class="form-group">
                        <form:label path="publishHouseId">Publish house:</form:label>
                        <form:select path="publishHouseId" class="selectpicker" name="publishHouseId"
                                     data-live-search="true">
                            <%--data-new-value="${publishHouse.id}">--%>
                            <c:forEach var="publishHouse" items="${publishHouses}">
                                <form:option value="${publishHouse.idPublishHouse}">${publishHouse.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="libraryBookIdSet">Associate with library book(s):</form:label>
                        <form:select path="libraryBookIdSet" class="selectpicker"
                                     data-live-search="true" multiple="true">
                            <%--data-new-value="${publishHouse.id}">--%>
                            <c:forEach var="libraryBook" items="${libraryBooks}">
                                <form:option
                                        value="${libraryBook.idLibraryBook}">#${libraryBook.idLibraryBook}: ${libraryBook.book.name} (${libraryBook.book.publishHouse.name}, ${libraryBook.book.publishYear})</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <form:errors path="ebookUrl" class="has-error"/>
                    <form:input path="ebookUrl" class="form-control bottom-sm-margin"
                                placeholder="E-book URL"/>
                    <form:input path="imageUrl" type="file" class="file file-loading"
                                data-show-upload="false" data-show-caption="true"
                                data-allowed-file-extensions='["jpg", "png", "jpeg"]'
                                name="imageUrl"/>
                    <%--<cl:upload resourceType="auto" fieldName="imageUrl"/>--%>
                    <button class="btn btn-info submit-button top-lg-margin" type="submit">Finish</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
