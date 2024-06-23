<%@page import="com.team2.controller.utill.assetsUrl"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library Dashboard||Manage Students</title>
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
                <h2 class="mb-4">Add New Student</h2>

                <form action="admin/students/insert" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <label for="firstName">First Name:</label>
                                <input type="text" class="form-control" id="firstName" name="firstName" required>
                            </div>

                            <div class="form-group">
                                <label for="lastName">Last Name:</label>
                                <input type="text" class="form-control" id="lastName" name="lastName" required>
                            </div>

                            <div class="form-group">
                                <label for="userNic">NIC:</label>
                                <input type="text" class="form-control" id="userNic" name="userNic" required>
                            </div>

                            <div class="form-group">
                                <label for="image">Image:</label>
                                <input type="file" class="form-control-file" id="image" name="image" accept="image/*">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>

                            <div class="form-group">
                                <label for="phoneNumber">Phone Number:</label>
                                <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required>
                            </div>

                            <div class="form-group">
                                <label for="address">Address:</label>
                                <textarea class="form-control" id="address" name="address" required></textarea>
                            </div>

                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>

                        </div>

                    </div>




                    <c:if test="${status == 'InsertSuccess'}">
                        <div class="alert alert-success" role="alert">
                            Student added successfully!
                        </div>
                    </c:if>

                    <c:if test="${status == 'InsertFailed'}">
                        <div class="alert alert-danger" role="alert">
                            Failed to add student. Please try again.
                        </div>
                    </c:if>

                    <button type="submit" class="btn btn-primary">Add Student</button>
                </form>
            </div>


        </div>






        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

</html>
