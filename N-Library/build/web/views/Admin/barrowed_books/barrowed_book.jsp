<%@page import="com.team2.controller.utill.assetsUrl"%>
<%@page import="com.team2.models.User"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>New Book Borrowing</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/admin.css")%>"/>


        <style>
            .right {
                margin-left: 250px;

            }
        </style>
    </head>

    <body>
        <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

        <div class="content">
            <%@ include file="/views/Admin/admincommon/header.jsp" %>

            <div class="container form-container mt-5 p-3">
                <div class="row mb-3">
                    <div class="col-6">
                        <h2 class="">New Book Borrowing</h2>
                    </div>                  
                    <div class="col-6">

                        <div class="col-6" style="display: flex;justify-content: flex-end">
                            <a class="btn btn-dark" href="${pageContext.request.contextPath}/admin/students/" style="margin: 2% 0">All Students</a>

                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-6">
                        <h3>User Details</h3>
                        <form action="${pageContext.request.contextPath}/admin/students/findByNic" method="get">
                            <div class="form-group">
                                <label for="userId">User Id</label>
                                <input type="text" class="form-control" id="userId" name="id">
                                <button type="submit" class="btn btn-dark mt-2">Find User</button>
                            </div>
                            <div class="form-group">
                                <label for="userName">User Name</label><input type="text" class="form-control" id="userName" disabled value="${student.firstName} ${student.lastName}">

                            </div>
                            <div class="form-group">
                                <label for="contactNumber">Contact Number</label>
                                <input type="text" class="form-control" id="contactNumber" value="${student.phoneNumber}">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" disabled value="${student.address}">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" disabled value="${student.email}">
                            </div>
                             <div class="form-group">
                                <label for="email">Active State</label>
                                <input type="email" class="form-control" id="email" disabled value="${student.active}">
                            </div>
                            <div class="form-group">
                                <label for="booksToReturn">Books to Return</label>
                                <input type="text" class="form-control" id="booksToReturn" disabled>
                            </div>
                        </form>
                    </div>

                    <div class="col-md-6">
                        <h3>Book Details</h3>
                        <form action="${pageContext.request.contextPath}/admin/books/findById" method="get">
                            <div class="form-group">
                                <label for="bookId">Book Id</label>
                                <input type="text" class="form-control" id="bookId" name="id">
                                <button type="submit" class="btn btn-dark mt-2">Find Book</button>
                            </div>
                            <div class="form-group">
                                <label for="bookAvailability">Book Availability</label>
                                <input type="text" class="form-control" id="bookAvailability" value="${book.available}" disabled>
                            </div>
                            <div class="form-group">
                                <img src="DBImages/${book.image}" alt="Book Image" class="img-thumbnail" >
                            </div>
                            <div class="form-group">
                                <label for="bookName">Book Name</label>
                                <input type="text" class="form-control" id="bookName" disabled value="${book.title}">
                            </div>
                            <div class="form-group">
                                <label for="category">Category</label>
                                <input type="text" class="form-control" id="category" disabled value="${book.categoryId}">
                            </div>
                            <div class="form-group">
                                <label for="author">Author</label>
                                <input type="text" class="form-control" id="author" disabled value="${book.author}">
                            </div>
<!--                            <div class="form-group">
                                <label for="edition">Edition</label>
                                <input type="text" class="form-control" id="edition" disabled>
                            </div>-->
                        </form>
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col-md-12">
                        <h3>Borrow Details</h3>
                        <form action="${pageContext.request.contextPath}/admin/barrowbooks/new" method="post">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="borrowBookId">Book Id</label>
                                    <input type="text" class="form-control" id="borrowBookId" name="bookId">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="borrowUserId">User Id</label>
                                    <input type="text" class="form-control" id="borrowUserId" name="userId">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="borrowDate">Borrow Date</label>
                                    <input type="date" class="form-control" id="borrowDate" name="barrowDate">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="returnDate">Return Date</label>
                                    <input type="date" class="form-control" id="returnDate" name="returnDate">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-success">Borrow Book</button>
                        </form>
                    </div>
                </div>

            </div>



            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    </body>

</html>
