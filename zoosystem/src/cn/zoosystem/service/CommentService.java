package cn.zoosystem.service;

import cn.zoosystem.dao.CommentDAO;
import cn.zoosystem.entity.StarAnimal;
import cn.zoosystem.entity.User;
import cn.zoosystem.entity.UserComment;

import javax.xml.stream.events.Comment;

public class CommentService {

    public boolean addStarAnimal(String name,int zone_id,String zone_name)
    {
        CommentDAO commentDAO=new CommentDAO();
        if(!name.equals("")&&name!=null&&zone_id>=0&&!zone_name.equals("")&&zone_name!=null)
        {
            StarAnimal starAnimal=new StarAnimal();
            starAnimal.setAnimalName(name);
            starAnimal.setZoneId(zone_id);
            starAnimal.setZoneName(zone_name);
            commentDAO.addStarAnimal(starAnimal);
            commentDAO.addStarAnimal(starAnimal);
            return true;
        }
        return false;
    }

    public boolean deleteStarAnimal(StarAnimal starAnimal)
    {
        CommentDAO commentDAO=new CommentDAO();
        return commentDAO.deleteStarAnimal(starAnimal);
    }

    public boolean modifyStarAnimal(StarAnimal starAnimal)
    {
        CommentDAO commentDAO=new CommentDAO();
        return commentDAO.updateStarAnimal(starAnimal);
    }

    public boolean addComment(User user,StarAnimal starAnimal,String commentContent)
    {
        CommentDAO commentDAO=new CommentDAO();
        int userId=user.getUserId();
        int animalId=starAnimal.getAnimalId();
        if(!commentContent.equals("")&&commentContent!=null){
            UserComment userComment=new UserComment(userId,animalId);
            return commentDAO.addUserComment(userComment,commentContent);
        }
        return false;
    }

    public boolean deleteComment(UserComment userComment)
    {
        CommentDAO commentDAO=new CommentDAO();
        return commentDAO.deleteUserComment(userComment);
    }

}
