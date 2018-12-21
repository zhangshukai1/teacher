package com.tt.teach1219.controller;

import com.tt.teach1219.pojo.Student;
import com.tt.teach1219.service.StudentService;
import com.tt.teach1219.utils.BaseController;
import com.tt.teach1219.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController {
    @Resource
    private StudentService studentService;

    //登录映射
    @RequestMapping("/login")
    public String toString() {
        return "/student/login";
    }

    //页面映射
    @RequestMapping("/index")
    public String index() {
        String studentName = (String) getSession().getAttribute(SESSION_KEY);
        if (studentName!=null){
            return "/student/index";
        }
        return "/student/login";
    }

    //请求：http://localgost:8080/stu/student
    @RequestMapping("/student")
    public String student() {
        return "/student/student";
    }


    //登录方法
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(){
        String xuehao = getRequest().getParameter("studentNo");
        Integer studentNo = Integer.parseInt(xuehao);
        String loginPwd = getRequest().getParameter("loginPwd");
        Student student = new Student();
        student.setLoginPwd(loginPwd);
        student.setStudentNo(studentNo);
        Student student1 = studentService.doLogin(student);
        if (student1!=null){
            getSession().setAttribute(SESSION_KEY,student1.getStudentName());
            return FORWARD + "/stu/index";
        }
        return REDIRECT + "/stu/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        getSession().removeAttribute(SESSION_KEY);
        return REDIRECT + "/stu/login";
    }

    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    @ResponseBody
    private Object getStudentList (){
        List<Student> list = studentService.getStudentList();
        return list;
    }

    @RequestMapping(value = "/deleteStudent/{stuNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStudent(@PathVariable Integer stuNo){
        int result = studentService.deleteStudent(stuNo);
        if (result>0){
            return JsonResult.ok("删除成功!",result);
        }
        return JsonResult.ok("删除失败!",result);
    }

    @RequestMapping(value = "/updateStuent",method = RequestMethod.POST)
    public String updateStuent(){
        //获取学号密码姓名电话
        String xuehao = getRequest().getParameter("stuNo");
        Integer stuNo = Integer.parseInt(xuehao);
        String stuName = getRequest().getParameter("stuName");
        String stuPwd = getRequest().getParameter("stuPwd");
        String stuPhone = getRequest().getParameter("stuPhone");
        Student student = new Student();
        student.setStudentNo(stuNo);
        student.setStudentName(stuName);
        student.setLoginPwd(stuPwd);
        student.setPhone(stuPhone);
        int result = studentService.updateStuent(student);
        if (result>0){
            return FORWARD+"/stu/student";
        }
        return FORWARD+"/stu/student";
    }

}
