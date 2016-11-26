<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World, from TheBookMaze!</h2>
<c:if test="${not empty quote}">
    ${quote.type}: ${quote.value.quote}
</c:if>
</body>
</html>