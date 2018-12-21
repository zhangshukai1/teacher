package com.tt.teach1219.dao;

import com.tt.teach1219.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    //登录方法
    @Select("select * from student where studentNo = #{studentNo} and loginPwd = #{loginPwd}")
    Student doLogin(Student student);
    //查询全部学生
    @Select("select student.*,grade.gradeName as gradeName from student,grade where student.gradeId=grade.gradeID")
    List<Student> getStudentList();
    //修改方法
    @Update("update student set loginPwd = #{loginPwd},studentName = #{studentName},phone = #{phone} where studentNo=#{studentNo}")
    int updateStuent(Student student);
    //删除方法
    @Delete("delete from student where studentNo = #{stuNo}")
    int deleteStudent(Integer stuNo);
}
