package com.poly.service;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public void create(Category category) {
        categoryDAO.create(category);
    }

    public Category findById(Long id) {
        return categoryDAO.findById(id);
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    public void update(Category category) {
        categoryDAO.update(category);
    }

    public void delete(Category category) {
        categoryDAO.delete(category);
    }

    public long countVideosByCategory(Long categoryId) {
        // Implement count videos by category
        Category category = findById(categoryId);
        return category != null ? category.getVideos().size() : 0;
    }
}
