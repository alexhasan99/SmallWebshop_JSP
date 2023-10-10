/**
 * A servlet class responsible for handling HTTP POST requests for user registration.
 * This servlet interacts with the UserHandler class to register new users and handle registration validation.
 */
package ui;

import bo.UserHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet doPost executed");
        String username = request.getParameter("newUsername");
        String password = request.getParameter("newPassword");
        if (isValidUser(username, password)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("message", "Username Exist");
            request.getRequestDispatcher("Registration.jsp").forward(request, response);
        }
    }

    /**
     * Validates a new user's registration by checking with the UserHandler class.
     *
     * @param username The new username to be registered.
     * @param password The new password associated with the username.
     * @return `true` if the user registration is successful, `false` otherwise.
     */
    private boolean isValidUser(String username, String password) {
        return UserHandler.addUser(username, password);
    }
}
