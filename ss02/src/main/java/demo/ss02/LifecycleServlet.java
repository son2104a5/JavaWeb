package demo.ss02;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Bai1", value = "/lifecycle")
public class LifecycleServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Bài 1:";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>1. init(): Servlet được khởi tạo một lần duy nhất khi có request đầu tiên hoặc khi ứng dụng khởi động.</p>");
        out.println("<p>2. service(): Được gọi mỗi khi có yêu cầu gửi đến Servlet (ở đây là doGet()).</p>");
        out.println("<p>3. destroy(): Được gọi một lần duy nhất khi Servlet bị loại khỏi bộ nhớ (server tắt hoặc reload).</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}