package cn.zoosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//主页控制器
@Controller
public class HomeController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getHome(Model model){
        System.out.println("get方式提示的home===========================");
        return "home";
    }
}
