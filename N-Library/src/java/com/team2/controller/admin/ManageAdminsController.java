package com.team2.controller.admin;

import com.team2.models.User;
import com.team2.service.UserService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "manageadmins", urlPatterns = {
    "/admin/manage-admin/new",
    "/admin/manage-admin/register",
    "/admin/manage-admin/delete",
    "/admin/manage-admin/edit",
    "/admin/manage-admin/update",
    "/admin/manage-admin/",
    "/admin/manage-admin/find"
})
@MultipartConfig
public class ManageAdminsController extends HttpServlet {

    private UserService userService;

    public ManageAdminsController() {
        this.userService = new UserService();
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
                case "/admin/manage-admin/new":
                    showNewForm(request, response);
                    break;
                case "/admin/manage-admin/register":
                    insertStudent(request, response);
                    break;
                case "/admin/manage-admin/delete":
                    deleteStudent(request, response);
                    break;
                case "/admin/manage-admin/edit":
                    showEditForm(request, response);
                    break;
                case "/admin/manage-admin/update":
                    updateStudent(request, response);
                    break;
                case "/admin/manage-admin/":
                    showAdmins(request, response);
                    break;
                case "/admin/manage-admin/find":
                    findStudentById(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/admin_form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userNic = request.getParameter("userNic");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        Part filePart = request.getPart("image");
        String imageFileName = filePart.getSubmittedFileName();

        // Save the image file (assuming you have a suitable image storage location)
        String uploadPath = "D:/SOFTWERE ENGENEERING/My-Projects/DEA-DietMe/web/DBImages/" + imageFileName;
        try (InputStream inputStream = filePart.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(uploadPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        User student = new User(0, firstName, lastName, userNic, imageFileName, email, phoneNumber, address, password, true, "student");
        int insertedId = userService.addUser(student);

        if (insertedId > 0) {
            request.setAttribute("status", "InsertSuccess");
        } else {
            request.setAttribute("status", "InsertFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Admin/Admin_manage/addStudent.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        boolean deleted = userService.deleteUser(userId);

        if (deleted) {
            request.setAttribute("status", "DeleteSuccess");
        } else {
            request.setAttribute("status", "DeleteFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/Admin_manage/show");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        User student = userService.showUserById(userId);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/student_form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userNic = request.getParameter("userNic");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String existingImage = request.getParameter("existingImage"); // Get the existing image

        Part filePart = request.getPart("image");
        String imageFileName = "";

        // Check if a new image is uploaded
        if (filePart != null && filePart.getSize() > 0) {
            // Save the new image
            imageFileName = filePart.getSubmittedFileName();
            String uploadPath = "D:/SOFTWERE ENGENEERING/My-Projects/DEA-DietMe/web/DBImages/" + imageFileName;
            try (InputStream inputStream = filePart.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(uploadPath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            // Use the existing image
            imageFileName = existingImage;
        }

        User student = new User(userId, firstName, lastName, userNic, imageFileName, email, phoneNumber, address, password, true, "student");
        boolean updated = userService.updateUser(student);

        if (updated) {
            request.setAttribute("status", "UpdateSuccess");
        } else {
            request.setAttribute("status", "UpdateFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/Admin_manage/edit?id=" + userId);
        dispatcher.forward(request, response);
    }

    private void showAdmins(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<User> admin = userService.showUsers("admin");
        request.setAttribute("admins", admin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/show_admins.jsp");
        dispatcher.forward(request, response);
    }
    private void findStudentById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        User student = userService.showUserById(userId);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Admin/students/displayStudents.jsp");
        dispatcher.forward(request, response);
    }
}