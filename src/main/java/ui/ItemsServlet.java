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
        Collection<ItemInfo> list = ItemHandler.getAllItems();
        for (ItemInfo i: list) {
            System.out.println(i.getName());
            System.out.println(i.getDescription());
            System.out.println(Arrays.toString(i.getImageData()));
        }
        request.setAttribute("itemInfoList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
    }



}
