package cn.zoosystem.controller;

import cn.zoosystem.entity.User;
import cn.zoosystem.service.PurchaseService;
import cn.zoosystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ReserveController {
    @RequestMapping(value = "/reserve",method = RequestMethod.GET)
    public String reserve(Model model){
        return "reserve";
    }
    @RequestMapping(value = "/doreserve",method = RequestMethod.POST)
    public String doReserve(Model model,
                            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                            String iphone,int price){
        //判断手机号
        Pattern pattern1= Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m1=pattern1.matcher(iphone);
        if (!m1.matches()){
            model.addAttribute("nmatch","手机都填错啦,重填");
            return "reserve";
        }else {
            //得到user
            HttpSession session = httpServletRequest.getSession();
            String name = (String)session.getAttribute("username");
            String pwd = (String)session.getAttribute("password");
            System.out.println("commentControle获得的name"+name+"password =="+pwd);
            User user = new User(name,pwd);
            //得到
            int date = (price-30)/10;
            System.out.println("date =="+date);
            System.out.println("p =="+price);
            System.out.println("i =="+iphone);
            int pr = price*10+30;
            PurchaseService purchaseService = new PurchaseService();
            if (purchaseService.buildPrePurchase(user,iphone,date,price)){
                model.addAttribute("nmatch","预定成功啦");
                return "reserve";
            }
            return "admin";
        }
    }
}
