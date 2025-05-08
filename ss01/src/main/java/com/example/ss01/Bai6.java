package com.example.ss01;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Bai6", value = "/Bai6")
public class Bai6 extends HttpServlet {
    private String message;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRegister(request, response);
    }

    protected void handleRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String className = request.getParameter("className");
        String vehicleType = request.getParameter("vehicleType");
        String plateNumber = request.getParameter("plateNumber");

        boolean valid = fullName != null && !fullName.isEmpty()
                && className != null && !className.isEmpty()
                && vehicleType != null && !vehicleType.isEmpty();

        if (valid) {
            request.setAttribute("message", "Đăng ký vé xe thành công!");
            request.setAttribute("fullName", fullName);
            request.setAttribute("className", className);
            request.setAttribute("vehicleType", vehicleType);
            request.setAttribute("plateNumber", plateNumber);
        } else {
            request.setAttribute("message", "Đăng ký thất bại. Vui lòng điền đầy đủ thông tin.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("resultRegister.jsp");
        dispatcher.forward(request, response);
    }
}