package com.team2.controller.admin;

import com.team2.controller.utill.RamdomBookIdGenarator;
import com.team2.models.BookCategories;
import com.team2.models.Books;
import com.team2.service.BookCategoryService;
import com.team2.service.BookService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "BookController", urlPatterns = {
    "/admin/books/new",
    "/admin/books/addnew",
    "/admin/books/delete",
    "/admin/books/edit",
    "/admin/books/update",
    "/admin/books/",
    "/admin/books/find",
    "/admin/books/findById",
})
@MultipartConfig
public class AdminBookController extends HttpServlet {

    private BookService bookService;
    private BookCategoryService categoryService;

//    folder path
    private static final String UPLOAD_PATH = "D:/SOFTWERE ENGENEERING/my programing/Java/Java EE/N_Library/N-Library/web/DBImages/";

    public AdminBookController() {
        this.bookService = new BookService();
        this.categoryService = new BookCategoryService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/admin/books/new":
                    showNewForm(request, response);
                    break;
                case "/admin/books/addnew":
                    insertBook(request, response);
                    break;
                case "/admin/books/delete":
                    deleteBook(request, response);
                    break;
                case "/admin/books/edit":
                    showEditForm(request, response);
                    break;
                case "/admin/books/update":
                    updateBook(request, response);
                    break;
                case "/admin/books/":
                    showBooks(request, response);
                    break;
                 case "/admin/books/findById":
                    showBookById(request, response);
                    break;    
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // show all books
    private void showBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<Books> books = bookService.showBooks();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminBook.jsp");
        dispatcher.forward(request, response);
    }

    // show add new book form
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<BookCategories> categories = categoryService.showBookCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminAddBook.jsp");
        dispatcher.forward(request, response);
    }

    // add new book method
    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        // get user inputs
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String bookId = RamdomBookIdGenarator.generateBookId(title, categoryId);

        // Check for null or empty values
        if (title == null || title.isEmpty()
                || bookId == null || bookId.isEmpty()
                || author == null || author.isEmpty()
                || description == null || description.isEmpty()) {
            request.setAttribute("status", "InsertFailed");
            request.setAttribute("error", "Please fill in all required fields.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminAddBook.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // upload image
        Part filePart = request.getPart("image");
        String imageFileName = null;
        String defaultImageFileName = "default_book.png";

        if (filePart != null && filePart.getSize() > 0) {
            imageFileName = filePart.getSubmittedFileName();
            String imageFilePath = UPLOAD_PATH + imageFileName;

            try (InputStream inputStream = filePart.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(imageFilePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                // Handle the error gracefully (e.g., log it and send an error response)
                request.setAttribute("status", "InsertFailed");
                request.setAttribute("error", "Error uploading image: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminAddBook.jsp");
                dispatcher.forward(request, response);
                return;
            }
        } else {
            imageFileName = defaultImageFileName;
        }

        // end of upload image
        // upload data to database
        Books book = new Books(title, bookId, author, categoryId, quantity, description, imageFileName, true);
        int insertedId = bookService.addBook(book);

        // get success message or error message
        if (insertedId > 0) {
            request.setAttribute("status", "InsertSuccess");

        } else {
            // Failure. Set the status.
            request.setAttribute("status", "InsertFailed");
        }

        // Forward to the JSP
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/views/Admin/books/adminAddBook.jsp");
        dispatcher.forward(request, response);
    }

    // show update book form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int bookId = Integer.parseInt(id);
        Books book = bookService.showBookById(bookId);
        request.setAttribute("book", book);
        List<BookCategories> categories = categoryService.showBookCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminAddBook.jsp");
        dispatcher.forward(request, response);
    }

    // update book
    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String dbImage = request.getParameter("dbImage");

        Part filePart = request.getPart("image");
        String imageFileName = null;

        if (filePart != null && filePart.getSize() > 0) {
            imageFileName = filePart.getSubmittedFileName();
            String imageFilePath = UPLOAD_PATH + imageFileName;

            try (InputStream inputStream = filePart.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(imageFilePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                // Handle the error gracefully (e.g., log it and send an error response)
                request.setAttribute("status", "InsertFailed");
                request.setAttribute("error", "Error uploading image: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/books/adminAddBook.jsp");
                dispatcher.forward(request, response);
                return;
            }
        } else {
            imageFileName = dbImage;
        }

        Books book = new Books(id, title, author, categoryId, quantity, description, imageFileName, true);
        boolean updated = bookService.updateBook(book);

        if (updated) {
            request.setAttribute("status", "UpdateSuccess");
        } else {
            request.setAttribute("status", "UpdateFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/books/edit?id=" + id);

        dispatcher.forward(request, response);
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("bookId");
        int bookId = Integer.parseInt(id);

        boolean deleted = bookService.deleteBook(bookId);

        if (deleted) {
            request.setAttribute("status", "DeleteSuccess");
        } else {
            request.setAttribute("status", "DeleteFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/books/");
        dispatcher.forward(request, response);
    }

    private void showBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        Books book = bookService.showBookByBid(id);
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/barrowed_book/barrowed_book.jsp");
        dispatcher.forward(request, response);
    }

}
