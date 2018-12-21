package com.tt.teach1219.controller;

import com.tt.teach1219.pojo.Result;
import com.tt.teach1219.service.ResultService;
import com.tt.teach1219.service.StudentService;
import com.tt.teach1219.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResultController {
    @Resource
    private ResultService resultService;

    @RequestMapping("/result")
    public String result() {
        return "/result/result";
    }

    @RequestMapping("/getResultList")
    @ResponseBody
    public Object getResultList() {
        List<Result> list = resultService.getResultList();
        return list;
    }

    @RequestMapping(value = "/deleteResult/{resultNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteResult(@PathVariable Integer resultNo) {
        int result = resultService.deleteResult(resultNo);
        if (result>0){
            return JsonResult.ok("删除成功",result);
        }
        return JsonResult.no("删除失败",result);
    }


    @RequestMapping(value = "/updateResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateResult(@RequestParam Integer resultNo,@RequestParam Integer studentResult) {
        Result result = new Result();
        result.setResultNo(resultNo);
        result.setStudentResult(studentResult);
        int result1 = resultService.updateResult(result);
        if (result1>0){
            return JsonResult.ok("修改成功",result);
        }
        return JsonResult.no("修改失败",result);
    }
}
