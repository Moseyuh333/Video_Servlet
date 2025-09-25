<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<sitemesh:decorate name="user">
    <sitemesh:title>Chi tiết Video</sitemesh:title>
    <div>
        <img src="${video.poster}" alt="${video.title}" />
        <h2>Tiêu đề: ${video.title}</h2>
        <p>Mã video: ${video.code}</p>
        <p>Category name: ${video.category.name}</p>
        <p>View: ${video.views}</p>
        <p>Share: <button onclick="shareVideo()">${video.shares}</button></p>
        <p>Like: <button onclick="likeVideo()">${video.likes}</button></p>
        <p>Description: ${video.description}</p>
    </div>
    <script>
        function shareVideo() {
            // Implement share logic
            alert('Shared!');
        }
        function likeVideo() {
            // Implement like logic
            alert('Liked!');
        }
    </script>
</sitemesh:decorate>
