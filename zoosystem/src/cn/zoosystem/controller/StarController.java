package cn.zoosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StarController {
    @RequestMapping(value = "/star",method = RequestMethod.GET)
    public String star(){
        return "star";
    }
}
