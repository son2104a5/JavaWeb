package com.data.service;

import com.data.dto.StudentDTO;
import com.data.model.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(StudentDTO student);

    boolean updateStudent(StudentDTO student);

    boolean deleteStudent(int id);

    Student getStudentById(int id);

    List<Student> getAllStudents();
}
