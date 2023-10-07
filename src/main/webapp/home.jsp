<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        /* CSS för navigation bar */
        .navbar {
            background-color: #333;
            overflow: hidden;
        }

        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .cart-icon {
            font-size: 20px;
            margin-right: 10px;
        }

        /* CSS för sidinnehåll */
        .content {
            padding: 20px;
        }
    </style>
</head>
<body>
<!-- Navigationsbar -->
<div class="navbar">
    <a href="items">Items</a> <!-- Länk till items-sidan -->
    <span class="cart-icon">🛒</span> <!-- Shopping cart-ikonen -->
    <a href="logout">Log out</a>
</div>

<!-- Sidinnehåll -->
<div class="content">
    <!-- Här kan du inkludera innehållet för din startsida (t.ex., välkomsttext) -->
    <h1>Welcome to the Webshop</h1>
    <!-- Lägg till mer innehåll här -->

    <!-- Inkludera items.jsp om ett villkor är uppfyllt (t.ex., användaren är inloggad) -->
    <c:if test="${loggedIn}">
        <jsp:include page="items.jsp" />
    </c:if>
</div>

</body>
</html>
