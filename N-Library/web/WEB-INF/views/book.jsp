<%-- 
    Document   : book
    Created on : Jun 23, 2024, 6:37:25 PM
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
        <c:choose>
                <c:when test="${empty todo.id}">
                    <form action="details" method="post">
                </c:when>
                <c:otherwise>
                    <form action="details" method="post">
                        <input type="hidden" name="id" value="${todo.id}" />
                </c:otherwise>
        </c:choose>
        <div class="mt-8 container">
            <div class="grid grid-cols-1 gap-4">
                    <div class="bg-white rounded-lg shadow-lg p-6 flex flex-col justify-between">
                        <div>
                            ${todo.image}
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.bookTitle}" /></h2>
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.bookCategory}" /></h2>
                            <h5 class="text-sm text-gray-600 mb-4"><c:out value="${todo.author}" /></h5>
                            <p class="text-sm text-gray-600 mb-4"><c:out value="${todo.description}" /></p>
                            <h5 class="text-sm text-gray-600 mb-4"><c:out value="${todo.available}" /></h5>
                            <h5 class="text-sm text-gray-600 mb-4"><c:out value="${todo.quantity}" /></h5>
                        </div>
                    </div>
            </div>
        </div>
                    </form>
    </body>
</html>