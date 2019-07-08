package cn.zoosystem.dao;

import cn.zoosystem.entity.CommentInfo;
import cn.zoosystem.entity.StarAnimal;
import cn.zoosystem.entity.UserComment;
import cn.zoosystem.util.DBUtil;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDAO {
    public boolean addUserComment(UserComment userComment,String commentContent){
        Connection conn= DBUtil.getConn();
        String sql="insert into user_comment(user_id,animal_id) values(?,?)";
        try{
            initCommentInfo(new CommentInfo(commentContent,new Date()));
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,userComment.getUserId());
            ps.setInt(2,userComment.getAnimalId());
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

    public boolean initCommentInfo(CommentInfo commentInfo){
        Connection conn=DBUtil.getConn();
        String sql="insert into comment_info(comment_content,comment_datetime) values(?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,commentInfo.getCommentContent());
            ps.setDate(2,new java.sql.Date(commentInfo.getCommentDatetime().getTime()));
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
    public boolean deleteUserComment(UserComment userComment){
        Connection conn=DBUtil.getConn();
        String sql="delete from user_comment where user_id=? and comment_id=? and animal_id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,userComment.getUserId());
            ps.setInt(2,userComment.getCommentId());
            ps.setInt(3,userComment.getAnimalId());
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

    public boolean addStarAnimal(StarAnimal starAnimal){
        Connection conn=DBUtil.getConn();
        String sql="insert user_comment(animal_name,zone_id,zone_name) values(?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,starAnimal.getAnimalName());
            ps.setInt(2,starAnimal.getZoneId());
            ps.setString(3,starAnimal.getZoneName());

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

    public boolean deleteStarAnimal(StarAnimal starAnimal){
        Connection conn=DBUtil.getConn();
        String sql="delete from star_animal where animal_id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,starAnimal.getAnimalId());
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

    public boolean updateStarAnimal(StarAnimal starAnimal)
    {
        Connection conn=DBUtil.getConn();
        String sql="Update star_animal set animal_name=?,zone_id=?,zone_name=? where animal_id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,starAnimal.getAnimalName());
            ps.setInt(2,starAnimal.getZoneId());
            ps.setString(3,starAnimal.getZoneName());
            ps.setInt(4,starAnimal.getAnimalId());
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
