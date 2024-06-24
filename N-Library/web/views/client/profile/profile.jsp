<%@page import="com.team2.controller.utill.assetsUrl"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library||Profile</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/client.css")%>"/>
    </head>
    <style>
        .profileContainer {
            height: auto;
            margin-top: 2%; 
            margin-bottom:  2%;
            padding: 1% 5%;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: transform 0.2s, box-shadow 0.2s;
            background-color: #f8f9fa;
        }
        .profileImage {
            border: 1px solid #626365;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
            transition: transform 0.2s, box-shadow 0.2s;
        }
    </style>
    <body>
        <!-- Navbar -->
        <%@ include file="/views/client/clientCommon/header.jspf" %>
        <!-- Profile Page -->
        <div class="container profileContainer">
            <h3 class="text-center mb-3">Profile Information</h3>
            <form>
                <div class="row">
                    <div class="col-md-6 text-center mt-md-5">
                        <img src="<%=assetsUrl.giveUrl(request, "Images/library1.png")%>" 
                             class="img-fluid profileImage mb-3" alt="Profile Image" style="width: 60%; height: 70%;">
                        <br>
                        <a type="button" class="mt-2" id="changeProPic">Change Profile Picture</a>
                        <div id="changeProPicForm" class="mt-3 d-none ">
                            <form action="" method="post" enctype="multipart/form-data">
                                <div class="row m-1 border border-5 p-3" style="background-color: #f8f9fa;">
                                    <div class="col-8">
                                        <input type="file" name="proImg" class="" accept="image/*">
                                    </div>
                                    <div class="col-4">
                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12 mt-md-2 mt-5">
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" class="form-control" id="firstName" value="John" disabled>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" class="form-control" id="lastName" value="Doe" disabled>
                        </div>
                        <div class="form-group">
                            <label for="contactNumber">Contact Number</label>
                            <input type="text" class="form-control" id="contactNumber" value="123-456-7890" disabled>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" value="john.doe@example.com" disabled>
                        </div>
                        <div class="form-group">
                            <label for="nic">NIC</label>
                            <input type="text" class="form-control" id="nic" value="123456789V" disabled>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="text"  class="form-control" id="address" value="123 Main St, Anytown, USA123 Main St, Anytown, USA123 Main St, Anytown, USA" disabled>

                        </div>


                    </div>

                </div>

                <div class="row mx-2" style="display: flex;justify-content:flex-end; ">
                    <button type="button" class="btn btn-warning" id="changePassword">Change Password</button>
                </div>
                <div id="changePasswordForm" class="mt-3 d-none">
                    <form action="" method="post">
                        <div class="row m-1 border border-5 p-3" style="background-color: #f8f9fa;">
                            <div class="col-md-4 col-sm-12">
                                <div class="form-group">
                                    <label for="currentPassword">Current Password</label>
                                    <input type="password" class="form-control" id="currentPassword" placeholder="Enter current password" required>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-12">
                                <div class="form-group">
                                    <label for="newPassword">New Password</label>
                                    <input type="password" class="form-control" id="newPassword" placeholder="Enter new password" required>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-12" style="margin-top: 2rem;">
                                <button type="submit" class="btn btn-primary">Update Password</button>
                            </div>
                        </div>
                    </form>
                </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#changePassword").click(function () {
                    $("#changePasswordForm").toggleClass("d-none");
                });
                $("#changeProPic").click(function () {
                    $("#changeProPicForm").toggleClass("d-none");
                });
            });
        </script>
    </body>
</html>
