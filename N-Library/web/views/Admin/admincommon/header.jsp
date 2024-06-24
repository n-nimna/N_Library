<%@page import="com.team2.controller.utill.assetsUrl"%>
<%
    // Check if the user is logged in
    if (session == null || session.getAttribute("loggedInUser") == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    } else {
        // Get user attributes if logged in
        String userName = (String) session.getAttribute("username");
        String userImage = (String) session.getAttribute("userImage");
        int userId = (int) session.getAttribute("userId");

%>
<div class="adminName">
    <input type="hidden" name="userId" value="${userId}">
    <h2><%=userName%></h2>
    <img 
        src="<%= assetsUrl.giveUrl(request, "DBImages/") + userImage %>" alt="User Image" class="img-fluid rounded-circle" width="50">
</div>
<%    }
%>


