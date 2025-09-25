package com.poly.service;

import com.poly.dao.VideoDAO;
import com.poly.entity.Video;
import java.util.List;

public class VideoService {
    private VideoDAO videoDAO = new VideoDAO();

    public void create(Video video) {
        videoDAO.create(video);
    }

    public Video findById(Long id) {
        return videoDAO.findById(id);
    }

    public List<Video> findAll() {
        return videoDAO.findAll();
    }

    public List<Video> findAll(int page, int size) {
        // Fixed: More efficient pagination implementation
        return videoDAO.findWithPagination(page, size);
    }

    public void update(Video video) {
        videoDAO.update(video);
    }

    public void delete(Video video) {
        videoDAO.delete(video);
    }

    public long count() {
        return videoDAO.count();
    }
}
