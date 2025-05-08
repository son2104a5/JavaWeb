package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.UserManager;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
        getServletContext().setAttribute("userManager", userManager);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (name != null && email != null && !name.isEmpty() && !email.isEmpty()) {
            userManager.addUser(name, email);
            request.setAttribute("success", true);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("input.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");

        if ("delete".equals(action) && idParam != null) {
            int id = Integer.parseInt(idParam);
            userManager.removeUser(id);
        }

        response.sendRedirect("/listUser.jsp");
    }
}
