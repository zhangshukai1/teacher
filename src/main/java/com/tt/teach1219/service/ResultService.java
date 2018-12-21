package com.tt.teach1219.service;

import com.tt.teach1219.pojo.Result;

import java.util.List;

public interface ResultService {
    List<Result> getResultList();
    //删除
    int deleteResult(Integer resultNo);
    //修改
    int updateResult(Result result);
}
