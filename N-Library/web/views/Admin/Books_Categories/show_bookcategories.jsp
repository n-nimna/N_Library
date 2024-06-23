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


    </head>

    <body>
        <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

        <div class="content">
            <div class="adminName">
                <h2>Kavindu Kaveesha</h2>
            </div>
            <div class="container mt-5">

                <div class="row">
                    <div class="col-6">
                        <h2 class="mb-4">Category Management</h2>
                    </div>
                    <div class="col-6 d-flex justify-content-end mb-4">
                        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary">Refresh</a> 
                        <a id="addNewCategoryBtn" class="btn btn-primary ml-2">Add New Category</a>

                    </div>
                </div>
                
                
                <div id="newCategoryForm" class="d-none"> <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="categoryName">Category Name:</label>
                                <input type="text" class="form-control" id="categoryName" placeholder="Enter category name">
                            </div>
                            <button id="submitCategoryBtn" class="btn btn-success">Submit</button>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Category ID</th>
                                    <th>Category Name</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody id="categoryTable">
                                <tr>
                                    <td>1</td>
                                    <td>History</td>
                                    <td>
                                        <a href="#" class="btn btn-outline-secondary btn-sm">Edit</a>
                                        <a href="#" class="btn btn-outline-danger btn-sm">Delete</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>History</td>
                                    <td>
                                        <a href="#" class="btn btn-outline-secondary btn-sm">Edit</a>
                                        <a href="#" class="btn btn-outline-danger btn-sm">Delete</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>



        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#addNewCategoryBtn").click(function () {
                    $("#newCategoryForm").toggleClass("d-none");
                });
            });
        </script>
    </body>

</html>
