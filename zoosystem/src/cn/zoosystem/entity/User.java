package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="user")
public class User implements Serializable,Cloneable{
    /** 用户id */
    @Id
    @GeneratedValue
    private int userId ;
    /** 账号 */
    private String userAccount ;
    /** 密码 */
    private String userPassword ;

    public User(){

    }

    public User(String userAccount,String userPassword){
        this.userAccount=userAccount;
        this.userPassword=userPassword;
    }

    public User(int userId,String userPassword,String userAccount)
    {
        this.userId=userId;
        this.userPassword=userPassword;
        this.userAccount=userAccount;
    }


    /** 用户id */
    public int getUserId(){
        return this.userId;
    }
    /** 用户id */
    public void setUserId(int userId){
        this.userId = userId;
    }
    /** 账号 */
    public String getUserAccount(){
        return this.userAccount;
    }
    /** 账号 */
    public void setUserAccount(String userAccount){
        this.userAccount = userAccount;
    }
    /** 密码 */
    public String getUserPassword(){
        return this.userPassword;
    }
    /** 密码 */
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
}