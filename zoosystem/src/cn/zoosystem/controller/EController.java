package cn.zoosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EController {
    @RequestMapping(value = "/re",method = RequestMethod.GET)
    public String re(Model model){
        return "re";
    }
}
