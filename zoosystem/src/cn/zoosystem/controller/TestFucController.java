package cn.zoosystem.controller;

import cn.zoosystem.dao.UserDAO;
import cn.zoosystem.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestFucController {
    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    public String testPost(Model model){
        System.out.println("get方式提示的testpost===========================");
        User user=new User();
        int id = 10;
        user.setUserId(id);
        user.setUserPassword("12345");
        user.setUserAccount("啾Test");
        UserDAO userDAO=new UserDAO();
        userDAO.addUser(user);
        return "index";
    }
    @RequestMapping(value = "/testpost",method = RequestMethod.GET)
    public String rTest(){
        return "tespost";
    }
}

