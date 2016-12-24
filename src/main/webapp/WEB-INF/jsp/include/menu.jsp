<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-default navbar-fixed-top text-with-shadow" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/resources/img/logo.png">
            </a>
        </div>
        <c:url value="/j_spring_security_logout" var="logOutUrl"/>
        <div class="collapse navbar-collapse" id="mainMenu">
            <ul class="nav navbar-nav">
                <li id="menu_catalogue">
                    <a href='<c:url value="/Catalogue"/>'> Catalogue <span class="fa fa-book fa-fw"></span></a>
                </li>

                <sec:authorize access="hasRole('ADMIN')">
                    <li id="menu_actions" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-expanded="false">Archive<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li class="dropdown-item"><a href="<c:url value='/Authors'/>">
                                Authors </a></li>
                            <li class="divider"></li>
                            <li class="dropdown-item"><a href="<c:url value='/PublishHouses'/>">
                                Publish Houses </a></li>
                            <li class="divider"></li>
                            <li class="dropdown-item"><a href="<c:url value='/Users'/>">
                                Users </a></li>
                        </ul>
                    </li>
                </sec:authorize>

                <li id="menu_about">
                    <a href='<c:url value="/About"/>'> About</a>
                </li>
                <li id="menu_search">
                    <a href='<c:url value="/Search"/>'> Search <span
                            class="fa fa-search fa-fw fa-flip-horizontal"></span></a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAnonymous()">
                    <li id="menu_log_in">
                        <a href='<c:url value="/LogIn"/>'> Login <span class="fa fa-sign-in fa-fw"></span></a>
                    </li>
                    <li id="menu_sign_up">
                        <a href='<c:url value="/SignUp"/>'> Sign Up </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="user" property="principal"/>
                    <li id="menu_profile" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-expanded="false">Hello, ${user.username}<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li class="dropdown-item"><a href="<c:url value='/UserProfile/${user.username}'/>">
                                <span class="fa fa-user fa-fw"></span>Profile </a></li>
                            <li class="divider"></li>
                            <li class="dropdown-item"><a href="${logOutUrl}"><span
                                    class="fa fa-sign-out fa-fw">
                        </span>Log out </a></li>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>
<img src="${pageContext.request.contextPath}/resources/img/header.png" width="100%"/>