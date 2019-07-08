package cn.zoosystem.dao;

import cn.zoosystem.entity.User;
import cn.zoosystem.entity.UserInfo;
import cn.zoosystem.util.DBUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean queryUser(User user){
        Connection conn = DBUtil.getConn();
        String sql="select * from user where user_account=? and user_password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserAccount());
            ps.setString(2, user.getUserPassword());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            DBUtil.closeConn();
        }
    }

    public boolean queryUser(String user_account){
        Connection conn = DBUtil.getConn();
        String sql="select * from user where user_account=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_account);
            ResultSet rs = ps.executeQuery();
            System.out.println("ps.resultSet="+rs.next()+"======================");
            if(rs.next()){
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            DBUtil.closeConn();
        }
    }

    public boolean addUser(User users){
        Connection conn = DBUtil.getConn();
        String sql="insert into user(user_account,user_password) values (?,?)";
        if(!queryUser(users.getUserAccount())){
            try {
                initUserInfo(new UserInfo(null,null,null));
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, users.getUserAccount());
                ps.setString(2, users.getUserPassword());
                int i = ps.executeUpdate();
                if(i>0)
                {
                    return true;
                }
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }finally{
                DBUtil.closeConn();
            }
        }else{
            return false;
        }
    }

//    public boolean deleteUser(User user)
//    {
//        Connection conn=DBUtil.getConn();
//        String sql="delete from user where user_id=?";
//        try{
//            PreparedStatement ps=conn.prepareStatement(sql);
//            if(ps.execute())
//            {
//                System.out.println("删除成功");
//                return true;
//            }else{
//                System.out.println("删除失败");
//                return false;
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//            return false;
//        }finally {
//            DBUtil.closeConn();
//        }
//    }

    public boolean initUserInfo(UserInfo userInfo)
    {
        Connection conn=DBUtil.getConn();
        String sql="insert into user_info(user_iphone,user_name,user_identify) values(?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,userInfo.getUserIphone());
            ps.setString(2,userInfo.getUserName());
            ps.setString(3,userInfo.getUserIdentify());
            int i=ps.executeUpdate();
            if(i>0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeConn();
        }
    }

    public boolean updateUserInfo(UserInfo userInfo)
    {
        Connection conn=DBUtil.getConn();
        String sql="update user_info set user_iphone=?,user_name=?,user_identify=? where user_id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,userInfo.getUserIphone());
            ps.setString(2,userInfo.getUserName());
            ps.setString(3,userInfo.getUserIdentify());
            ps.setInt(4,userInfo.getUserId());
            int i=ps.executeUpdate();
            if(i>0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user)
    {
        Connection conn=DBUtil.getConn();
        String sql="update user set user_password=? where user_accout=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUserPassword());
            ps.setString(2,user.getUserAccount());
            int i=ps.executeUpdate();
            if(i>0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
