package com.team2.controller.admin;

import com.team2.utill.PasswordGenarator;
import com.team2.models.User;
import com.team2.service.UserService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
    "/admin/manage-admin/changeStatus"
})
@MultipartConfig
public class ManageAdminsController extends HttpServlet {

    private UserService userService;

    public ManageAdminsController() {
        this.userService = new UserService();
    }

    private static final String UPLOAD_PATH = "D:/SOFTWERE ENGENEERING/my programing/Java/Java EE/N_Library/N-Library/web/DBImages/";

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
                    insertAdmin(request, response);
                    break;
                case "/admin/manage-admin/delete":
                    deleteAdmin(request, response);
                    break;
                case "/admin/manage-admin/edit":
                    showEditForm(request, response);
                    break;
                case "/admin/manage-admin/update":
                    updateAdmin(request, response);
                    break;
                case "/admin/manage-admin/":
                    showAdmins(request, response);
                    break;
                case "/admin/manage-admin/changeStatus":
                    changeStatus(request, response);
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

    //    show all admins
    private void showAdmins(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<User> admins = userService.showUsers("admin");
        request.setAttribute("admins", admins);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/show_admins.jsp");
        dispatcher.forward(request, response);
    }

//    show add new admin form
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/views/Admin/Admin_manage/admin_form.jsp");
        dispatcher.forward(request, response);
    }

//        add new admin method
    private void insertAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

//        get user inputs
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userNic = request.getParameter("userNic");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String password = PasswordGenarator.generatePassword(firstName, userNic);

// Check for null or empty values
        if (firstName == null || firstName.isEmpty()
                || userNic == null || userNic.isEmpty()
                || email == null || email.isEmpty()
                || phoneNumber == null || phoneNumber.isEmpty()
                || address == null || address.isEmpty()) {
            request.setAttribute("status", "InsertFailed");
            request.setAttribute("error", "Please fill in all required fields.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/admin_form.jsp");
            dispatcher.forward(request, response);
            return;
        }
// Check for null or empty values

//        upload image
        Part filePart = request.getPart("image");
        String imageFileName = null;
        String defaultImageFileName = "default_user.png";

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
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/admin_form.jsp");
                dispatcher.forward(request, response);
                return;
            }
        } else {
            imageFileName = defaultImageFileName;
        }

//        end of upload image
//upload data to databse
        User student = new User(0, firstName, lastName, userNic, imageFileName,
                email, phoneNumber, address, password, true, "admin");
        int insertedId = userService.addUser(student);
//upload data to databse

// get success message or error message
        if (insertedId > 0) {
            // Success! Set the status and data in the request
            request.setAttribute("status", "InsertSuccess");
            request.setAttribute("email", student.getEmail());
            request.setAttribute("password", student.getPassword());
        } else {
            // Failure. Set the status.
            request.setAttribute("status", "InsertFailed");
        }

        // Forward to the JSP
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/views/Admin/Admin_manage/admin_form.jsp");
        dispatcher.forward(request, response);
    }

//show update student form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        User admin = userService.showUserById(userId);
        request.setAttribute("admin", admin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/admin_form.jsp");
        dispatcher.forward(request, response);
    }

// update student
    private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("userId");
        int userId = Integer.parseInt(id);

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userNic = request.getParameter("userNic");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
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
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/Admin_manage/admin_form.jsp");
                dispatcher.forward(request, response);
                return;
            }
        } else {
            imageFileName = dbImage;
        }

        User student = new User(firstName, lastName, userNic, imageFileName, email, phoneNumber, address, userId);
        boolean updated = userService.updateUser(student);

        if (updated) {
            request.setAttribute("status", "UpdateSuccess");
        } else {
            request.setAttribute("status", "UpdateFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/manage-admin/edit?id=" + userId);

        dispatcher.forward(request, response);
    }

    private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("adminId");
        int userId = Integer.parseInt(id);

        boolean deleted = userService.deleteUser(userId);

        if (deleted) {
            request.setAttribute("status", "DeleteSuccess");
        } else {
            request.setAttribute("status", "DeleteFailed");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/manage-admin/");
        dispatcher.forward(request, response);
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("adminId"));
        PrintWriter out = response.getWriter();
        boolean success;

        if (userService.isActive(id)) {
            success = userService.disableUser(id);
            out.print(userService.isActive(id));

        } else {
            success = userService.enableUser(id);
            out.print("error");
        }

        if (success) {
            request.setAttribute("status", "updateStatus");
            request.setAttribute("message", "Admin status updated successfully.");
        } else {
            request.setAttribute("status", "errorUpdateStatus");
            request.setAttribute("message", "Failed to update Admin status.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/manage-admin/");
        dispatcher.forward(request, response);
    }

}
