package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="user_comment")
public class UserComment implements Serializable,Cloneable{
    /** 用户id */
    private int userId ;
    /** 评论号 */
    @Id
    @GeneratedValue
    private int commentId ;
    /** 明星动物id */
    private int animalId ;
    public UserComment(){

    }

    public UserComment(int userId,int commentId,int animalId){
        this.userId=userId;
        this.commentId=commentId;
        this.animalId=animalId;
    }

    public UserComment(int userId,int animalId)
    {
        this.userId=userId;
        this.animalId=animalId;
    }

    /** 用户id */
    public int getUserId(){
        return this.userId;
    }
    /** 用户id */
    public void setUserId(int userId){
        this.userId = userId;
    }
    /** 评论号 */
    public int getCommentId(){
        return this.commentId;
    }
    /** 评论号 */
    public void setCommentId(int commentId){
        this.commentId = commentId;
    }
    /** 明星动物id */
    public int getAnimalId(){
        return this.animalId;
    }
    /** 明星动物id */
    public void setAnimalId(int animalId){
        this.animalId = animalId;
    }
}
