package com.tt.teach1219.service.impl;

import com.tt.teach1219.dao.StudentDao;
import com.tt.teach1219.pojo.Student;
import com.tt.teach1219.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    //登录
    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }


    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    @Transactional
    public int updateStuent(Student student) {
        return studentDao.updateStuent(student);
    }

    @Transactional
    public int deleteStudent(Integer stuNo) {
        return studentDao.deleteStudent(stuNo);
    }
}
