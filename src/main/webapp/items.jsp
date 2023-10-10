<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Items</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/materia/bootstrap.min.css">
    <style>
        /* CSS för att ändra storleken på bilden */
        .item-container {
            display: inline-block;
            margin: 10px;
            vertical-align: top;
            text-align: center;
        }

        .item-container img {
            width: 200px;
            height: 200px;
        }


        .item-name {
            font-size: 16px;
            font-weight: bold;
        }
        .item-Descr {
            font-size: 13px;
            font-weight: lighter;
        }


        form {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
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
        <div class="col-md-3">
            <div class="item-container">
                <img src="data:image/jpeg;base64, <%= base64Image %>" width="200" height="200">
                <div class="item-name"><%= item.getName() %></div>
                <div class="item-Descr"><%= item.getDescription() %></div>
            </div>
            <form action="addToCart" method="POST">
                <input type="hidden" name="itemId" value="<%= item.getId() %>">
                <input type="submit" value="Add to Cart">
            </form>
        </div>
        <%
                }
            }
        %>
    </div>
</div>
</body>
</html>
