<nav class="navbar navbar-default navbar-fixed-top text-with-shadow" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%--<c:url value="/maze" var="url_home"/>--%>
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/resources/img/logo.png">
            </a>
        </div>
        <div class="collapse navbar-collapse" id="mainMenu">
            <ul class="nav navbar-nav">
                <li id="menu_catalogue">
                    <a href='<c:url value="/Catalogue"/>'> Catalogue <span class="fa fa-book fa-fw"></span></a>
                </li>
                <li id="menu_about">
                    <a href='<c:url value="/About"/>'> About</a>
                </li>
                <li id="menu_search">
                    <a href='<c:url value="/Search"/>'> Search <span
                            class="fa fa-search fa-fw fa-flip-horizontal"></span></a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li id="menu_log_in">
                    <a href='<c:url value="/LogIn"/>'> Login <span class="fa fa-sign-in fa-fw"></span></a>
                </li>
                <li id="menu_sign_up">
                    <a href='<c:url value="/SignUp"/>'> Sign Up </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<img src="${pageContext.request.contextPath}/resources/img/header.png" width="100%"/>