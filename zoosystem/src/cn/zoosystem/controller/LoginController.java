package cn.zoosystem.controller;

import cn.zoosystem.entity.User;
import cn.zoosystem.dao.UserDAO;
import cn.zoosystem.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    /*
    * 大概的逻辑，后面再写详细的
    * */
    //测试添加数据成功，最后这里应该是find方法
    //这里是reserve界面跳转的处理方法
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginCheck(Model model,
                             @RequestParam  String username, @RequestParam String password,
                             HttpServletRequest request, HttpServletResponse response){
        System.out.println("post方式提示的login===========================");
        UserService lc = new UserService();
        System.out.println(username);
        System.out.println(password);
        System.out.println(lc.Login(username,password));
        if(lc.Login(username,password)){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            if (username.equals("马佳达")){
                return"re";
            }else{
                return "reserve";
            }
        }
        return "register";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        System.out.println("get方式提示的login===========================");
//        User user=new User();
//        int id = 1;
//        user.setUserId(id);
//        user.setUserPassword("12345");
//        user.setUserAccount("啾啾咪");
//        UserDAO userDAO=new UserDAO();
//        userDAO.addUser(user);
        return "login";
    }
//    @RequestMapping(value = "/rlogin",method = RequestMethod.GET)
//    public String rlogin(Model model,@RequestParam String username,@RequestParam String password,
//                         HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
//        System.out.println("post方式提示的login===========================");
//        UserService lc = new UserService();
//        if(lc.Login(username,password)){
//            HttpSession session = httpServletRequest.getSession();
//            session.setAttribute("username",username);
//            return "rerserve";
//        }
//        return "home";
//    }
    @RequestMapping(value = "/nlogin",method = RequestMethod.GET)
    public String nlogin(){
        return "nlogin";
    }
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(Model model){return "index";}
    @RequestMapping(value = "/clogin",method = RequestMethod.POST)
    public String cloginCheck(Model model,
                              @RequestParam  String username, @RequestParam String password,
                              HttpServletRequest request, HttpServletResponse response){
        System.out.println("post方式提示的login===========================");
        UserService lc = new UserService();
        System.out.println(username);
        System.out.println(password);
        System.out.println(lc.Login(username,password));
        if(lc.Login(username,password)){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            return "star";
        }
        return "home";
    }
}
