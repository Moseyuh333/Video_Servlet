<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<sitemesh:decorate name="admin">
    <sitemesh:title>Quản trị Video</sitemesh:title>
    <div>
        <h2>Quản trị Video</h2>
        <a href="${pageContext.request.contextPath}/videos?action=edit&id=0">Thêm Video mới</a>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Code</th>
                    <th>Views</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="video" items="${videos}">
                    <tr>
                        <td>${video.id}</td>
                        <td>${video.title}</td>
                        <td>${video.code}</td>
                        <td>${video.views}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/videos?action=detail&id=${video.id}">View</a>
                            <a href="${pageContext.request.contextPath}/videos?action=edit&id=${video.id}">Edit</a>
                            <a href="${pageContext.request.contextPath}/videos?action=delete&id=${video.id}" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Pagination -->
        <c:if test="${currentPage > 0}">
            <a href="${pageContext.request.contextPath}/videos?page=${currentPage - 1}">Previous</a>
        </c:if>
        <c:forEach var="i" begin="0" end="${totalPages - 1}">
            <c:if test="${i == currentPage}">
                <strong>${i + 1}</strong>
            </c:if>
            <c:if test="${i != currentPage}">
                <a href="${pageContext.request.contextPath}/videos?page=${i}">${i + 1}</a>
            </c:if>
        </c:forEach>
        <c:if test="${currentPage < totalPages - 1}">
            <a href="${pageContext.request.contextPath}/videos?page=${currentPage + 1}">Next</a>
        </c:if>
    </div>
</sitemesh:decorate>
