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

      <style>
        .shift-left {
            margin-left: 0;
            padding-left: 0;
        }
        
        .astyle{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
    </style>
</head>

<body>
    <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

    <div class="content">
        <div class="adminName">
            <h2>Kavindu Kaveesha</h2>
        
        </div>
        <div class="content shift-left">
        <div class="container-fluid mt-3 ">
            <div class="card">
                <div class="card-header bg-success text-white">Add New Book</div>
                <div class="card-body">
                    <form action=""${pageContext.request.contextPath}/admin/books/addBook"" method="post" enctype="multipart/form-data" >
                        <div class="form-group">
                            <label for="bookTitle">Book Title</label>
                            <input type="text" class="form-control" id="bookTitle" placeholder="Enter book title" name="title">
                        </div>
                        <div class="form-group">
                            <label for="bookId">Book ID</label>
                            <input type="text" class="form-control" id="bookId" placeholder="Enter book ID" name="bookId">
                        </div>
                        <div class="form-group">
                            <label for="author">Author</label>
                            <input type="text" class="form-control" id="author" placeholder="Enter author" name="author">
                        </div>
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
                        <div class="form-group">
                            <label for="image">Image</label>
                            <input type="file" class="form-control-file" id="image" accept="image/jpg, image/jpeg, image/png" name="image">
                        </div>
                        <div class="astyle">
                        <button type="submit" class="btn btn-success">Add Book</button>
                        <a href="adminBook.jsp" class="btn btn-success astyle">Back</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>

     

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>

