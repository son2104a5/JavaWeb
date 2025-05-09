//package demo.ss04;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import model.Student;
//
//@WebServlet(name = "StudentServlet", value = "/students")
//public class StudentServlet extends HttpServlet {
//    List<Student> students = new ArrayList<>();
//    @Override
//    public void init() throws ServletException {
//        students.add(new Student("John Doe", 8.5, "123 Main St"));
//        students.add(new Student("Jane Smith", 5.9, "456 Elm St"));
//        students.add(new Student("Alice Johnson", 7.8, "789 Oak St"));
//        students.add(new Student("Bob Brown", 4.2, "101 Pine St"));
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("students", students);
//        req.getRequestDispatcher("/index.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        double score = Double.parseDouble(req.getParameter("score"));
//        String address = req.getParameter("address");
//
//        students.add(new Student(name, score, address));
//        req.setAttribute("students", students);
//        req.getRequestDispatcher("/index.jsp").forward(req, resp);
//    }
//}