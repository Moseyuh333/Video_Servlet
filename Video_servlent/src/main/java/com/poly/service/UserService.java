package com.poly.service;

import com.poly.dao.UserDAO;
import com.poly.entity.User;
import com.poly.util.PasswordUtil;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void create(User user) {
        // Hash password before saving
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        userDAO.create(user);
    }

    public User findById(Long id) {
        return userDAO.findById(id);
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user != null && PasswordUtil.verifyPassword(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }
}
