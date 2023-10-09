<%@ page import="ui.ShoppingInfo" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/materia/bootstrap.min.css">
    <style>
        /* Include the common styles from your previous code */
        .item-container img {
            width: 200px;
            height: 200px;
        }
        .item-name {
            font-size: 16px;
            font-weight: bold;
        }
        form {
            margin-top: 10px;
        }

        /* Style for the container div */
        .container {
            max-width: 1200px; /* Adjust the maximum width as needed */
            margin: 0 auto;
        }

        /* Style for the header */
        .navbar {
            background-color: #333333;
            padding: 10px;
            color: #fff;
            flex-grow: 1;
            align-items: center;
        }

        /* Style for the "Home" button */
        .home-button {
            background-color: #666;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            margin-bottom: 20px;
            float: right;
        }

        /* Style for the navbar text */
        .navbar-text {
            flex-grow: 1;
            font-size: 19px;
            text-align: center;
            font-weight: bold;
        }

        /* Style for the items grid */
        .items-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); /* Adjust the item width as needed */
            gap: 20px; /* Adjust the gap between items as needed */
        }
    </style>
</head>
<body>

<div class="navbar">
    <a href="home" class="home-button">Home</a>
    <span class="navbar-text">Your Shopping Cart</span> <!-- Add this line -->
</div>

<div class="container">
    <div class="items-grid">
        <%
            ShoppingInfo shoppingInfo = (ShoppingInfo) request.getAttribute("shoppingInfo");
            Collection<ItemInfo> items = shoppingInfo.getItems();
            Iterator<ItemInfo> iterator = items.iterator();
            while (iterator.hasNext()) {
                ItemInfo item = iterator.next();
                byte[] imageData = item.getImageData();
                String base64Image = "";
                if (imageData != null && imageData.length > 0) {
                    base64Image = Base64.getEncoder().encodeToString(imageData);
                }
        %>
        <div>
            <div class="item-container">
                <img src="data:image/jpeg;base64, <%= base64Image %>" width="200" height="200">
                <div class="item-name"><%= item.getName() %></div>
            </div>
            <form action="remove" method="POST">
                <input type="hidden" name="itemId" value="<%= item.getId() %>">
                <input type="submit" value="Remove">
            </form>
        </div>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
