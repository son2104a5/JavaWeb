package com.example.ss01;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Bai1", value = "/Bai1")
public class Bai1 extends HttpServlet {
    private String message;

    public void init() {
        message = "Bài 1";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>" +
                "<p>" +
                "Sơ đồ kiến trúc:\n" +
                "[Client (Browser)]\n" +
                "        |\n" +
                "        v\n" +
                "[Web Server (Apache/Nginx)]\n" +
                "        |\n" +
                "        v\n" +
                "[Application Server (Tomcat/JBoss/Spring Boot)]\n" +
                "        |\n" +
                "        v\n" +
                "[Database (MySQL/PostgreSQL/Oracle)]\n" +
                "Chức năng từng thành phần:\n" +
                "Client (Trình duyệt web):\n" +
                "Giao diện người dùng. Gửi yêu cầu HTTP đến Web Server và hiển thị kết quả trả về từ ứng dụng web.\n" +
                "\n" +
                "Web Server (Apache/Nginx):\n" +
                "Xử lý các yêu cầu tĩnh (HTML, CSS, JS), load balancing và chuyển tiếp các yêu cầu động đến Application Server.\n" +
                "\n" +
                "Application Server (Tomcat/Spring Boot):\n" +
                "Nơi xử lý logic nghiệp vụ Java, gọi đến database để lấy dữ liệu, xử lý và trả về kết quả cho client.\n" +
                "\n" +
                "Database (MySQL/PostgreSQL):\n" +
                "Lưu trữ dữ liệu của hệ thống. Thực hiện các truy vấn và cung cấp dữ liệu khi Application Server yêu cầu.\n" +
                "Đoạn văn mô tả:\n" +
                "Khi người dùng truy cập ứng dụng web qua trình duyệt (Client), một yêu cầu HTTP được gửi đến Web Server. " +
                "Web Server tiếp nhận yêu cầu và nếu đó là nội dung " +
                "tĩnh, nó phản hồi trực tiếp; nếu là yêu cầu động, nó " +
                "chuyển tiếp đến Application Server. Tại đây, Application Server xử lý nghiệp vụ, " +
                "truy vấn dữ liệu từ Database, rồi xây dựng phản hồi (thường là HTML/JSON) và trả lại cho " +
                "Web Server. Cuối cùng, Web Server chuyển dữ liệu trả về cho Client để hiển thị. Quá trình " +
                "này diễn ra nhanh và liên tục, đảm bảo trải nghiệm người dùng mượt mà và ổn định.</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}