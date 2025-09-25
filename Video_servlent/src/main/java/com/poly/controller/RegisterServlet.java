package com.poly.controller;

import com.poly.entity.User;
import com.poly.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            req.setAttribute("error", "Passwords do not match");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            req.setAttribute("error", "Username already exists");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        User user = new User(username, password, "USER");
        userService.create(user);
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
