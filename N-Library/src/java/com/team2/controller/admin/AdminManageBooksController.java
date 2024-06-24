/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.controller.admin;

import com.team2.models.Books;
import com.team2.service.BookService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author asus
 */
@WebServlet(name = "AdminBookController", urlPatterns = {
    "/admin/book/new",
    "/admin/book/register",
    "/admin/book/delete",
    "/admin/book/edit",
    "/admin/book/update",
    "/admin/book/",
    "/admin/book/find"
})
public class AdminManageBooksController extends HttpServlet {

     private BookService bookService;

    public AdminManageBooksController() {
        this.bookService = new BookService();
    }
    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminManageBooksController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminManageBooksController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        String action = request.getServletPath();

        try {
            switch (action) {
//                case "/admin/book/new":
//                    showNewForm(request, response);
//                    break;
                case "/admin/books/addBook":
                    addBook(request, response);
                    break;
                case "/admin/books/delete":
                    deleteBook(request, response);
                    break;
                case "/admin/books/edit":
                    showEditBook(request, response);
                    break;
                case "/admin/books/update":
                    updateBook(request, response);
                    break;
                case "/admin/bookcategories/":
                    showBook(request, response);
                    break;
                case "/admin/books/search":
                    findBookByIdOrName(request, response);
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

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
             String title=request.getParameter("title");
             String bookId = request.getParameter("bookId");
             String author = request.getParameter("author");
             int catergory = Integer.parseInt(request.getParameter("category"));
             int quantity = Integer.parseInt(request.getParameter("quantity"));
             String description = request.getParameter("description");
             String ImgUrl = "";
             
               
             Part file = null;
             RequestDispatcher dispatcher;
               try {
                 Part BookPic = request.getPart("image");
                 if (BookPic != null && BookPic.getSize() > 0) {
                 String fileName = BookPic.getSubmittedFileName();
                 String savePath = "C:\\Users\\asus\\Desktop\\Git\\N-Library\\web\\book image\\" + fileName;
                   String uploadPath;
                   try (FileOutputStream fos = new FileOutputStream(savePath);
                             InputStream is = BookPic.getInputStream()) {
                             byte[] data = new byte[is.available()];
                             is.read(data);
                             fos.write(data);
         //                    out.println("Image successfully saved in folder location.");
                         }
                  ImgUrl = fileName; // Update image URL
                 }
              } catch (IOException | ServletException e) {
                       request.setAttribute("message", e.getMessage());
                         dispatcher = request.getRequestDispatcher("admin_products.jsp");
                        dispatcher.forward(request, response);// Handle the exception appropriately
              }
              Books books = new Books(title,bookId,author,catergory,quantity,description,ImgUrl,true);
              int row = bookService.InsertBook(books);
              
              if (row > 0){
                 request.setAttribute("status", "InsertSuccess");
              }else{
                 request.setAttribute("status","InsertFailed");
              }
              
              dispatcher = request.getRequestDispatcher("/views/Admin/books/adminAddBooks.jsp"); // Update with your actual JSP
              dispatcher.forward(request, response);
             
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
         int id = Integer.parseInt(request.getParameter("bookId"));
        
         Boolean state = bookService.DeleteBook(id);
         
         if(state){
            request.setAttribute("status","Delete Successfully");
         }else{
            request.setAttribute("status","Delete Unsuccessfully");
         }
         
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminAddBooks.jsp"); // Update with your actual JSP
        dispatcher.forward(request, response);
                
    }

    
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("bookId"));
        String title=request.getParameter("title");
        String bookId = request.getParameter("bookId");
        String author = request.getParameter("author");
        int catergory = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        Boolean available = Boolean.parseBoolean(request.getParameter("available"));
        String oldImage = request.getParameter("old_image");
        
         String ImgUrl = "";
             
               
             Part file = null;
             RequestDispatcher dispatcher;
               try {
                 Part BookPic = request.getPart("image");
                 if (BookPic != null && BookPic.getSize() > 0) {
                 String fileName = BookPic.getSubmittedFileName();
                 String savePath = "C:\\Users\\asus\\Desktop\\Git\\N-Library\\web\\book image\\" + fileName;
                   String uploadPath;
                   try (FileOutputStream fos = new FileOutputStream(savePath);
                             InputStream is = BookPic.getInputStream()) {
                             byte[] data = new byte[is.available()];
                             is.read(data);
                             fos.write(data);
         //                    out.println("Image successfully saved in folder location.");
                         }
                  ImgUrl = fileName; // Update image URL
                 }
                 else{
                   ImgUrl=oldImage;
                 
                 }
              } catch (IOException | ServletException e) {
                       request.setAttribute("message", e.getMessage());
                         dispatcher = request.getRequestDispatcher("admin_products.jsp");
                        dispatcher.forward(request, response);// Handle the exception appropriately
              }
        
        
        
        
        
        
      
       Books books = new Books(title,bookId,author,catergory,quantity,description,ImgUrl,available);
       int state = bookService.UpdateBook(id,books);
       
       if(state>0){
         request.setAttribute("status","Update Successfully");
        }else{
         request.setAttribute("status","Update Un successfully");
       }
       
       dispatcher=request.getRequestDispatcher("/views/Admin/books/adminEditBooks.jsp");
       dispatcher.forward(request, response);    
        
       
    
       
 
   }
    
    
    
    
    private void showEditBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
       String id = request.getParameter("id");
        int bid = Integer.parseInt(id);
        Books books = bookService.showBookById(bid);
        request.setAttribute("bookCategory", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/bookcategories/bookcategory_form.jsp");
        dispatcher.forward(request, response);
        
    }

   

    private void showBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Books> books = bookService.showBook();
        request.setAttribute("bookCategories", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminbook.jsp");
        dispatcher.forward(request, response);
        
        
    }

    private void findBookByIdOrName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String bookD = request.getParameter("bookD");
      
        Books book = bookService.showBookByIdOrName(bookD);
        request.setAttribute("bookCategory", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminSearchBook.jsp"); // Update with your actual JSP
        dispatcher.forward(request, response);
    }

}