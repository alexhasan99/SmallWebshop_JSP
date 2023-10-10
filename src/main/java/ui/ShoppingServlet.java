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
        // Hämta användarnamnet från sessionen
        String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
            // Skapa ett ShoppingInfo-objekt med användarnamnet
            ShoppingInfo shoppingInfo = ShoppingCartHandler.getShopCart(username);
            request.setAttribute("shoppingInfo", shoppingInfo);
            request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
        } else {
            // Användaren är inte inloggad, hantera detta här.
            response.sendRedirect("home"); // Redirecta användaren till startsidan
        }
    }
}

