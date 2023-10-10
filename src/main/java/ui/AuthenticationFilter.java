/**
 * A filter class responsible for authentication and authorization of users before accessing specific web pages.
 * This filter ensures that users are logged in before allowing access to certain pages.
 */
package ui;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/home", "/shoppingCart"})
public class AuthenticationFilter implements Filter {


    /**
     * Performs authentication and authorization checks before allowing access to specific web pages.
     *
     * @param request  The ServletRequest object.
     * @param response The ServletResponse object.
     * @param chain    The FilterChain for invoking the next filter or servlet in the chain.
     * @throws IOException      If an I/O error occurs.
     * @throws ServletException If a servlet-specific error occurs.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            // The user is not logged in, redirect to the login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
