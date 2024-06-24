/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.controller.admin;

import com.team2.models.BarrowedBooks;
import com.team2.service.BarrowedBooksService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminBarrowBookController", urlPatterns = {
    "/admin/barrowbooks/new",
    "/admin/barrowbooks/delete",
    "/admin/barrowbooks/shows",
    "/admin/barrowbooks/search"
})

public class AdminManageBarrowedBooksController extends HttpServlet {
    private BarrowedBooksService barrowedbookService;

    public AdminManageBarrowedBooksController() {
        this.barrowedbookService = new BarrowedBooksService();
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminManageBarrowedBooks</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminManageBarrowedBooks at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String action = request.getServletPath();

        try {
            switch (action) {
                case "/admin/barrowbooks/new":
                    addbarrowedBook(request, response);
                    break;
                case "/admin/barrowbooks/delete":
                    deleteBarrowedBook(request, response);
                    break;
                case "/admin/barrowbooks/shows":
                    showBarrowedBook(request, response);
                    break;
 
                case "/admin/barrowbooks/search":
                    findBarrowedBookByBookId(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     doGet(request,response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void addbarrowedBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
             String bookId = request.getParameter("bookId");
             int userId = Integer.parseInt(request.getParameter("userId"));
            String barrowDateString = request.getParameter("barrowDate"); // Ensure the parameter name matches the form input name
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format as needed
            Date barrowDate = null;
            try {
               barrowDate = dateFormat.parse(barrowDateString);
            } catch (ParseException e) {
                e.printStackTrace();
                // Handle the exception
            }
            String returnDateString = request.getParameter("returnDate");
            Date returnDate = null;
            try {
               returnDate = dateFormat.parse(returnDateString );
            } catch (ParseException e) {
                e.printStackTrace();
                // Handle the exception
            }
            
            BarrowedBooks barrowbooks = new BarrowedBooks(userId,bookId,barrowDate,returnDate);
            
            int row = barrowedbookService.addBarrowBook(barrowbooks);
            
            if(row>0){
               request.setAttribute("massage","add barrowed book suceessfully");
            }else{
              
               request.setAttribute("massage","add barrowed book unsuceessfully");
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/barrowed_books/baroowes_book.jsp");
            dispatcher.forward(request, response);
        
    }

    private void deleteBarrowedBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        
         Boolean state = barrowedbookService.deleteBarrowBook(id);
         
         if(state){
            request.setAttribute("status","Delete Successfully");
         }else{
            request.setAttribute("status","Delete Unsuccessfully");
         }
         
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/barrowed_books/barrowed_books.jsp"); // Update with your actual JSP
        dispatcher.forward(request, response);
    }

    private void showBarrowedBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BarrowedBooks> book = barrowedbookService.showBarrowedBook();
        request.setAttribute("bookCategories", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/barrowed_books/display_barrowed_books.jsp");
        dispatcher.forward(request, response);
    }

  

    private void findBarrowedBookByBookId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String bookId = request.getParameter("bookId");
      
        BarrowedBooks book = barrowedbookService.showBarrowedBookByBookId(bookId);
        request.setAttribute("bookCategory", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/barrowed_books/display_barrowed_books.jsp"); // Update with your actual JSP
        dispatcher.forward(request, response);
    }
    
    
    

}
