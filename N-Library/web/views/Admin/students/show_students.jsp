<%@page import="com.team2.models.User"%>
<%@page import="java.util.List"%>
<%@page import="com.team2.controller.utill.assetsUrl"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library Dashboard || Manage Students</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>"/>
        <style>
            /* Add any custom styles here */
        </style>
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
                        <h2 class="mb-4">Student Details</h2>
                    </div>
                    <div class="col-6 d-flex justify-content-end mb-4">
                        <a href="${pageContext.request.contextPath}/admin/students/" class="btn btn-outline-secondary">Refresh</a> 
                        <a href="new" class="btn btn-success ml-2">Add New Student</a>

                    </div>
                </div>
                <% List<User> students = (List<User>) request.getAttribute("students");%> 
                <p>All Students(<%=students.size()%>)</p>


                <% if (students != null && !students.isEmpty()) { %> 
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
                        <% for (User student : students) {%>
                        <tr style="border-bottom: 1px solid #222222;"> 
                            <td><%= count++%></td>
                            <td><%= student.getFirstName()%></td>
                            <td><%= student.getLastName()%></td>
                            <td>
                                <img src="<%= assetsUrl.giveUrl(request, "DBImages/") + student.getImage()%>" style="width:5rem;height:5rem">
                            </td>
                            <td><%= student.getUserNic()%></td>
                            <td><%= student.getEmail()%></td>
                            <td><%= student.getPhoneNumber()%></td>
                            <td><%= student.getAddress()%></td> 
                            <td>
                                <a href="#" onclick="return changeStatus('<%= student.getUserId()%>');"
                                   class="<%= student.isActive()== true ? "btn btn-success" : "btn btn-danger"%>" style="width: 3rem; font-size: .5rem; font-weight: bold;">
                                    <%= student.isActive()== true ? "Active" : "Disable"%>
                                </a>
                            </td>
                    <script>
                        function changeStatus(studentId) {
                            // Display a confirmation dialog using SweetAlert
                            swal({
                                title: "Are you sure?",
                                text: "Are you sure you want to change the status of the student?",
                                icon: "warning",
                                buttons: true,
                                dangerMode: true,
                            }).then(function (willDelete) {
                                if (willDelete) {
                                    // Redirect to the changeStatus action with the student ID
                                    window.location.href = "<%= request.getContextPath()%>/admin/students/changeStatus?studentId=" + studentId;
                                } else {
                                    // Do nothing if the user cancels
                                }
                            });
                            // Return false to prevent the default link action
                            return false;
                        }
                    </script>


                    <td>
                        <a href="edit?id=<%= student.getUserId()%>" class="btn btn-primary" style="width: 3.5rem; font-size: .5rem">Edit</a>
                        <a href="#" onclick="return confirmDelete('<%= student.getUserId()%>');" class="btn btn-danger" style="width: 3.5rem; font-size: .5rem">Delete</a>
                    </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
                <% } else { %>
                <div class="alert alert-info" role="alert">
                    No students found.
                </div>
                <% }%>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
                            function confirmDelete(studentId) {
                                // Display a confirmation dialog using SweetAlert
                                swal({
                                    title: "Are you sure?",
                                    text: "Once deleted, you will not be able to recover this student!",
                                    icon: "warning",
                                    buttons: true,
                                    dangerMode: true,
                                }).then(function (willDelete) {
                                    if (willDelete) {
                                        // Redirect to the delete action with the item ID
                                        window.location.href = "<%= request.getContextPath()%>/admin/students/delete?studentId=" + studentId;
                                    } else {
                                        // Do nothing if the user cancels
                                    }
                                });
                                // Return false to prevent the default link action
                                return false;
                            }




//                                    change student's status'
                            function changeStatus(studentId) {
                                // Display a confirmation dialog using SweetAlert
                                swal({
                                    title: "Are you sure?",
                                    text: "Are you sure you want to change the status of the student?",
                                    icon: "warning",
                                    buttons: true,
                                    dangerMode: true,
                                }).then(function (willDelete) {
                                    if (willDelete) {
                                        // Redirect to the changeStatus action with the student ID
                                        window.location.href = "<%= request.getContextPath()%>/admin/students/changeStatus?studentId=" + studentId;
                                    } else {
                                        // Do nothing if the user cancels
                                    }
                                });
                                // Return false to prevent the default link action
                                return false;
                            }


//                                    ERROR HANDLING

                            // Get the status message from the server-side
                            var status = "<%= request.getAttribute("status")%>";
                            var messageGet = "<%= request.getAttribute("message")%>";
                            // Check the status and display the appropriate message
                            if (status === "DeleteSuccess") {
                                document.getElementById("message").innerHTML = "<p class='success'>Student deleted successfully!</p>";
                            } else if (status === "DeleteFailed") {
                                document.getElementById("message").innerHTML = "<p class='error'>Failed to delete student. Please try again.</p>";
                            } else if (status === "updateStatus") {
                                document.getElementById("message").innerHTML = " <p class = 'susccess' >${messageGet}</p>";
                            } else if (status === "errorUpadateStatus") {
                                document.getElementById("message").innerHTML = " <p class = 'susccess' >${messageGet}</p>";
                            }


        </script>
    </body>

</html>
