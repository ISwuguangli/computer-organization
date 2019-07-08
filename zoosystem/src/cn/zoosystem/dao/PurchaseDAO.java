package cn.zoosystem.dao;

import cn.zoosystem.entity.PrePurchase;
import cn.zoosystem.entity.PurchaseInfo;
import cn.zoosystem.entity.User;
import cn.zoosystem.util.DBUtil;

import java.sql.*;

public class PurchaseDAO {
    public boolean queryPrePurchase(PrePurchase prePurchase){
        Connection conn = DBUtil.getConn();
        String sql="select * from user where user_id=? and purchase_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, prePurchase.getUserId());
            ps.setInt(2, prePurchase.getPurchaseId());
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

    public PurchaseInfo queryPurchaseInfo(PrePurchase prePurchase){
        Connection conn = DBUtil.getConn();
        String sql="select * from user where purchase_id=?";
        PurchaseInfo purchaseInfo=new PurchaseInfo();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, prePurchase.getPurchaseId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                purchaseInfo.setPurchaseId(rs.getInt("purchase_id"));
                purchaseInfo.setUserIphone(rs.getString("user_iphone"));
                purchaseInfo.setDatetime(rs.getInt("datetime"));
                purchaseInfo.setPurchaseTime(rs.getDate("purchase_time"));
                purchaseInfo.setPrice(rs.getDouble("price"));
                return purchaseInfo;
            }else{
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally{
            DBUtil.closeConn();
        }
    }

    public boolean addPrePurchase(PrePurchase prePurchase,PurchaseInfo purchaseInfo){
        Connection conn = DBUtil.getConn();
        String sql="insert into pre_purchase(user_id) values (?)";
        try {
            initPurchaseInfo(purchaseInfo);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, prePurchase.getUserId());

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
    }

    public boolean initPurchaseInfo(PurchaseInfo purchaseInfo)
    {
        Connection conn=DBUtil.getConn();
        String sql="insert into purchase_info(user_iphone,datetime,purchase_time,price) values (?,?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,purchaseInfo.getUserIphone());
            ps.setInt(2,purchaseInfo.getDatetime());
            ps.setDate(3, new Date(purchaseInfo.getPurchaseTime().getTime()));
            ps.setDouble(4,purchaseInfo.getPrice());
            int i=ps.executeUpdate();
            if(i>0){
                return true;
            }
            return false;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeConn();
        }
    }

    public boolean deletePrePurchase(PrePurchase prePurchase)
    {
        Connection conn=DBUtil.getConn();
        String sql="delete from Prepurchase where user_id=? and purchase_id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            if(ps.execute())
            {
                System.out.println("删除成功");
                return true;
            }else{
                System.out.println("删除失败");
                return false;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeConn();
        }
    }

    public boolean updatePurchaseInfo(PurchaseInfo purchaseInfo)
    {
        Connection conn=DBUtil.getConn();
        String sql="update purchase_info set user_iphone=?,datetime=?,purchase_time=?,price=? where purchase_id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,purchaseInfo.getUserIphone());
            ps.setInt(2,purchaseInfo.getDatetime());
            ps.setDate(3,new Date(purchaseInfo.getPurchaseTime().getTime()));
            ps.setDouble(4,purchaseInfo.getPrice());
            ps.setInt(5,purchaseInfo.getPurchaseId());
            int i=ps.executeUpdate();
            if(i>0){
                return true;
            }
            return false;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeConn();
        }
    }
}
