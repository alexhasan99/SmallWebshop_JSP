<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Items</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Image</th> <!-- Lägg till en ny kolumn för bilden -->
        <th>Action</th>
    </tr>
    <%
        java.util.Collection<ItemInfo> itemInfoList = (Collection<ItemInfo>)request.getAttribute("itemInfoList");
        if (itemInfoList != null) {
            for (ItemInfo item : itemInfoList) {
    %>
    <tr>
        <td><%= item.getName() %></td>
        <td><%= item.getDescription() %></td>
        <td>
            <img src="<%= item.getImageData() %>" width="100" height="100"> <!-- Visa bilden -->
        </td>
        <td> <!-- Lägg till dina action-knappar här -->
            <!-- Exempel på en knapp för att lägga till i kundvagnen -->
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

