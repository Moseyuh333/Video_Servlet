<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<sitemesh:decorate name="user">
    <sitemesh:title>Trang Chủ</sitemesh:title>
    <div>
        <h2>Chào mừng, ${sessionScope.user.username}!</h2>
        <h3>Danh sách Video</h3>
        <c:forEach var="video" items="${videos}">
            <div>
                <img src="${video.poster}" alt="${video.title}" width="100"/>
                <h4><a href="${pageContext.request.contextPath}/videos?action=detail&id=${video.id}">${video.title}</a></h4>
                <p>Mã video: ${video.code}</p>
                <p>Category: ${video.category.name}</p>
                <p>View: ${video.views}</p>
                <p>Share: ${video.shares}</p>
                <p>Like: ${video.likes}</p>
            </div>
        </c:forEach>
    </div>
</sitemesh:decorate>
