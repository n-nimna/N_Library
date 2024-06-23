<%@page import="java.util.List"%>
<%@page import="com.team2.controller.utill.assetsUrl"%>
<%@page import="com.team2.models.User"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library Dashboard || Manage Admins</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>" />
      
    </head>

    <body>
        <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>
        <div class="content">
            <div class="adminName">
                <h2>Kavindu Kaveesha</h2>
            </div>
            <div id="message" class="container-fluid"></div>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-6">
                        <h2 class="mb-4">Admin Details</h2>
                    </div>
                    <div class="col-6 d-flex justify-content-end mb-4">
                        <a href="${pageContext.request.contextPath}/admin/manage-admin/" class="btn btn-outline-secondary">Refresh</a>
                        <a href="new" class="btn btn-success ml-2">Add New Admin</a>
                    </div>
                </div>
                <% List<User> admins = (List<User>) request.getAttribute("admins");%>
                <p>All Admins (<%=admins.size()%>)</p>

                <% if (admins != null && !admins.isEmpty()) { %>
                <table class="table table-hover table-striped">
                    <thead class="thead-light">
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Profile Image</th>
                            <th>NIC</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Address</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% int count = 1; %>
                        <% for (User admin : admins) {%>
                        <tr style="border-bottom: 1px solid #222222;">
                            <td><%= count++%></td>
                            <td class="truncate"><%= admin.getFirstName()%></td>
                            <td class="truncate"><%= admin.getLastName()%></td>

                            <td>
                                <img src="<%= assetsUrl.giveUrl(request, "DBImages/") + admin.getImage()%>"
                                     style="width:5rem;height:5rem">
                            </td>
                            <td ><%= admin.getUserNic()%></td>
                            <td class="truncate"><%= admin.getEmail()%></td>
                            <td ><%= admin.getPhoneNumber()%></td>
                            <td class="truncate"><%= admin.getAddress()%></td>
                            <td>
                                <a href="#" onclick="return changeStatus('<%= admin.getUserId()%>');"
                                   class="<%= admin.isActive() ? "btn btn-success" : "btn btn-danger"%>"
                                   style="width: 3rem; font-size: .5rem; font-weight: bold;">
                                    <%= admin.isActive() ? "Active" : "Disable"%>
                                </a>
                            </td>
                            <td>
                                <a href="edit?id=<%= admin.getUserId()%>" class="btn btn-primary"
                                   style="width: 3.5rem; font-size: .5rem">Edit</a>
                                <a href="#" onclick="return confirmDelete('<%= admin.getUserId()%>');"
                                   class="btn btn-danger" style="width: 3.5rem; font-size: .5rem">Delete</a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% } else { %>
                <div class="alert alert-info" role="alert">
                    No Admins found.
                </div>
                <% }%>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
                                    function confirmDelete(adminId) {
                                        // Display a confirmation dialog using SweetAlert
                                        swal({
                                            title: "Are you sure?",
                                            text: "Once deleted, you will not be able to recover this admin!",
                                            icon: "warning",
                                            buttons: true,
                                            dangerMode: true,
                                        }).then(function (willDelete) {
                                            if (willDelete) {
                                                // Redirect to the delete action with the admin ID
                                                window.location.href = "<%= request.getContextPath()%>/admin/manage-admin/delete?adminId=" + adminId;
                                            } else {
                                                // Do nothing if the user cancels
                                            }
                                        });
                                        // Return false to prevent the default link action
                                        return false;
                                    }

                                    // Function to change admin status
                                    function changeStatus(adminId) {
                                        // Display a confirmation dialog using SweetAlert
                                        swal({
                                            title: "Are you sure?",
                                            text: "Are you sure you want to change the status of the admin?",
                                            icon: "warning",
                                            buttons: true,
                                            dangerMode: true,
                                        }).then(function (willChange) {
                                            if (willChange) {
                                                // Redirect to the changeStatus action with the admin ID
                                                window.location.href = "<%= request.getContextPath()%>/admin/manage-admin/changeStatus?adminId=" + adminId;
                                            } else {
                                                // Do nothing if the user cancels
                                            }
                                        });
                                        // Return false to prevent the default link action
                                        return false;
                                    }

                                    // Error handling based on server-side status
                                    var status = "<%= request.getAttribute("status")%>";
                                    var messageGet = "<%= request.getAttribute("message")%>";

                                    if (status === "DeleteSuccess") {
                                        document.getElementById("message").innerHTML = "<p class='success'>Admin deleted successfully!</p>";
                                    } else if (status === "DeleteFailed") {
                                        document.getElementById("message").innerHTML = "<p class='error'>Failed to delete Admin. Please try again.</p>";
                                    } else if (status === "updateStatus" || status === "errorUpdateStatus") {
                                        document.getElementById("message").innerHTML = "<p class='success'>" + messageGet + "</p>";
                                    }
        </script>

    </body>

</html>
