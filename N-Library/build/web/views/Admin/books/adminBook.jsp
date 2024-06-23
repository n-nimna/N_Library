<%@page import="com.team2.controller.utill.assetsUrl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>N-Library Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>"/>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <style>
        .shift-left {
            margin-left: 0;
            padding-left: 0;
        }
    </style>
    
</head>

<body>
    <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

    <div class="content">
        <div class="adminName">
            <h2>Kavindu Kaveesha</h2>
            
          
        </div>
         <div class="content container-fluid shift-left">
            <a href="adminAddBook.jsp" class="btn btn-success my-3">Add New Book</a>
            <a href="adminSearchBook.jsp" class="btn btn-success my-3">Search Book</a>
            <table class="table table-hover">
                <thead class="thead-light">
                    <tr>
                        <th>Image</th>
                        <th>Book ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Quantity</th>
                        <th>Author</th>
                        <th>Available</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${book}">
                    <tr>
                        <td><img src="book image/${book.bookId}" width="16px" height="16px"></td>
                        <td>${book.bookId}</td>
                        <td>${book.title}</td>
                        <td>${book.categoryId}</td>
                        <td>${book.quantity}</td>
                        <td>${book.author}</td>
                        <td>${book.available}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/books/edit?bookId=${book.id}" class="btn btn-outline-secondary btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/admin/books/delete?bookId=${book.id}" class="btn btn-outline-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

  

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
