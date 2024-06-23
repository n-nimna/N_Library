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

            <div class="container-fluid">

                <div class="row">
                    <div class="col-6">
                        <h2 class="mb-4">Student Details</h2>
                    </div>
                    <div class="col-6" style="display: flex;justify-content: end;margin: 0 0 1rem 0">
                        <button class="btn btn-success"><a href="new">Add New Student</a></button>
                    </div>
                </div>
                <table class="table table-hover table-striped">
                    <thead class="thead-light">
                        <tr>
                            <th>Student ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Profile Image</th>
                            <th>NIC</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Address</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--  Dynamically generated rows from your Java code -->
                        <tr>
                            <td>1</td>
                            <td>John</td>
                            <td>Doe</td>  
                            <td>image...</td>

                            <td>123456789V</td>
                            <td>john.doe@example.com</td>
                            <td>123-456-7890</td>
                            <td>123 Main Street, City</td>
                            <td>
                                <a href="#" class="btn btn-outline-secondary btn-sm">Edit</a>
                                <a href="#" class="btn btn-outline-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Jane</td>
                            <td>Smith</td>
                            <td>image...</td>
                            <td>987654321V</td>
                            <td>jane.smith@example.com</td>
                            <td>456-789-0123</td>
                            <td>456 Oak Avenue, Town</td>
                            <td>
                                <a href="#" class="btn btn-outline-secondary btn-sm">Edit</a>
                                <a href="#" class="btn btn-outline-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                        <!-- Add more rows as needed -->
                    </tbody>
                </table>
            </div>



        </div>



        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

</html>
