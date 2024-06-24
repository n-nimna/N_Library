<%@page import="com.team2.controller.utill.assetsUrl"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>N-Library||borrowed Books</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "styles/client.css")%>"/>
        <style>
            /* Advanced Media Queries for Responsive Design */
            @media (max-width: 1200px) {
                .container-fluid {
                    padding: 0 5%;
                }
            }

            @media (max-width: 992px) {
                .container-fluid {
                    padding: 0 3%;
                }
                .card {
                    margin-bottom: 2rem;
                }

            }

            @media (max-width: 768px) {
                .container-fluid {
                    padding: 0 2%;
                }
                .card {
                    margin-bottom: 1.5rem;
                }
                .custom-card .card-title {
                    font-size: 1.25rem;
                }
                .header1{
                    text-align: center;
                }
            }

            @media (max-width: 576px) {
                .container-fluid {
                    padding: 0 1%;
                }
                .card {
                    margin-bottom: 1rem;
                }
                .custom-card .card-title {
                    font-size: 1.1rem;
                }
                .custom-card .card-text {
                    font-size: 0.9rem;
                }
                .header1{
                    text-align: center;
                }
            }
        </style>
    </head>
    <body>
        <!-- Navbar -->
        <%@ include file="/views/client/clientCommon/header.jspf" %>
        <!-- Home Page -->
        <div class="container-fluid mt-4">
            <div class="row" style="margin: 0 8%;">
                <section style="margin: 2% 2%;">
                    <h3 class="header1">Find Time Expired Borrowed Books</h3>
                    <select class="form-control" id="dropdown">
                        <option value="option1">Filter Books</option>
                        <option value="option2">Expired</option>
                        <option value="option3">Not Expired</option>
                    </select>
                </section>
            </div>
            <!-- Book Cards -->
            <div class="container-fluid mt-3 mt-md-2" style="padding: 0 9%;">
                <div class="row">
                    <div class="col-md-3 mb-4">
                        <div class="card custom-card mb-4">
                            <img src="<%=assetsUrl.giveUrl(request, "Images/library1.png"
                             )%>" class="card-img-top" alt="Book Image">
                            <div class="card-body">
                                <h5 class="card-title">Pink Panther</h5>
                                <p class="card-text">Author: Jone Hopking</p>
                                <p class="card-text text-muted">Available Qty: 5</p>
                                <a href="#" class="btn btn-success btn-block">View</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 mb-4">
                        <div class="card custom-card mb-4">
                            <img src="<%=assetsUrl.giveUrl(request, "Images/library1.png"
                             )%>" class="card-img-top" alt="Book Image">
                            <div class="card-body">
                                <h5 class="card-title">Pink Panther</h5>
                                <p class="card-text">Author: Jone Hopking</p>
                                <p class="card-text text-muted">Available Qty: 5</p>
                                <a href="#" class="btn btn-success btn-block">View</a>
                            </div>
                        </div>
                    </div><div class="col-md-3 mb-4">
                        <div class="card custom-card mb-4">
                            <img src="<%=assetsUrl.giveUrl(request, "Images/download.jpg"
                             )%>" class="card-img-top" alt="Book Image">
                            <div class="card-body">
                                <h5 class="card-title">Pink Panther</h5>
                                <p class="card-text">Author: Jone Hopking</p>
                                <p class="card-text text-muted">Available Qty: 5</p>
                                <a href="#" class="btn btn-success btn-block">View</a>
                            </div>
                        </div>
                    </div><div class="col-md-3 mb-4">
                        <div class="card custom-card mb-4">
                            <img src="<%=assetsUrl.giveUrl(request, "Images/library1.png"
                             )%>" class="card-img-top" alt="Book Image">
                            <div class="card-body">
                                <h5 class="card-title">Pink Panther</h5>
                                <p class="card-text">Author: Jone Hopking</p>
                                <p class="card-text text-muted">Available Qty: 5</p>
                                <a href="#" class="btn btn-success btn-block">View</a>
                            </div>
                        </div>
                    </div><div class="col-md-3 mb-4">
                        <div class="card custom-card mb-4">
                            <img src="<%=assetsUrl.giveUrl(request, "Images/download.jpg"
                             )%>" class="card-img-top" alt="Book Image">
                            <div class="card-body">
                                <h5 class="card-title">Pink Panther</h5>
                                <p class="card-text">Author: Jone Hopking</p>
                                <p class="card-text text-muted">Available Qty: 5</p>
                                <a href="#" class="btn btn-success btn-block">View</a>
                            </div>
                        </div>
                    </div>


                    <!-- Repeat book cards as needed -->
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
