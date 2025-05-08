<%@ page import="java.util.*, com.example.ss01.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List</title>
    <style>
        body { font-family: Arial; }
        table { border-collapse: collapse; width: 100%; }
        th, td { padding: 10px; text-align: center; border: 1px solid #000; }
        .doing { background-color: yellow; }
        .completed { background-color: #8888ff; }
        input[type="text"] { padding: 10px; width: 300px; }
        input[type="submit"] { padding: 10px 20px; background: #6666ff; border: none; color: white; border-radius: 8px; }
    </style>
</head>
<body>
<form action="job" method="post">
    <input type="text" name="jobName" placeholder="Enter new job" />
    <input type="submit" value="Add" />
</form>
<br/>
<table>
    <tr><th>ID</th><th>Job Name</th><th>Status</th><th>Action</th></tr>
    <%
        ArrayList<Job> jobs = (ArrayList<Job>) application.getAttribute("jobList");
        for (Job job : jobs) {
            String rowClass = job.getStatus().equals("Doing") ? "doing" : "completed";
    %>
    <tr class="<%= rowClass %>">
        <td><%= job.getId() %></td>
        <td><%= job.getName() %></td>
        <td><%= job.getStatus() %></td>
        <td>
            <form action="job" method="get">
                <input type="hidden" name="changeId" value="<%= job.getId() %>" />
                <input type="submit" value="Change status" />
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
