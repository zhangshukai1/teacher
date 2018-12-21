package com.tt.teach1219.pojo;

import java.io.Serializable;

/**
 * 实体类年级类
 */
public class Grade implements Serializable {
    private Integer gradeID;
    private String gradeName;

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }

    public Grade() {
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
