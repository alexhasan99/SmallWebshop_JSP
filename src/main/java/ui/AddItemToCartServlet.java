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
        // Hämta användarnamnet från sessionen (om du har det sparad där)
        String username = (String) request.getSession().getAttribute("username");

        // Hämta itemId från formuläret
        String itemId = request.getParameter("itemId");

        // Försök lägga till objektet i kundvagnen
        boolean success = ShoppingCartHandler.addItemToCart(username, Integer.parseInt(itemId));

        // Om insättningen lyckades, skicka användaren tillbaka till startsidan (eller var du vill)
        if (success) {
            response.sendRedirect("home");
        } else {
            response.sendRedirect("home");
        }
    }

}
