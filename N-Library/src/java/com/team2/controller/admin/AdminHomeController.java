/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.controller.admin;

import com.team2.models.BookCategories;
import com.team2.models.User;
import com.team2.service.BookCategoryService;
import com.team2.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kavin
 */
@WebServlet(name = "AdminHome", urlPatterns = {"/admin/home"})
public class AdminHomeController extends HttpServlet {
    
    private  UserService userService;
    private  BookCategoryService bookCategoryService;
    
    public AdminHomeController(){
      this.userService = new UserService();
      this.bookCategoryService = new BookCategoryService();
      
    }

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         List<User> admins = userService.showUsers("admin");
         List<User> students = userService.showUsers("student");
         List<BookCategories> categories = bookCategoryService.showBookCategories();
         
         
         int number_of_students = students.size(); 
         int number_of_admins = admins.size();
         int number_of_categories = categories.size();
         
         request.setAttribute("number_of_students", number_of_students);
         request.setAttribute("number_of_admins", number_of_admins);
         request.setAttribute("number_of_categories", number_of_categories);

         RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/home/home.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
