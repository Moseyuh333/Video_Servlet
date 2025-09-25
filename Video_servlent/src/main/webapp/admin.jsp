<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<sitemesh:decorate name="admin">
    <sitemesh:title>Trang quản trị</sitemesh:title>
    <div>
        <h2>Trang quản trị</h2>
        <p>Chào mừng Admin: ${sessionScope.user.username}</p>
        <a href="${pageContext.request.contextPath}/videos">Quản trị Video</a>
    </div>
</sitemesh:decorate>
