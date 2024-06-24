/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.controller.auth;

import com.team2.models.User;
import com.team2.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kavin
 */
@WebServlet(name = "AuthController", urlPatterns = {"/login"})
public class AuthController extends HttpServlet {

    private UserService userService;

    public AuthController() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/login_form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if (userService.loginUser(email, password, session)) {
            User user = (User) session.getAttribute("loggedInUser");
            String userType = user.getUserType();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getFirstName() + " " + user.getLastName());
            session.setAttribute("userImage", user.getImage());

            if ("student".equalsIgnoreCase(userType)) {
                request.setAttribute("status", "loginSuccess");
                response.sendRedirect("/N-Library/student/home");

            } else if ("admin".equalsIgnoreCase(userType)) {
                request.setAttribute("status", "loginSuccess");
                response.sendRedirect("/N-Library/admin/home");

            } else {
                request.setAttribute("status", "loginError");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/login_form.jsp");
                dispatcher.forward(request, response);

            }
        } else {
            request.setAttribute("status", "loginError");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/login_form.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
