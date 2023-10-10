/**
 * A servlet class responsible for handling HTTP GET requests to display the user's shopping cart.
 * This servlet interacts with the ShoppingCartHandler class to retrieve the user's shopping cart information.
 */
package ui;

import bo.ShoppingCartHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/shoppingCart")
public class ShoppingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the username from the session
        String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
            // Create a ShoppingInfo object with the username
            ShoppingInfo shoppingInfo = ShoppingCartHandler.getShopCart(username);
            request.setAttribute("shoppingInfo", shoppingInfo);
            request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
        } else {
            // The user is not logged in, handle this here.
            response.sendRedirect("home"); // Redirect the user to the home page
        }
    }
}
