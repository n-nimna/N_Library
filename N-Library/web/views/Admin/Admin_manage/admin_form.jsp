<%@page import="com.team2.controller.utill.assetsUrl"%>
<%@page import="com.team2.models.User"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>N-Library Dashboard || Manage Students</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>" />

    <style>

    </style>
</head>

<body>
    <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

    <div class="content">
        <div class="adminName">
            <h2>Kavindu kaveesha</h2>
        </div>

        <div class="container form-container mt-5 p-3">
            <div class="row">
                <div class="col-md-6" style="display: flex;">
                    <h2>${student != null ? 'Update Admin Data' : 'Admin Registration'}</h2>
                    <% if (request.getAttribute("admin") == null) { %>
                    <a class="btn btn-primary" href="new" style="margin: 2% 2%">New Admin</a>
                    <% } %>
                </div>
                <div class="col-md-6 text-right">
                    <a class="btn btn-dark" href="${pageContext.request.contextPath}/admin/manage-admin/"
                        style="margin: 2% 0">All Admins</a>
                </div>
            </div>
            <form action="${admin != null ? 'update' : 'register'}" method="post" enctype="multipart/form-data">
                <input type="hidden" value="${admin != null ? admin.userId : ''}" name="userId">
                <div class="row">
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="firstName">First Name:</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" required
                                        value="${admin != null ? admin.firstName : ''}">
                                    <span class="error" id="firstNameError">${firstNameError}</span>
                                </div>

                                <div class="form-group">
                                    <label for="lastName">Last Name:</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" required
                                        value="${admin != null ? admin.lastName : ''}">
                                    <span class="error" id="lastNameError">${lastNameError}</span>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <%
                                    String imageUrlDB = null;
                                    if (request.getAttribute("admin") != null) {
                                        User admin = (User) request.getAttribute("admin");
                                        imageUrlDB = admin.getImage();
                                    }
                                %>
                                <% if (imageUrlDB != null) { %>
                                <img src="<%= assetsUrl.giveUrl(request, "DBImages/") + imageUrlDB%>"
                                    style="width:5rem;height:5rem; margin-top: 10px;" id="previewImage"
                                    alt="Preview">
                                <% } %>
                                <input type="hidden" name="dbImage" value="<%=imageUrlDB%>">
                                <div class="form-group">
                                    <label for="image">${student != null ? 'Update Image' : 'Add new Image'}</label>
                                    <input type="file" class="form-control-file" id="image" name="image"
                                        accept="image/*">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="userNic">NIC:</label>
                            <input type="text" class="form-control" id="userNic" name="userNic" required
                                value="${admin != null ? admin.userNic : ''}">
                            <span class="error" id="nicError">${nicError}</span>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" required
                                value="${admin != null ? admin.email : ''}">
                            <span class="error" id="emailError">${emailError}</span>
                        </div>

                        <div class="form-group">
                            <label for="phoneNumber">Phone Number:</label>
                            <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required
                                value="${admin != null ? admin.phoneNumber : ''}">
                            <span class="error" id="phoneNumberError">${phoneNumberError}</span>
                        </div>

                        <div class="form-group">
                            <label for="address">Address:</label>
                            <textarea class="form-control" id="address" name="address"
                                required>${admin != null ? admin.address : ''}</textarea>
                            <span class="error" id="addressError">${addressError}</span>
                        </div>

                        <input type="hidden" name="userId" value="${admin != null ? admin.userId : 0}">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">${admin != null ? 'Update Admin' : 'Add Admin'}</button>
            </form>

            <div class="mt-3" id="message">

            </div>

        </div>

    </div>

    <input type="hidden" id="status" value="${status}">
    <input type="hidden" id="email" value="${email}">
    <input type="hidden" id="password" value="${password}">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <script>
        var status = "${status}";

        if (status === "InsertSuccess") {
            var email = "${email}";
            var password = "${password}";

            document.getElementById("message").innerHTML =
                "<p class='success'>Admin added successfully!</p>" +
                "<p>Email: " + email + "</p>" +
                "<p>Password: " + password + "</p>";
        } else if (status === "InsertFailed") {
            document.getElementById("message").innerHTML =
                "<p class='error'>Failed to add Admin. Please try again.</p>";
        } else if (status === "UpdateSuccess") {
            document.getElementById("message").innerHTML =
                "<p class='success'>Successfully update Admin.</p>";
        } else if (status === "UpdateFailed") {
            document.getElementById("message").innerHTML =
                "<p class='error'>Failed to update Admin. Please try again.</p>";
        }
    </script>
</body>

</html>
