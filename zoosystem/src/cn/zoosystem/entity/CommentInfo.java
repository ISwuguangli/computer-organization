package cn.zoosystem.entity;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.util.Date;


@Table(name="comment_info")
public class CommentInfo implements Serializable,Cloneable{
    /** 评论号 */
    @Id
    @GeneratedValue
    private int commentId ;
    /** 评论内容 */
    private String commentContent ;
    /** 评论日期 */
    private Date commentDatetime ;

    public CommentInfo(){

    }
    public CommentInfo(int commentId,String commentContent,Date commentDatetime){
        this.commentId=commentId;
        this.commentContent=commentContent;
        this.commentDatetime=commentDatetime;
    }
    public CommentInfo(String commentContent,Date commentDatetime){
        this.commentContent=commentContent;
        this.commentDatetime=commentDatetime;
    }
    /** 评论号 */
    public int getCommentId(){
        return this.commentId;
    }
    /** 评论号 */
    public void setCommentId(int commentId){
        this.commentId = commentId;
    }
    /** 评论内容 */
    public String getCommentContent(){
        return this.commentContent;
    }
    /** 评论内容 */
    public void setCommentContent(String commentContent){
        this.commentContent = commentContent;
    }
    /** 评论日期 */
    public Date getCommentDatetime(){
        return this.commentDatetime;
    }
    /** 评论日期 */
    public void setCommentDatetime(Date commentDatetime){
        this.commentDatetime = commentDatetime;
    }
}