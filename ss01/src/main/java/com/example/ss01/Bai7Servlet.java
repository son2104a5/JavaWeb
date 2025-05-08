package com.example.ss01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Bai7Servlet", value = "/bai7")
public class Bai7Servlet extends HttpServlet {
    private static final List<Bai7> studentList = new ArrayList<>();

    static {
        // Dữ liệu mẫu ban đầu
        studentList.add(new Bai7("Nguyễn Văn A", "10A1", "Xe đạp", "75B1-123.45"));
        studentList.add(new Bai7("Trần Thị B", "11A3", "Xe máy", "75B2-456.78"));
    }

    public static void addStudent(Bai7 student) {
        studentList.add(student);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("students", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listStudent.jsp");
        dispatcher.forward(request, response);
    }
}