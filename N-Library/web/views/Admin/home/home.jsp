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
        <%
            // Check if the user is logged in
            if (session == null || session.getAttribute("loggedInUser") == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
        %>
        <%@ include file="/views/Admin/admincommon/sidebar.jspf" %>

        <div class="content">
            <%@ include file="/views/Admin/admincommon/header.jsp" %>
            <!--get numbers of lists data-->
            <%
                Object numberOfStudentsObj = request.getAttribute("number_of_students");
                Object numberOfAdminsObj = request.getAttribute("number_of_admins");
                Object numberOfCategoriesObj = request.getAttribute("number_of_categories");

                int numberOfStudents = 0;
                int numberOfAdmins = 0;
                int numberOfCategories = 0;

                if (numberOfStudentsObj != null) {
                    numberOfStudents = Integer.parseInt(numberOfStudentsObj.toString());
                }
                if (numberOfAdminsObj != null) {
                    numberOfAdmins = Integer.parseInt(numberOfAdminsObj.toString());
                }
                if (numberOfCategoriesObj != null) {
                    numberOfCategories = Integer.parseInt(numberOfCategoriesObj.toString());
                }


            %>
            <div class="row">
                <div class="col-md-2">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title">Available Books</h5>
                            <h2 class="card-text"><%= numberOfStudents%></h2>

                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title">Students</h5>
                            <h2 class="card-text"><%= numberOfStudents%></h2>

                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title">Borrowed Books</h5>
                            <h2 class="card-text">250</h2>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title"> Returned Books</h5>
                            <h2 class="card-text">250</h2>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title">Books Categories</h5>
                            <h2 class="card-text"><%= numberOfCategories%></h2>

                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title">Admins</h5>
                            <h2 class="card-text"><%= numberOfAdmins%></h2>

                        </div>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-4">
                    <button class="btn btn-primary btn-block">New Borrowing</button>
                </div>
                <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/admin/students/new" class="btn btn-secondary btn-block">Register Student</a>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-success btn-block">Add New Book</button>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

</html>
