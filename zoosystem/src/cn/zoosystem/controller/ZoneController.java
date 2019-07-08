package cn.zoosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ZoneController {
    //页面返回
    @RequestMapping(value = "/zone",method = RequestMethod.GET)
    public String zone(){
        return "zone";
    }
    @RequestMapping(value = "/giraffe",method = RequestMethod.GET)
    public String giraffe(){
        return "giraffe";
    }
    @RequestMapping(value = "/elephant",method = RequestMethod.GET)
    public String elephant(){
        return "elephant";
    }
    @RequestMapping(value = "/penguin",method = RequestMethod.GET)
    public String penguin(){
        return "penguin";
    }
    @RequestMapping(value = "/koala",method = RequestMethod.GET)
    public String koala(){
        return "koala";
    }
    @RequestMapping(value = "/sea",method = RequestMethod.GET)
    public String sea(){
        return "sea";
    }
    @RequestMapping(value = "/bird",method = RequestMethod.GET)
    public String bird(){
        return "bird";
    }
    @RequestMapping(value = "/monkey",method = RequestMethod.GET)
    public String monkey(){
        return "monkey";
    }
}
