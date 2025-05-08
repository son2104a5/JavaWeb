package demo.ss02;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ForwardServlet", value = "/forward")
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("inputValue");

        req.setAttribute("inputValue", value);
        req.getRequestDispatcher("display.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}