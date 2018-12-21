package com.tt.teach1219.service.impl;

import com.tt.teach1219.dao.ResultDao;
import com.tt.teach1219.pojo.Result;
import com.tt.teach1219.service.ResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{
    @Resource
    private ResultDao resultDao;

    //查询
    public List<Result> getResultList() {
        return resultDao.getResultList();
    }

    //删除方法
    @Transactional
    public int deleteResult(Integer resultNo) {
        return resultDao.deleteResult(resultNo);
    }

    //修改方法
    @Transactional
    public int updateResult(Result result) {
        return resultDao.updateResult(result);
    }
}
