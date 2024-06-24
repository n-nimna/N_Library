<%@page import="com.team2.controller.utill.assetsUrl"%>
<%@page import="com.team2.models.User"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library Dashboard||Manage Students</title>
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
            <%@ include file="/views/Admin/admincommon/header.jsp" %>

            <div class="container form-container mt-5 p-3">
                <div class="row">
                    <div class="col-6" style="display: flex;">
                        <h2>${student != null ? 'Update Student Data' : 'Add New Book'}</h2>
                        <% if (request.getAttribute("student") == null) { %>
                        <a class="btn btn-primary" href="/new" style="margin: 1% 2% 2% 2%">New Student</a>
                        <% }%>


                    </div>
                    <div class="col-6"style="display: flex;justify-content: flex-end">
                        <a class="btn btn-dark" href="${pageContext.request.contextPath}/admin/book/"style="margin: 1% 2% 2% 2%">All Students</a>

                    </div>

                </div>
                <form action=""${pageContext.request.contextPath}/admin/books/addBook"" method="post" enctype="multipart/form-data" >
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group"> 
                                    <label for="bookTitle">Book Title</label>
                                    <input type="text" class="form-control" id="bookTitle" placeholder="Enter book title" name="title">
                                </div>
                                <div class="form-group">
                                    <label for="image">Image</label>
                                    <input type="file" class="form-control-file" id="image" accept="image/jpg, image/jpeg, image/png" name="image">
                                </div>

                                <div class="form-group">
                                    <label for="author">Author</label>
                                    <input type="text" class="form-control" id="author" placeholder="Enter author" name="author">
                                </div>
                            </div> 
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="category">Category</label>
                                    <select class="form-control" id="category" name="category">
                                        <option value="" disabled selected>Select category</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="quantity">Quantity</label>
                                    <input type="number" class="form-control" id="quantity" placeholder="Enter quantity" name="quantity" >
                                </div>
                                <div class="form-group">
                                    <label for="description">Description</label>
                                    <textarea class="form-control" id="description" rows="3" placeholder="Enter description" name="description" ></textarea>
                                </div>
                            </div>

                        </div>


                        <div class="astyle">
                            <button type="submit" class="btn btn-success">Add Book</button>
                        </div>
                </form>
            </div>

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
        // Get the status message from the server-side
        var status = "${status}";

        // Check the status and display the appropriate message
        if (status === "InsertSuccess") {
            // Get the email and password from the server-side
            var email = "${email}";
            var password = "${password}";

            // Display the success message and the email/password
            document.getElementById("message").innerHTML =
                    "<p class='success'>Student added successfully!</p>" +
                    "<p>Email: " + email + "</p>" +
                    "<p>Password: " + password + "</p>";
        } else if (status === "InsertFailed") {
            // Display the error message
            document.getElementById("message").innerHTML =
                    "<p class='error'>Failed to add student. Please try again.</p>";
        } else if (status === "UpdateSuccess") {
            // Display the error message
            document.getElementById("message").innerHTML =
                    "<p class='success'>Successfully update student.</p>";
        } else if (status === "UpdateFailed") {
            // Display the error message
            document.getElementById("message").innerHTML =
                    "<p class='error'>Failed to update student. Please try again.</p>";
        }

        // Function to set the message color
        function setMessageColor(messageElement, color) {
            messageElement.style.color = color;
        }
    </script>
</body>

</html>