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
            background-color: #0078a9; /* Change the background color to match your design */
            padding: 10px;
            color: #fff; /* Change the text color to match your design */
        }

        /* Style for the "Home" button */
        .home-button {
            background-color: #444;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <a href="home" class="home-button">Home</a>
</div>

<div class="container">
    <table border="1">
        <tr>
            <th>Item</th>
            <th>Action</th>
        </tr>
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
        <tr>
            <td>
                <div class="item-container">
                    <img src="data:image/jpeg;base64, <%= base64Image %>" width="200" height="200">
                    <div class="item-name"><%= item.getName() %></div>
                </div>
            </td>
            <td>
                <form action="remove" method="POST">
                    <input type="hidden" name="itemId" value="<%= item.getId() %>">
                    <input type="submit" value="Remove">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
