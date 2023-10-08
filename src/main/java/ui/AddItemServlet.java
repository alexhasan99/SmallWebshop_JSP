package ui;

import bo.ItemHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/addItemServlet")
@MultipartConfig
public class AddItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Hämta data från formuläret
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        System.out.println(request.getParameter("description"));
        String category = request.getParameter("category");
        Part imagePart = request.getPart("image");
        InputStream imageInputStream = imagePart.getInputStream();
        byte[] imageData = IOUtils.toByteArray(imageInputStream);

        // Skapa ett ItemInfo-objekt
        ItemInfo newItem = new ItemInfo(name, description, imageData);

        // Här kan du använda ItemHandler eller en annan metod för att försöka lägga till objektet
        boolean success = ItemHandler.addItem(newItem, category);

        if (success) {
            // Om objektet har lagts till, returnera användaren till startsidan (home.jsp)
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("addItem.jsp");
        }
    }
}


