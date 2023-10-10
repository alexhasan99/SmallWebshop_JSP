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
        // Hämta användarnamnet från sessionen (om du har det sparad där)
        String username = (String) request.getSession().getAttribute("username");
        String itemId = request.getParameter("itemId");
        System.out.println(itemId);
        ShoppingCartHandler.removeItemFromCart(username, Integer.parseInt(itemId));
        response.sendRedirect("shoppingCart");
    }
}
