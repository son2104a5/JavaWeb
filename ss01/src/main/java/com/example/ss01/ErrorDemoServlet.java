package com.example.ss01;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class ErrorDemoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cố tình gây lỗi NullPointerException
        String text = null;
        text.length(); // gây lỗi
    }
}
