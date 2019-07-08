package cn.zoosystem.dao;

import cn.zoosystem.entity.CommentInfo;
import cn.zoosystem.entity.Notes;
import cn.zoosystem.entity.PrePurchase;
import cn.zoosystem.entity.UserComment;
import cn.zoosystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class NotesDAO {
    public boolean addNoteContent(String noteContent){
        Connection conn= DBUtil.getConn();
        String sql="insert notes(note_comment) values(?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,noteContent);
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

    public boolean deleteNoteContent(Notes notes)
    {
        Connection conn=DBUtil.getConn();
        String sql="delete from notes where note_id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,notes.getNoteId());
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

    public String queryNotesContent(Notes notes){
        Connection conn = DBUtil.getConn();
        String sql="select note_comment from notes where note_id=?";
        String comment="";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, notes.getNoteComment());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                comment=rs.getString("note_comment");
                return comment;
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
}
