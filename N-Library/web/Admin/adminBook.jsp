<%-- 
    Document   : adminBook
    Created on : Jun 19, 2024, 7:04:19 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .sidebar {
            height: 100vh;
            position: fixed;
            width: 200px;
            top: 0;
            left: 0;
            background-color: #343a40;
            color: white;
        }
        .sidebar a {
            color: white;
            padding: 15px;
            display: block;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #575d63;
        }
        .content {
            margin-left: 200px;
            padding: 20px;
        }
    </style>
</head>
<body>
    <%@ include file="adminheader/header.jsp" %>

    <div class="d-flex">
<!--        <div class="sidebar bg-dark">
            <a href="#">Home</a>
            <a href="#">Borrow Books</a>
            <a href="#">Return Books</a>
            <a href="#">Users</a>
            <a href="#">Books</a>
            <a href="#">Admins</a>
            <a href="#">Log Out</a>
        </div>-->
        
        <div class="content container-fluid">
            <button class="btn btn-success my-3">Add New Book</button>
            <table class="table table-hover">
                <thead class="thead-light">
                    <tr>
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
                    <tr>
                        <td>1</td>
                        <td>Book Name 1</td>
                        <td>Category 1</td>
                        <td>10</td>
                        <td>Author 1</td>
                        <td>Yes</td>
                        <td>
                            <button class="btn btn-outline-secondary btn-sm">Edit</button>
                            <button class="btn btn-outline-danger btn-sm">Delete</button>
                        </td>
                    </tr>
                  
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

