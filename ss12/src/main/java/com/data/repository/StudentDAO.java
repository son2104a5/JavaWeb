package com.data.repository;

import com.data.dto.StudentDTO;
import com.data.model.Student;

import java.util.List;

public interface StudentDAO {
    boolean addStudent(StudentDTO student);

    boolean updateStudent(StudentDTO student);

    boolean deleteStudent(int id);

    Student getStudentById(int id);

    List<Student> getAllStudents();
}
