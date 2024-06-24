<%-- 
    Document   : borrowed
    Created on : Jun 24, 2024, 1:07:41 PM
    Author     : 94781
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <!-- Tailwind CSS CDN link -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <!-- Font Awesome CDN link for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    </head>
    <body>
        <c:forEach var="todo" items="${showBarrowed}">
        <div class="bg-white rounded-lg shadow-lg p-6 flex flex-col justify-between">
                        <div>
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.barrowedDate}" /></h2>
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.returnDate}" /></h2>
                        </div>
        </div>
        </c:forEach>                        
    </body>
</html>
