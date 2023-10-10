/**
 * A servlet class responsible for handling HTTP POST requests to add items to the user's shopping cart.
 * This servlet interacts with the ItemHandler and ShoppingCartHandler classes to manage shopping cart items.
 */
package ui;

import bo.ItemHandler;
import bo.ShoppingCartHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addToCart")
public class AddItemToCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        String itemId = request.getParameter("itemId");
        boolean success = ShoppingCartHandler.addItemToCart(username, Integer.parseInt(itemId));
        if (success) {
            response.sendRedirect("home");
        } else {
            response.sendRedirect("home");
        }
    }

}
