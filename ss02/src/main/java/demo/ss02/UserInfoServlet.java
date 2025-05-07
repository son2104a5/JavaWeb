package demo.ss02;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserInfoServlet", value = "/userinfo")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        req.setAttribute("username", username);
        req.setAttribute("age", age);

        req.getRequestDispatcher("/userinfo.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}