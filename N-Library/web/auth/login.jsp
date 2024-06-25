<%-- 
    Document   : login
    Created on : Jun 20, 2024, 11:32:16 PM
    Author     : ASUS
--%>



<%@page import="java.util.Objects"%>
<%   
    String a = "";
    if(!Objects.isNull(request.getAttribute("message")))
    {
       a = request.getAttribute("message").toString();
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD" crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    <link rel="stylesheet" href="/N-Library/styles/login.css">
    

</head>
<body>

    
       <div class="image">
        <div class="container">
        <div class="login-form">
            <h6 class="h6Tag"><%=a%></h6>
            <h2><u><b>User Login</b></u></h2>
            <form  action="/N-Library/AuthController" method="POST" id="loginForm">
                <div class="input-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>     
                <div class="input-group">
                    <label for="password">Password:</label>
                     <input type="password" id="password" name="password" required>
                    
                </div>
                <div class="forget-password">
                <a href="#">Forget Password</a>
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    </div>
</div>


   

</body>
</html>