package com.example.ss01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/job")
public class Bai8 extends HttpServlet {
    private ArrayList<Job> jobList;

    @Override
    public void init() throws ServletException {
        jobList = new ArrayList<>();
        jobList.add(new Job(1, "Design Website", "Completed"));
        jobList.add(new Job(2, "Develop Application", "Doing"));
        jobList.add(new Job(3, "Test Software", "Completed"));
        getServletContext().setAttribute("jobList", jobList);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jobName = request.getParameter("jobName");
        if (jobName != null && !jobName.trim().isEmpty()) {
            jobList = (ArrayList<Job>) getServletContext().getAttribute("jobList");
            int id = jobList.size() + 1;
            jobList.add(new Job(id, jobName, "Doing"));
        }
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String changeId = request.getParameter("changeId");
        if (changeId != null) {
            int id = Integer.parseInt(changeId);
            jobList = (ArrayList<Job>) getServletContext().getAttribute("jobList");
            for (Job j : jobList) {
                if (j.getId() == id) {
                    j.setStatus(j.getStatus().equals("Doing") ? "Completed" : "Doing");
                    break;
                }
            }
        }
        response.sendRedirect("index.jsp");
    }
}
