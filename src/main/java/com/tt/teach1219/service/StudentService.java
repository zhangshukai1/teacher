package com.tt.teach1219.service;

import com.tt.teach1219.pojo.Student;

import java.util.List;

public interface StudentService {
    Student doLogin(Student student);

    List<Student> getStudentList();

    int updateStuent(Student student);

    int deleteStudent(Integer stuNo);
}
