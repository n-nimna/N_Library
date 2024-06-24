<%-- 
    Document   : admin
    Created on : Jun 23, 2024, 9:13:53 PM
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
        <c:forEach var="todo" items="${listCategory}">
        <div class="bg-white rounded-lg shadow-lg p-6 flex flex-col justify-between">
                        <div>
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.bookCategorys}" /></h2>
                        </div>
                        <div class="flex justify-between">
                            <div class="flex">
                                <a href="delete?categoryId=<c:out value='${todo.categoryId}' />" class="text-blue-500 hover:text-blue-700">Delete
                                </a>
                            </div>
                        </div>
        </div>
        </c:forEach>                        
    </body>
</html>
