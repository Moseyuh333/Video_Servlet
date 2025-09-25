<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<sitemesh:decorate name="user">
    <sitemesh:title>Video theo Category</sitemesh:title>
    <div>
        <h2>Category Name: ${category.name} (${count})</h2>
        <c:forEach var="video" items="${videos}">
            <div>
                <img src="${video.poster}" alt="${video.title}" width="100"/>
                <h4><a href="${pageContext.request.contextPath}/videos?action=detail&id=${video.id}">${video.title}</a></h4>
                <p>Mã video: ${video.code}</p>
                <p>Category name: ${video.category.name}</p>
                <p>View: ${video.views}</p>
                <p>Share: <button>${video.shares}</button></p>
                <p>Like: <button>${video.likes}</button></p>
            </div>
        </c:forEach>
    </div>
</sitemesh:decorate>
