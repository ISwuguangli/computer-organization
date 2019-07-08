package cn.zoosystem.controller;

import cn.zoosystem.entity.StarAnimal;
import cn.zoosystem.entity.User;
import cn.zoosystem.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class commentController {
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public String comment(Model model, HttpServletRequest httpServletRequest,
                          HttpServletResponse response,String cmsg){
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("username")!=null){
            String name = (String)session.getAttribute("username");
            String pwd = (String)session.getAttribute("password");
            System.out.println("commentControle获得的name"+name+"password =="+pwd);
            User user = new User(name,pwd);
            StarAnimal starAnimal = new StarAnimal("亚历山大",1,"猴山");
            CommentService cs = new CommentService();
            boolean ccs = cs.addComment(user,starAnimal,cmsg);
                System.out.println("走到这里了没");
                model.addAttribute("commentMsg",cmsg);
                model.addAttribute("say","comment:");
                model.addAttribute("name",name);
                return "star";

        }else{
            System.out.println("没有登啦");
            return "commentLogin";
        }
    }
}
