<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
</head>
<body>
    <header>
        <nav>
            <a href="${pageContext.request.contextPath}/home">Trang Chủ</a>
            <a href="${pageContext.request.contextPath}/videos">Sản phẩm</a>
            <c:if test="${sessionScope.user == null}">
                <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
            </c:if>
            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                <a href="${pageContext.request.contextPath}/admin">Trang quản trị</a>
            </c:if>
        </nav>
    </header>

    <main>
        <sitemesh:write property='body'/>
    </main>

    <footer>
        <p>Nguyen Minh Khoi, 23162045, 05</p>
    </footer>
</body>
</html>
