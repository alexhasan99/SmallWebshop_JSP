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

    private boolean isValidUser (String username, String password){
        return UserHandler.addUser(username, password);
    }
}
