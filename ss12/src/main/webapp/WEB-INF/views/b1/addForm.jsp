<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
<html>
<head>
    <title>Add Form</title>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
<div class="bg-white p-8 rounded-xl shadow-md w-full max-w-4xl">
    <h2 class="text-2xl font-semibold mb-6 text-gray-800">Add Student</h2>
    <form:form modelAttribute="student" action="/students/add" method="post" class="space-y-4">
        <div>
            <label class="block text-sm font-medium text-gray-700">Name</label>
            <form:input path="name" placeholder="Name"
                        cssClass="mt-1 block w-full rounded-md border-gray-300 shadow-sm p-2 focus:border-blue-500 focus:ring focus:ring-blue-200 focus:ring-opacity-50"/>
            <form:errors path="name" class="text-red-500 text-sm mt-1"/>
        </div>
        <div>
            <label class="block text-sm font-medium text-gray-700">Email</label>
            <form:input path="email" placeholder="Email"
                        cssClass="mt-1 block w-full rounded-md border-gray-300 shadow-sm p-2 focus:border-blue-500 focus:ring focus:ring-blue-200 focus:ring-opacity-50"/>
            <form:errors path="email" class="text-red-500 text-sm mt-1"/>
        </div>
        <div>
            <label class="block text-sm font-medium text-gray-700">Date of Birth</label>
            <form:input type="date" path="dob"
                        cssClass="mt-1 block w-full rounded-md border-gray-300 shadow-sm p-2 focus:border-blue-500 focus:ring focus:ring-blue-200 focus:ring-opacity-50"/>
            <form:errors path="dob" class="text-red-500 text-sm mt-1"/>
        </div>
        <div>
            <form:button type="submit"
                         class="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-lg transition duration-300">
                Add Student
            </form:button>
            <button class="w-full mt-2 bg-red-600 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-lg transition duration-300" type="button" onclick="window.location.href='/students'">
                Back
            </button>
        </div>
    </form:form>
</div>

</body>
</html>