package com.team2.controller.admin;

import com.team2.models.BookCategories;
import com.team2.service.BookCategoryService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminBookCategoryController", urlPatterns = {
    "/admin/bookcategories/new",
    "/admin/bookcategories/register",
    "/admin/bookcategories/delete",
    "/admin/bookcategories/edit",
    "/admin/bookcategories/update",
    "/admin/bookcategories/",
    "/admin/bookcategories/find"
})
public class AdminManageBooksCategoriesController extends HttpServlet {

    private BookCategoryService bookCategoryService;

    public AdminManageBooksCategoriesController() {
        this.bookCategoryService = new BookCategoryService();
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
                case "/admin/bookcategories/new":
                    showNewForm(request, response);
                    break;
                case "/admin/bookcategories/register":
                    insertBookCategory(request, response);
                    break;
                case "/admin/bookcategories/delete":
                    deleteBookCategory(request, response);
                    break;
                case "/admin/bookcategories/edit":
                    showEditForm(request, response);
                    break;
                case "/admin/bookcategories/update":
                    updateBookCategory(request, response);
                    break;
                case "/admin/bookcategories/":
                    showBookCategories(request, response);
                    break;
                case "/admin/bookcategories/find":
                    findBookCategoryById(request, response);
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

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/bookcategories/bookcategory_form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBookCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String categoryName = request.getParameter("categoryName");

        BookCategories bookCategory = new BookCategories(0, categoryName);
        int insertedId = bookCategoryService.addBookCategory(bookCategory);

        if (insertedId > 0) {
            request.setAttribute("status", "InsertSuccess");
        } else {
            request.setAttribute("status", "InsertFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/bookcategories/addBookCategory.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBookCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int bcId = Integer.parseInt(id);

        boolean deleted = bookCategoryService.deleteBookCategory(bcId);

        if (deleted) {
            request.setAttribute("status", "DeleteSuccess");
        } else {
            request.setAttribute("status", "DeleteFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/bookcategories/show");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int bcId = Integer.parseInt(id);
        BookCategories bookCategory = bookCategoryService.showBookCategoryById(bcId);
        request.setAttribute("bookCategory", bookCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/bookcategories/bookcategory_form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBookCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int bcId = Integer.parseInt(id);

        String categoryName = request.getParameter("categoryName");

        BookCategories bookCategory = new BookCategories(bcId, categoryName);
        boolean updated = bookCategoryService.updateBookCategory(bookCategory);

        if (updated) {
            request.setAttribute("status", "UpdateSuccess");
        } else {
            request.setAttribute("status", "UpdateFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/bookcategories/edit?id=" + bcId);
        dispatcher.forward(request, response);
    }

    private void showBookCategories(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<BookCategories> bookCategories = bookCategoryService.showBookCategories();
        request.setAttribute("bookCategories", bookCategories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Books_Categories/show_bookcategories.jsp");
        dispatcher.forward(request, response);
    }

    private void findBookCategoryById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int bcId = Integer.parseInt(id);
        BookCategories bookCategory = bookCategoryService.showBookCategoryById(bcId);
        request.setAttribute("bookCategory", bookCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Admin/bookcategories/displayBookCategories.jsp");
        dispatcher.forward(request, response);
    }
}
