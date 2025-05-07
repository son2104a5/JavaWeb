package demo.ss02;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserRegistrationServlet", value = "/registerUser")
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Đăng ký người dùng</title></head><body>");
        out.println("<h2>Form Đăng Ký</h2>");
        out.println("<form method='post' action='registerUser'>");
        out.println("Họ tên: <input type='text' name='name' required><br><br>");
        out.println("Email: <input type='email' name='email' required><br><br>");
        out.println("Mật khẩu: <input type='password' name='password' required><br><br>");
        out.println("<input type='submit' value='Đăng ký'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        request.setAttribute("name", name);
        request.setAttribute("email", email);

        RequestDispatcher dispatcher = request.getRequestDispatcher("displayInfo.jsp");
        dispatcher.forward(request, response);
    }
}
