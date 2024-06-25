<%-- 
    Document   : profile
    Created on : Jun 22, 2024, 11:26:57 AM
    Author     : ASUS
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="/N-Library/styles/profile.css">
        
        
    </head>
    <body>
      
        
        <div class="profile-container">
        <h2>Profile Details</h2>
        <form action="" method="" enctype="">
            <div class="profile-grid">
                <div class="hero">
                    <div class="card">
                        <h1><b>Nimeshi Dilshara</b></h1>
                        <img src="images/default-profile-pic.png" id="profile-pic" alt="Profile Photo">
                        <label for="input-file" class="inputlabal">Update Photo</label>
                        <input type="file" accept="image/jpeg, image/png, image/jpg" id="input-file" class="imginput" name="profile-photo">
                    </div>
                </div>
                <div class="profile-details">
                    <label for="first-name">First Name</label>
                    <input type="text" id="first-name" placeholder="First Name" name="first-name" disabled>
                    
                    <label for="last-name">Last Name</label>
                    <input type="text" id="last-name" placeholder="Last Name" name="last-name">
                    
                    <label for="email">Email</label>
                    <input type="email" id="email" placeholder="Email" name="email">
                    
                    <label for="contact-number">Contact Number</label>
                    <input type="text" id="contact-number" placeholder="Contact Number" name="contact-number">
                    
                    <label for="address">Address</label>
                    <input type="text" id="address" placeholder="Address" name="address">
                    
                    <label for="nic-number">NIC Number</label>
                    <input type="text" id="nic-number" placeholder="NIC Number" name="nic-number">
                </div>
            </div>
            <div class="edit-button">
                <button id="edit-profile-button" type="">Edit Profile</button>
            </div>
        </form>
    </div>
    <script>
        let profilePic = document.getElementById("profile-pic");
        let inputFile = document.getElementById("input-file");

        inputFile.onchange = function() {
            profilePic.src = URL.createObjectURL(inputFile.files[0]);
        }
    </script>
        

       </body>
</html>
