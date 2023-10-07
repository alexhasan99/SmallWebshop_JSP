<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/materia/bootstrap.min.css">
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
    <a href="items">Items</a>
    <span class="cart-icon">🛒</span>
    <a href="logout">Log out</a>
</div>

<!-- Sidinnehåll -->
<div class="content">
    <h1>Welcome to the Webshop</h1>
    <form action="home" method="GET">
        <label for="category">Choose a Category:</label>
        <select name="category" id="category">
            <option value="Electronics">Electronics</option>
            <option value="Clothing">Clothing</option>
            <option value="Home & Garden">Home & Garden</option>
            <option value="Books">Books</option>
            <option value="Toys">Toys</option>
            <option value="Sports">Sports</option>
            <option value="Beauty">Beauty</option>
            <option value="Other">Other</option>
            <option value="Fruits">Fruits</option>
            <option value="All">All</option>
        </select>
        <input type="submit" value="Show Items">
    </form>
    <a href="addItem.jsp">Add New Item</a>
    <jsp:include page="items.jsp" />
</div>

</body>
</html>
