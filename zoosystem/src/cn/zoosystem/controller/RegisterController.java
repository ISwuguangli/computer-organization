package cn.zoosystem.controller;

import cn.zoosystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
//        model.addAttribute("rname",rname);
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String doRegister(Model model,String username,String rpassword,String cpassword){
        UserService dr = new UserService();
        System.out.println(username);
        if (!rpassword.equals(cpassword)){
            model.addAttribute("rMsg","两次密码不一样");
            System.out.println("第一个if");
            return "register";
        }
        if (dr.Register(username,rpassword)) {
            System.out.println("第2个if");
            return "nlogin";
        }else {
            System.out.println("第3个if");
            model.addAttribute("rMsg","啊哦，不知道为什么失败了，联系管理员试试");
            return "admin";
        }
//        User user=new User();
//        int id = 1;
//        user.setUserId(id);
//        user.setUserPassword("12345");
//        user.setUserAccount("啾啾咪");
//        UserDAO userDAO=new UserDAO();
//        userDAO.addUser(user);
    }
    @RequestMapping(value = "/cregister",method = RequestMethod.POST)
    public String doCRegister(Model model,String username,String rpassword,String cpassword){
        UserService dr = new UserService();
        System.out.println(username);
        if (!rpassword.equals(cpassword)){
            model.addAttribute("rMsg","两次密码不一样");
            System.out.println("第一个if");
            return "register";
        }
        if (dr.Register(username,rpassword)) {
            System.out.println("第2个if");
            return "clogin";
        }else {
            System.out.println("第3个if");
            model.addAttribute("rMsg","啊哦，不知道为什么失败了，联系管理员试试");
            return "admin";
        }
//        User user=new User();
//        int id = 1;
//        user.setUserId(id);
//        user.setUserPassword("12345");
//        user.setUserAccount("啾啾咪");
//        UserDAO userDAO=new UserDAO();
//        userDAO.addUser(user);
    }
}
