package cn.zoosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {
    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public String notice(){
        return "notice";
    }
}
