<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<sitemesh:decorate name="user">
    <sitemesh:title>Đăng ký</sitemesh:title>
    <div>
        <h2>Đăng ký</h2>
        <form method="post" action="${pageContext.request.contextPath}/register">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" required />
            <br/>
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required />
            <br/>
            <label for="confirmPassword">Xác nhận mật khẩu:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required />
            <br/>
            <button type="submit">Đăng ký</button>
        </form>
        <c:if test="${not empty error}">
            <p style="color:red">${error}</p>
        </c:if>
        <p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
    </div>
</sitemesh:decorate>
