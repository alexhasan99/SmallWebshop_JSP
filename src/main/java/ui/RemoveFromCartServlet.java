/**
 * A servlet class responsible for handling HTTP POST requests to remove an item from the user's shopping cart.
 * This servlet interacts with the ShoppingCartHandler class to remove items from the shopping cart.
 */
package ui;

import bo.ShoppingCartHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/remove")
public class RemoveFromCartServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String itemId = request.getParameter("itemId");
        System.out.println(itemId);
        ShoppingCartHandler.removeItemFromCart(username, Integer.parseInt(itemId));
        response.sendRedirect("shoppingCart");
    }
}
