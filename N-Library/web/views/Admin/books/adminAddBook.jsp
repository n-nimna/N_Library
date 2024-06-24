<%@page import="com.team2.models.BookCategories"%>
<%@page import="com.team2.controller.utill.assetsUrl"%>
<%@page import="java.util.List"%>
<%@page import="com.team2.models.Books"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library Dashboard | Manage Books</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>" />

        <style>
            /* Add any additional custom styles here */
        </style>
    </head>

    <body>
        <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

        <div class="content">
            <%@ include file="/views/Admin/admincommon/header.jsp" %>

            <div class="container form-container mt-5 p-3">
                <div class="row">
                    <div class="col-6" style="display: flex;">
                        <h2>${book != null ? 'Update Book Data' : 'Add New Book'}</h2>

                    </div>
                    <div class="col-6 d-flex justify-content-end mb-4">
                        <%                            if (request.getAttribute("book") != null) {%>

                        <a class="btn btn-dark" href="${pageContext.request.contextPath}/admin/books/" style="margin: 1% 2% 2% 2%">All Books</a>



                        <%
                        } else {%>
                        <a href="${pageContext.request.contextPath}/admin/books/new" class="btn btn-outline-secondary" style="margin: 1% 2% 2% 2%">Refresh</a>
                        <a class="btn btn-dark" href="${pageContext.request.contextPath}/admin/books/" style="margin: 1% 2% 2% 2%">All Books</a>
                        <%}
                        %>




                    </div>
                </div>
                <form action="${book != null ? 'update' : 'addnew'}" method="post" enctype="multipart/form-data">
                    <input type="hidden" value="${book != null ? book.id : ''}" name="id">

                    <div class="row">
                        <div class="col-6">
                            <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="bookTitle">Book Title</label>
                                        <input type="text" class="form-control" id="bookTitle" placeholder="Enter book title"
                                               name="title" value="${book != null ? book.title : ''}" required>
                                        <span class="error" id="titleError">${titleError}</span>
                                    </div>
                                    <div class="form-group">
                                        <label for="author">Author</label>
                                        <input type="text" class="form-control" id="author" placeholder="Enter author"
                                               name="author" value="${book != null ? book.author : ''}" required>
                                        <span class="error" id="authorError">${authorError}</span>
                                    </div>
                                    <div class="form-group" style="margin-top: 5rem;">
                                        <button type="submit" class="btn btn-success">${book != null ? 'Update Book' : 'Add Book'}</button>

                                    </div>
                                </div>
                                <div class="col-6">
                                    <%   String imageUrlDB = null;
                                        if (request.getAttribute("book") != null) {
                                            Books book = (Books) request.getAttribute("book");
                                            imageUrlDB = book.getImage();
                                        }
                                    %>

                                    <% if (imageUrlDB != null) {%>
                                    <img src="<%= assetsUrl.giveUrl(request, "DBImages/") + imageUrlDB%>"
                                         style="width:5rem;height:5rem; margin-top: 10px;" id="previewImage" alt="Preview">
                                    <% }%>

                                    <input type="hidden" name="dbImage" value="<%=imageUrlDB%>">
                                    <div class="form-group">
                                        <label for="image">${book != null ? 'Update Image' : 'Add new Image'}</label>
                                        <input type="file" class="form-control-file" id="image" name="image"
                                               accept="image/*">
                                    </div>
                                </div>
                            </div> 
                        </div>
                        <div class="col-6">
                            <% List<BookCategories> categories = (List<BookCategories>) request.getAttribute("categories"); %>
                            <div class="form-group">
                                <label for="category">Category</label>
                                <select class="form-control" id="category" name="category" required>
                                    <option value="" disabled selected>Select category</option>
                                    <% if (categories != null) { %>
                                    <% for (BookCategories category : categories) {%>
                                    <option value="<%= category.getBcId()%>"
                                            <% if (request.getAttribute("book") != null && ((Books) request.getAttribute("book")).getCategoryId() == category.getBcId()) { %>
                                            selected
                                            <% }%>>
                                        <%= category.getCategoryName()%>
                                    </option>
                                    <% } %>
                                    <% }%>
                                </select>
                                <span class="error" id="categoryError">${categoryError}</span>
                            </div>
                            <div class="form-group">
                                <label for="quantity">Quantity</label>
                                <input type="number" class="form-control" id="quantity" placeholder="Enter quantity"
                                       name="quantity" value="${book != null ? book.quantity : ''}" required>
                                <span class="error" id="quantityError">${quantityError}</span>
                            </div>

                            <div class="form-group">
                                <label for="description">Description</label>
                                <textarea class="form-control" id="description" rows="3" placeholder="Enter description"
                                          name="description">${book != null ? book.description : ''}</textarea>
                                <span class="error" id="descriptionError">${descriptionError}</span>
                            </div>
                        </div>
                    </div> 







                </form>
                <div class="mt-3" id="message"></div>

            </div>

            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

            <script>
                // Get the status message from the server-side
                var status = "${status}";


                // Check the status and display the appropriate message
                if (status === "InsertSuccess") {
                    document.getElementById("message").innerHTML = "<p class='success'>Book added successfully!</p>";
                } else if (status === "InsertFailed") {
                    document.getElementById("message").innerHTML = "<p class='error'>Failed to add book. Please try again.</p>";
                } else if (status === "UpdateSuccess") {
                    document.getElementById("message").innerHTML = "<p class='success'>Book updated successfully!</p>";
                } else if (status === "UpdateFailed") {
                    document.getElementById("message").innerHTML = "<p class='error'>Failed to update book. Please try again.</p>";
                } else if (status === "errorImageUpload") {
                    document.getElementById("message").innerHTML = "<p class='error'>Failed to upload image. Please try again.</p>";
                }
            </script>



    </body>

</html>