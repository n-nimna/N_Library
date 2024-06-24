<%@page import="com.team2.controller.utill.assetsUrl"%>
<%@page import="java.util.List"%>
<%@page import="com.team2.models.Books"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library Dashboard || Manage Books</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>" />
        <style>
            /* Add any custom styles here */
        </style>
    </head>

    <body>
        <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>
        <div class="content">
            <%@ include file="/views/Admin/admincommon/header.jsp" %>
            <div id="message" class="container-fluid"></div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-6">
                        <h2 class="mb-4">Book Details</h2>
                    </div>
                    <div class="col-6 d-flex justify-content-end mb-4">
                        <a href="${pageContext.request.contextPath}/admin/books/" class="btn btn-outline-secondary">Refresh</a>
                        <a href="new" class="btn btn-success ml-2">Add New Book</a>
                        <a href="${pageContext.request.contextPath}/admin/searchBook.jsp" class="btn btn-success ml-2">Search
                            Book</a>

                    </div>
                </div>
                <% List<Books> books = (List<Books>) request.getAttribute("books");%>
                <p>All Books(<%=books.size()%>)</p>

                <% if (books != null && !books.isEmpty()) { %>
                <table class="table table-hover table-striped">
                    <thead class="">
                        <tr>
                            <th>No</th>
                            <th>Image</th>
                            <th>Book ID</th>
                            <th>Title</th>
                            <th>Category</th>
                            <th>Quantity</th>
                            <th>Author</th>
                            <th>Available</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% int count = 1; %>
                        <% for (Books book : books) {%>
                        <tr style="border-bottom: 1px solid #222222;">
                            <td><%= count++%></td>

                            <td>
                                <img src="<%= assetsUrl.giveUrl(request, "DBImages/") + book.getImage()%>"
                                     style="width:5rem;height:5rem">
                            </td>
                            <td><%= book.getBookId()%></td>
                            <td class="truncate"><%= book.getTitle()%></td>
                            <td><%= book.getCategoryId()%></td>
                            <td><%= book.getQuantity()%></td>
                            <td class="truncate"><%= book.getAuthor()%></td>
                            <td>
                                <%= book.getAvailable() == true ? "Available" : "Not Available"%>
                            </td>
                            <td>
                                <a href="edit?id=<%= book.getId()%>" class="btn btn-primary"
                                   style="width: 3.5rem; font-size: .5rem">Edit</a>
                                <a href="#" onclick="return confirmDelete('<%= book.getId()%>');" class="btn btn-danger"
                                   style="width: 3.5rem; font-size: .5rem">Delete</a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% } else { %>
                <div class="alert alert-info" role="alert">
                    No books found.
                </div>
                <% }%>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
                                    function confirmDelete(bookId) {
                                        // Display a confirmation dialog using SweetAlert
                                        swal({
                                            title: "Are you sure?",
                                            text: "Once deleted, you will not be able to recover this book!",
                                            icon: "warning",
                                            buttons: true,
                                            dangerMode: true,
                                        }).then(function (willDelete) {
                                            if (willDelete) {
                                                // Redirect to the delete action with the item ID
                                                window.location.href = "<%= request.getContextPath()%>/admin/books/delete?bookId=" + bookId;
                                            } else {
                                                // Do nothing if the user cancels
                                            }
                                        });
                                        // Return false to prevent the default link action
                                        return false;
                                    }

                                    // ERROR HANDLING

                                    // Get the status message from the server-side
                                    var status = "<%= request.getAttribute("status")%>";
                                    var messageGet = "<%= request.getAttribute("message")%>";
                                    // Check the status and display the appropriate message
                                    if (status === "DeleteSuccess") {
                                        document.getElementById("message").innerHTML = "<p class='success'>Book deleted successfully!</p>";
                                    } else if (status === "DeleteFailed") {
                                        document.getElementById("message").innerHTML = "<p class='error'>Failed to delete book. Please try again.</p>";
                                    }

        </script>
    </body>

</html>