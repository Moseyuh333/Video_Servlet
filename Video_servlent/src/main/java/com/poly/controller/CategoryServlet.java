package com.poly.controller;

import com.poly.entity.Category;
import com.poly.service.CategoryService;
import com.poly.entity.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("id");
        if (categoryId != null) {
            Category category = categoryService.findById(Long.parseLong(categoryId));
            List<Video> videos = category.getVideos();
            req.setAttribute("category", category);
            req.setAttribute("videos", videos);
            req.getRequestDispatcher("/category_videos.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Category ID is required");
        }
    }
}
