package pl.welcomeservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/WelcomeServlet",
        initParams = {@WebInitParam(name = "defaultUsername", value = "Nieznajomy")})
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        if (username == null || "".equals(username)) {
            username = getServletConfig().getInitParameter("defaultUsername");
        }
        sendResponse(response, username);
    }

    private void sendResponse(HttpServletResponse response, String username) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Witaj " + username + "</title></head>");
        writer.println("<body>");
        writer.println("<h1>Witaj " + username + "</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
}