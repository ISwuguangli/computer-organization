package cn.zoosystem.service;

import cn.zoosystem.dao.UserDAO;
import cn.zoosystem.entity.User;
import cn.zoosystem.entity.UserInfo;
import cn.zoosystem.util.Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    public boolean Login(String username,String password)
    {
        if(username.equals("manager")&&password.equals("123456"))
        {
            Constant.permission=0;
        }
        if(username!=null&&!username.equals("")&&password!=null&&!password.equals(""))
        {
            User user=new User(username,password);
            UserDAO userDAO=new UserDAO();
            boolean flag=userDAO.queryUser(user);
            if(flag){return true;}
            else{return false;}
        }else {
            return false;
        }
    }

    public boolean Register(String username,String password){
        if(username!=null&&!username.equals("")&&password!=null&&!password.equals(""))
        {
            User user=new User(username,password);
            UserDAO userDAO=new UserDAO();
            boolean flag=userDAO.addUser(user);
            if(flag){return true;}
            else{return false;}
        }else {
            return false;
        }
    }

    public boolean improveUserInfomation(User user,String iphone,String name,String identity)
    {
        int userId=user.getUserId();
        UserDAO userDAO=new UserDAO();
        UserInfo userInfo;
        if(!iphone.equals("")&&iphone!=null
                &&name.equals("")&&name!=null
                &&identity.equals("")&&identity!=null)
        {
            Pattern pattern1= Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m1=pattern1.matcher(iphone);
            //手机号
            Pattern pattern2= Pattern.compile("^(?!.*\\..*\\.)[\\u4e00-\\u9fa5]([\\u4e00-\\u9fa5\\.]*|[A-Za-z\\.]*)$");
            Matcher m2=pattern2.matcher(name);
            //姓名
            Pattern pattern3= Pattern.compile("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)");
            Matcher m3=pattern3.matcher(identity);
            //身份证号
            if(m1.matches()&&m2.matches()&&m3.matches())
            {
                userInfo=new UserInfo(userId,iphone,name,identity);
                userDAO.updateUserInfo(userInfo);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean modifyUserPassword(String account,String password)
    {
        UserDAO userDAO=new UserDAO();
        if(!password.equals("")&&password!=null){
            User user=new User(account,password);
            return userDAO.updateUser(user);
        }
        return false;
    }



}
