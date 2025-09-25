package com.poly.controller;

import com.poly.entity.Video;
import com.poly.entity.Category;
import com.poly.service.VideoService;
import com.poly.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/videos")
public class VideoServlet extends HttpServlet {
    private VideoService videoService = new VideoService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                listVideos(req, resp);
                break;
            case "detail":
                showVideoDetail(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteVideo(req, resp);
                break;
            default:
                listVideos(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("create".equals(action)) {
            createVideo(req, resp);
        } else if ("update".equals(action)) {
            updateVideo(req, resp);
        } else {
            doGet(req, resp);
        }
    }

    private void listVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int page = Integer.parseInt(req.getParameter("page") != null ? req.getParameter("page") : "0");
            int size = 6;
            List<Video> videos = videoService.findAll(page, size);
            req.setAttribute("videos", videos);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", (videoService.count() + size - 1) / size);
            req.getRequestDispatcher("/video_list.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid page number");
        }
    }

    private void showVideoDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Video video = videoService.findById(id);
        if (video != null) {
            video.setViews(video.getViews() + 1);
            videoService.update(video);
            req.setAttribute("video", video);
            req.getRequestDispatcher("/video_detail.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Video video = videoService.findById(id);
        List<Category> categories = categoryService.findAll();
        req.setAttribute("video", video);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/video_form.jsp").forward(req, resp);
    }

    private void createVideo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = req.getParameter("title");
        String code = req.getParameter("code");
        String description = req.getParameter("description");
        String poster = req.getParameter("poster");
        Long categoryId = Long.parseLong(req.getParameter("categoryId"));
        Category category = categoryService.findById(categoryId);

        Video video = new Video(title, code, description, poster, category);
        videoService.create(video);
        resp.sendRedirect(req.getContextPath() + "/videos");
    }

    private void updateVideo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String code = req.getParameter("code");
        String description = req.getParameter("description");
        String poster = req.getParameter("poster");
        Long categoryId = Long.parseLong(req.getParameter("categoryId"));
        Category category = categoryService.findById(categoryId);

        Video video = videoService.findById(id);
        video.setTitle(title);
        video.setCode(code);
        video.setDescription(description);
        video.setPoster(poster);
        video.setCategory(category);
        videoService.update(video);
        resp.sendRedirect(req.getContextPath() + "/videos");
    }

    private void deleteVideo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Video video = videoService.findById(id);
        if (video != null) {
            videoService.delete(video);
        }
        resp.sendRedirect(req.getContextPath() + "/videos");
    }
}
