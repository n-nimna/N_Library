<html lang="en">
    <head>
        <link rel="stylesheet" href="<%=assetsUrl.giveUrl(request, "common/common_url.jsp")%>"/>
        <title>N-Library||borrowed Books</title>

        <style>
            @media (min-width: 768px) {
                .searchIconBtn {
                    display: none;
                }
                .searchTextBtn {
                    display: block;
                }
            }
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
                .searchSection {
                    width: 60%;
                }
            }
            @media (max-width: 768px) {
                .searchIconBtn {
                    display: block;
                }
                .searchTextBtn {
                    display: none;
                }
                .col-12 {
                    width: 100%;
                    margin-top: 10px;
                }
                .header1 {
                    margin: 2% 0;
                }
                .btn-block {
                    padding: .4rem 1rem;
                    display: block;
                    width: 100%;
                }
                .container-fluid {
                    padding: 0 2%;
                }
                .card {
                    margin-bottom: 1.5rem;
                }
                .custom-card .card-title {
                    font-size: 1.25rem;
                }
                .header1 {
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
                .header1 {
                    text-align: center;
                }
                .searchIconBtn {
                    display: block;
                }
                .searchTextBtn {
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <!-- Navbar -->
        <%@ include file="/views/client/clientCommon/header.jspf" %>
        <!-- Home Page -->
        <div class="container-fluid">
            <div class="searchSection" style="background-color: #f8f9fa; padding: 1% 0; margin-top: 0;">
                <div class="row justify-content-center mx-md-5 mt-2 mx-2">
                    <div class="form-group col-lg-6 col-md-8 col-5">
                        <input type="text" class="form-control" name="search" placeholder="Search...." required="">
                    </div>
                    <div class="col-lg-3 col-md-4 col-5">
                        <div class="form-group">
                            <select class="form-control" id="dropdown1">
                                <option value="option1">Select Book Category</option>
                                <option value="option2">Option 2</option>
                                <option value="option3">Option 3</option>
                                <option value="option4">Option 4</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-3 col-2">
                        <a href="#" class="btn btn-success btn-block searchTextBtn" style="padding: .4rem 1rem;">Search</a>
                        <a href="#" class="btn btn-success btn-block searchIconBtn" style="padding:.3rem; margin-top: .1rem;">
                            <i class="fas fa-search text-white"></i>
                        </a>
                    </div>
                </div>
            </div>

            <div class="filterSection mx-3">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <section style="margin: 2% 0;">
                            <h3 class="header1 text-center">Find Available Books</h3>
                            <select class="form-control" id="dropdown2">
                                <option value="option1">Filter Books</option>
                                <option value="option2">Available</option>
                                <option value="option3">Not Available</option>
                            </select>
                        </section>
                    </div>
                </div>
            </div>

            <!-- Book Cards -->
            <div class="container-fluid mt-3 mt-md-2" style="padding: 0 9%;">
                <div class="row">
                    <div class="col-md-3 mb-4">
                        <div class="card custom-card mb-4">
                            <img src="<%=assetsUrl.giveUrl(request, "Images/library1.png")%>" class="card-img-top" alt="Book Image">
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
                            <img src="<%=assetsUrl.giveUrl(request, "Images/library1.png")%>" class="card-img-top" alt="Book Image">
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
                            <img src="<%=assetsUrl.giveUrl(request, "Images/download.jpg")%>" class="card-img-top" alt="Book Image">
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
                            <img src="<%=assetsUrl.giveUrl(request, "Images/library1.png")%>" class="card-img-top" alt="Book Image">
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
                            <img src="<%=assetsUrl.giveUrl(request, "Images/download.jpg")%>" class="card-img-top" alt="Book Image">
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
    </body>
</html>
