<%@page import="java.util.List"%>
<%@page import="com.team2.models.BookCategories"%>
<%@page import="com.team2.controller.utill.assetsUrl"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library Dashboard</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>"/>
        <style>
            .categoryName {
                border: none;
                background-color: transparent;
            }
            .update-btn {
                display: none;
            }
            .success-message, .error-message {
                display: none;
                font-size: 0.8rem;
                margin-top: 5px;
            }
            .success-message {
                color: green;
            }
            .error-message {
                color: red;
            }
        </style>

    </head>

    <body>
        <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

        <div class="content">
              <%@ include file="/views/Admin/admincommon/header.jsp" %>
            <div class="container-fluid mt-2">
                <div id="message" class="container-fluid"></div>

                <div class="row">
                    <div class="col-6">
                        <h2 class="mb-4">Category Management</h2>
                    </div>
                    <div class="col-6 d-flex justify-content-end mb-4">
                        <a href="${pageContext.request.contextPath}/admin/bookcategories/" class="btn btn-outline-secondary">Refresh</a> 
                        <a id="addNewCategoryBtn" class="btn btn-success ml-2">Add New Category</a>

                    </div>
                </div>


                <div id="newCategoryForm" class="d-none"> <div class="row">
                        <form action="add-new" method="post">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="categoryName">Category Name:</label>
                                    <input type="text" class="form-control" id="categoryName" placeholder="Enter category name" name="categoryName">
                                </div>
                                <button id="submitCategoryBtn" class="btn btn-success">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <% List<BookCategories> categories = (List<BookCategories>) request.getAttribute("bookCategories");%> 
                        <p>All Students(<%=categories.size()%>)</p>


                        <% if (categories != null && !categories.isEmpty()) { %> 
                        <table class="table table-hover table-striped">
                            <thead class="">
                                <tr>
                                    <th>No</th>
                                    <th>Category ID</th>
                                    <th>Category Name</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% int count = 1; %>
                                <% for (BookCategories category : categories) {%>
                                <tr style="border-bottom: 1px solid #222222;"> 
                                    <td><%= count++%></td>
                                    <td ><%= category.getBcId()%></td>
                                    <td>                           
                                        <form action="update" method="post">
                                            <input type="text" name="categoryName" value="<%= category.getCategoryName()%>" class="categoryName" id="categoryInput" disabled>
                                            <input type="hidden" name="bcId" value="<%= category.getBcId()%>">
                                            <button id="updateBtn" class="btn btn-secondary update-btn" style="width: 3.5rem; font-size: .5rem">Update</button>
                                        </form>

                                    </td>

                                    <td>
                                        <button id="editBtn" class="btn btn-primary" style="width: 3.5rem; font-size: .5rem">Edit</button>
                                        <a href="#" onclick="return confirmDelete('<%= category.getBcId()%>');" class="btn btn-danger" style="width: 3.5rem; font-size: .5rem">Delete</a>
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
            </div>
        </div>



        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script>
//                                           show add new form
                                            $(document).ready(function () {
                                                $("#addNewCategoryBtn").click(function () {
                                                    $("#newCategoryForm").toggleClass("d-none");
                                                });
                                            });

//                                             end of show add new form



                                            // Get the status message from the server-side
                                            var status = "<%=request.getAttribute("status")%>";
                                            // Check the status and display the appropriate message
                                            if (status === "InsertSuccess") {

                                                document.getElementById("message").innerHTML =
                                                        "<p class='success'>Category added successfully!</p>"

                                            } else if (status === "InsertFailed") {
                                                // Display the error message
                                                document.getElementById("message").innerHTML =
                                                        "<p class='error'>Failed to add Category. Please try again.</p>";
                                            } else if (status === "UpdateSuccess") {
                                                // Display the error message
                                                document.getElementById("message").innerHTML =
                                                        "<p class='success'>Successfully update Category.</p>";
                                            } else if (status === "UpdateFailed") {
                                                // Display the error message
                                                document.getElementById("message").innerHTML =
                                                        "<p class='error'>Failed to update Category. Please try again.</p>";
                                            } else if (status === "DeleteSuccess") {
                                                // Display the error message
                                                document.getElementById("message").innerHTML =
                                                        "<p class='success'>Successfully Delete Category.</p>";
                                            } else if (status === "DeleteFailed") {
                                                // Display the error message
                                                document.getElementById("message").innerHTML =
                                                        "<p class='error'>Failed to update Category. Please try again.</p>";
                                            }



                                            document.getElementById('editBtn').addEventListener('click', function (event) {
                                                event.preventDefault(); // Prevent the default action of the link
                                                var inputField = document.getElementById('categoryInput');
                                                var updateButton = document.getElementById('updateBtn');

                                                inputField.disabled = false;
                                                updateButton.style.display = 'inline-block';
                                                this.style.display = 'disable';
                                            });


                                            function confirmDelete(bcId) {
                                                // Display a confirmation dialog using SweetAlert
                                                swal({
                                                    title: "Are you sure?",
                                                    text: "Once deleted, you will not be able to recover this Category!",
                                                    icon: "warning",
                                                    buttons: true,
                                                    dangerMode: true,
                                                }).then(function (willDelete) {
                                                    if (willDelete) {
                                                        // Redirect to the delete action with the item ID
                                                        window.location.href = "<%= request.getContextPath()%>/admin/bookcategories/delete?bcId=" + bcId;
                                                    } else {
                                                        // Do nothing if the user cancels
                                                    }
                                                });
                                                // Return false to prevent the default link action
                                                return false;
                                            }






        </script>





    </body>

</html>
