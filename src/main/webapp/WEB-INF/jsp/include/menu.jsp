<nav class="navbar navbar-default navbar-fixed-top text-with-shadow" userRole="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%--<c:url value="/maze" var="url_home"/>--%>
            <form id="form_menu_logo" method="get" action="${url_home}" hidden></form>
            <a href="#" onclick="document.getElementById('form_menu_logo').submit()" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/resources/img/logo.png">
            </a>
        </div>
        <div class="collapse navbar-collapse" id="mainMenu">
            <ul class="nav navbar-nav">
                <li id="menu_catalogue">
                    <a href='<c:url value="/catalogue"/>'> Catalogue <span class="fa fa-book fa-fw"></span></a>
                </li>
                <li id="menu_about">
                    <a href='<c:url value="/about"/>'> About</a>
                </li>
                <li id="menu_search">
                    <a href='<c:url value="/Search"/>'> Search <span class="fa fa-search fa-fw fa-flip-horizontal"></span></a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li id="menu_log_in">
                    <a href='<c:url value="/Login"/>'> Login <span class="fa fa-sign-in fa-fw"></span></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="splash">
    <div class="container">
        <%--<h1>Welcome to The Book Maze!</h1>--%>
        <%--<p>&#9899; Read \u2022; Download \u2022; Enjoy</p>--%>
    </div>
</div>