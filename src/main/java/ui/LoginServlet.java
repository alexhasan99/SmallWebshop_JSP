/**
 * A servlet class responsible for handling HTTP POST requests for user login.
 * This servlet interacts with the UserHandler class to validate user credentials and set a session attribute upon successful login.
 */
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
        if (isValidUser(username, password)) {
            request.getSession().setAttribute("username", username);

            response.sendRedirect("home");
        } else {
            request.setAttribute("message", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Validates a user's credentials by checking with the UserHandler class.
     *
     * @param username The username provided for login.
     * @param password The password provided for login.
     * @return `true` if the username and password are valid, `false` otherwise.
     */
    private boolean isValidUser(String username, String password) {
        return UserHandler.checkUser(username, password);
    }
}
