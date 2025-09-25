<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>${empty video ? 'Add Video' : 'Edit Video'}</title>
    <meta charset="UTF-8">
</head>
<body>
    <h2>${empty video ? 'Add New Video' : 'Edit Video'}</h2>
    
    <form method="post" action="${pageContext.request.contextPath}/videos">
        <input type="hidden" name="action" value="${empty video ? 'create' : 'update'}">
        <c:if test="${not empty video}">
            <input type="hidden" name="id" value="${video.id}">
        </c:if>
        
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${video.title}" required />
        <br/><br/>
        
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="${video.code}" required />
        <br/><br/>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" cols="50">${video.description}</textarea>
        <br/><br/>
        
        <label for="poster">Poster URL:</label>
        <input type="text" id="poster" name="poster" value="${video.poster}" />
        <br/><br/>
        
        <label for="categoryId">Category:</label>
        <select id="categoryId" name="categoryId" required>
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}" ${category.id == video.category.id ? 'selected' : ''}>${category.name}</option>
            </c:forEach>
        </select>
        <br/><br/>
        
        <button type="submit">${empty video ? 'Create' : 'Update'}</button>
        <a href="${pageContext.request.contextPath}/videos">Cancel</a>
    </form>
</body>
</html>