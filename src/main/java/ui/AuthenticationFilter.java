package ui;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/home")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
        // Initiera filter om det behövs
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Kontrollera om användaren är inloggad genom att kolla om sessionen finns
        if (session == null || session.getAttribute("username") == null) {
            // Användaren är inte inloggad, omdirigera till inloggningssidan
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        } else {
            // Användaren är inloggad, låt förfrågan fortsätta till önskad sida
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Stäng filter om det behövs
    }
}