package cn.zoosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("test","testString");
        return "test";
    }
    @RequestMapping(value = "/js",method = RequestMethod.GET)
    public String testJs(Model model){
        return "fontTest";
    }
}
