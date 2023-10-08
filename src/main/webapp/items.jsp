<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Items</title>
    <style>
        /* CSS för att ändra storleken på bilden */
        .item-container img {
            width: 200px; /* Ändra bildbredden efter behov */
            height: 200px; /* Ändra bildhöjden efter behov */
        }

        /* CSS för att ändra textstorleken för namnet */
        .item-name {
            font-size: 16px; /* Ändra textstorleken efter behov */
            font-weight: bold; /* Gör texten fetstilad om så önskas */
        }

        /* CSS för att justera placeringen av "Add to Cart" knappen */
        form {
            margin-top: 10px; /* Ändra marginalen över knappen efter behov */
        }
    </style>
</head>
<body>

<table border="1">
    <tr>
        <th>Item</th>
        <th>Action</th>
    </tr>
    <%
        java.util.Collection<ItemInfo> itemInfoList = (Collection<ItemInfo>)request.getAttribute("itemInfoList");
        if (itemInfoList != null) {
            for (ItemInfo item : itemInfoList) {
                byte[] imageData = item.getImageData();
                String base64Image = "";
                if (imageData != null && imageData.length > 0) {
                    base64Image = Base64.getEncoder().encodeToString(imageData);
                }
    %>
    <tr>
        <td>
            <div class="item-container">
                <img src="data:image/jpeg;base64, <%= base64Image %>" width="200" height="200"> <!-- Visa bilden större -->
                <div class="item-name"><%= item.getName() %></div> <!-- Visa bara namnet -->
            </div>
        </td>
        <td>
            <form action="addToCart" method="POST">
                <input type="hidden" name="itemId" value="<%= item.getName() %>">
                <input type="submit" value="Add to Cart">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
