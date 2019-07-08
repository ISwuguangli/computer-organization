package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="user_info")
public class UserInfo implements Serializable,Cloneable{
    /** 用户名 */

    @Id
    @GeneratedValue
    private int userId ;
    /** 手机号 */
    private String userIphone ;
    /** 真实姓名 */
    private String userName ;
    /** 身份证号 */
    private String userIdentify ;

    public UserInfo(){

    }
    public UserInfo(int userId,String userIphone,String userName,String userIdentify){
        this.userId=userId;
        this.userIdentify=userIdentify;
        this.userIphone=userIphone;
        this.userName=userName;
    }
    public UserInfo(String userIphone,String userName,String userIdentify){
        this.userIdentify=userIdentify;
        this.userIphone=userIphone;
        this.userName=userName;
    }
    /** 用户名 */
    public int getUserId(){
        return this.userId;
    }
    /** 用户名 */
    public void setUserId(int userId){
        this.userId = userId;
    }
    /** 手机号 */
    public String getUserIphone(){
        return this.userIphone;
    }
    /** 手机号 */
    public void setUserIphone(String userIphone){
        this.userIphone = userIphone;
    }
    /** 真实姓名 */
    public String getUserName(){
        return this.userName;
    }
    /** 真实姓名 */
    public void setUserName(String userName){
        this.userName = userName;
    }
    /** 身份证号 */
    public String getUserIdentify(){
        return this.userIdentify;
    }
    /** 身份证号 */
    public void setUserIdentify(String userIdentify){
        this.userIdentify = userIdentify;
    }
}