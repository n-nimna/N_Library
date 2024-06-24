/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DbDAO;
import DAO.ctDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Model;
import model.Model1;

/**
 *
 * @author 94781
 */
@WebServlet(name = "Controller", urlPatterns = {"/"})
public class Controller extends HttpServlet {
    private DbDAO dbDAO;
    private ctDAO ctDAO;
    
    @Override
    public void init(){
        dbDAO = new DbDAO();
        ctDAO = new ctDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            switch(action){
                case "/new":
                    listCategory(request, response);
                    break;
                case "/delete":
                    deleteCategory(request, response);
                    break;
                case "/edit":
                    showBarrowed(request, response);
                    break;
                case "/details":
                    showBook(request, response);
                    break;
                default:
                    showBookDetails(request, response);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void showBookDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Model> showBookDetails = dbDAO.selectAllBooks();
        request.setAttribute("showBookDetails", showBookDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("categoryId"));
        ctDAO.deleteCategory(id);
        response.sendRedirect(request.getContextPath() + "/new");
    }

    private void showBarrowed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Model> showBarrowed = dbDAO.selectAllBarrowed();
        request.setAttribute("showBarrowed", showBarrowed);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/borrowed.jsp");
        dispatcher.forward(request, response);
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Model1> listCategory = ctDAO.selectAllCategory();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin.jsp");
        dispatcher.forward(request, response);
    }

    private void showBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Model existingModel = dbDAO.selectBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book.jsp");
        request.setAttribute("todo", existingModel);
        dispatcher.forward(request, response);
    }

}
