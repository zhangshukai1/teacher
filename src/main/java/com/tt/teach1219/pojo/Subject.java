package com.tt.teach1219.pojo;

import java.io.Serializable;

/**
 * 科目的实体类
 */
public class Subject implements Serializable {
    private Integer subjectNo;
    private String subjectName;
    private Integer classHour;
    private Integer gradeID;

    public Subject(Integer subjectNo, String subjectName, Integer classHour, Integer gradeID) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.classHour = classHour;
        this.gradeID = gradeID;
    }

    public Subject() {
    }

    public Integer getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(Integer subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }
}
