package com.tt.teach1219.dao;

import com.tt.teach1219.pojo.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResultDao {
    //查询
    @Select("SELECT result.*,student.studentName AS studentName,subject.subjectName AS subjectName FROM result,student,subject WHERE result.studentNo = student.studentNo AND result.subjectNo = subject.subjectNo ORDER BY result.examDate DESC ")
    List<Result> getResultList();
    //删除方法
    @Delete("delete from result where resultNo = #{resultNo}")
    int deleteResult(Integer resultNo);
    //修改方法
    @Update("update result set studentResult = #{studentResult} where resultNo = #{resultNo}")
    int updateResult(Result result);
}
