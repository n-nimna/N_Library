<%-- 
    Document   : home
    Created on : Jun 20, 2024, 12:12:18 PM
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
        <a href="new" class="text-blue-500 hover:text-blue-700">Admin
                                </a>
        <a href="edit" class="text-blue-500 hover:text-blue-700">BorrowedBooks
                                </a>
        <div class="mt-8 container">
            <div class="grid grid-cols-1 gap-4">
                <c:forEach var="todo" items="${showBookDetails}">
                    <div class="bg-white rounded-lg shadow-lg p-6 flex flex-col justify-between">
                        <div>
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.bookTitle}" /></h2>
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.bookCategory}" /></h2>
                            <h5 class="text-sm text-gray-600 mb-4"><c:out value="${todo.author}" /></h5>
                            <c:out value="${todo.image}" />
                        </div>
                        <div class="flex">
                                <a href="details?id=<c:out value='${todo.id}' />" class="text-blue-500 hover:text-blue-700">View
                                </a>
                                
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
