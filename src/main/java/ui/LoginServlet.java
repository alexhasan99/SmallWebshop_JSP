package ui;
import java.io.IOException;

import bo.UserHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet doGet executed");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Här bör du använda en säker metod för användarautentisering, t.ex. kontrollera en databas
        if (isValidUser(username, password)) {
            // Om användaren är giltig, lagra användarnamnet i en sessionsvariabel
            request.getSession().setAttribute("username", username);

            // Skicka användaren till välkomstsidan
            response.sendRedirect("home.jsp");
        } else {
            // Om användaren är ogiltig, skicka dem tillbaka till inloggningssidan med ett felmeddelande
            request.setAttribute("message", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }



    private boolean isValidUser(String username, String password) {
        return UserHandler.checkUser(username,password);
    }
}

