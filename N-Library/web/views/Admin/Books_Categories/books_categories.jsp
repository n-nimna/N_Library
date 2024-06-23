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
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="text-center mb-4">Category Management</h2>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <button id="addNewCategoryBtn" class="btn btn-primary">Add New Category</button>
                        </div>
                    </div>
                    <div id="newCategoryForm" style="display: none;">
                        <div class="row">
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
                                    <!-- Category data will be loaded here -->
                                </tbody>
                            </table>
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
