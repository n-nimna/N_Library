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
            <%@ include file="/views/Admin/admincommon/header.jsp" %>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-6">
                        <h2 class="mb-4">Barrowed Details</h2>
                    </div>
                    <div class="col-6 d-flex justify-content-end mb-4">
                        <a href="${pageContext.request.contextPath}/admin/barrowbooks/" class="btn btn-outline-secondary">Refresh</a> 
                        <a href="new" class="btn btn-success ml-2">New Book Barrow</a>

                    </div>
                </div>


                <form action="${pageContext.request.contextPath}/admin/barrowbooks/search" method="post">
                    <div class="form-group col-md-4">
                        Search Barrowed Book :
                        <div class="row">
                            <div class="col-6">
                                <input type="text" class="form-control" id="borrowBookId" name="barrow">
                            </div>
                            <div class="col-6">
                                <div class="astyle">
                                    <button type="submit" class="btn btn-success">Search Barrowed Book</button>
                                </div>
                            </div>

                        </div>


                    </div>
                </form>


                <table class="table table-hover">
                    <thead class="thead-light">
                        <tr>
                            <th>Id</th>
                            <th>User Id</th>
                            <th>Book Id</th>
                            <th>Barrowed date</th>
                            <th>Return Date</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${book}">
                            <tr>

                                <td>${book.id}</td>
                                <td>${book.userId}</td>
                                <td>${book.bookid}</td>
                                <td>${book.barrowDate}</td>
                                <td>${book.returnDate}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/barrowedbooks/delete?id=${book.id}" class="btn btn-outline-danger btn-sm">Return</a>
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

