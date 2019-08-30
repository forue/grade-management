package iweb212.student.grademanagement.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import iweb212.student.grademanagement.model.Navigation;
import iweb212.student.grademanagement.model.Student;
import iweb212.student.grademanagement.model.User;
import iweb212.student.grademanagement.service.StudentService;
import iweb212.student.grademanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userservice;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginForm(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
             Model model

    ){
        User user = userservice.findUser(username,password);
        if( user == null){
            model.addAttribute("message","用户名或密码不正确");
            return "login";
        }
        model.addAttribute("user",user);
        return "redirect:home";
    }
    @RequestMapping(value = {"/home","/stuInfo"},method = RequestMethod.GET)
    public String home(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Student> students = new PageInfo<>(studentService.findAll());
        model.addAttribute("students",students);
        model.addAttribute("navTitle","学生成绩管理系统");
        List<Navigation> navs = new ArrayList<>();
        navs.add(new Navigation("学生信息","stuInfo"));
        navs.add(new Navigation("科目信息","subInfo"));
        navs.add(new Navigation("成绩信息","markInfo"));
        model.addAttribute("navs", navs);
        model.addAttribute("tabTitle",Arrays.asList("学号","姓名","年龄","操作"));
        //获得当前页
        model.addAttribute("pageNo", students.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", students.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", students.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", students.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", students.isIsLastPage());
        return "home";
    }
}
