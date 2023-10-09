package ui;
import bo.ItemHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;


@WebServlet("/home")
public class ItemsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selectedCategory = request.getParameter("category");
        if (selectedCategory != null && !selectedCategory.isEmpty() && !selectedCategory.equals("All")) {
            Collection<ItemInfo> itemsInCategory = ItemHandler.getItemsWithGroup(selectedCategory);
            request.setAttribute("itemInfoList", itemsInCategory);
        } else {

            Collection<ItemInfo> allItems = ItemHandler.getAllItems();
            request.setAttribute("itemInfoList", allItems);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
    }



}
