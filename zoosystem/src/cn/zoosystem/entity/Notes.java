package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="notes")
public class Notes implements Serializable,Cloneable{
    /** 公告号 */
    @Id
    @GeneratedValue
    private Integer noteId ;
    /** 公告内容 */
    private String noteComment ;

    public Notes(){

    }
    public Notes(int noteId,String noteComment){
        this.noteId=noteId;
        this.noteComment=noteComment;
    }
    public Notes(String noteComment)
    {
        this.noteComment=noteComment;
    }
    /** 公告号 */
    public Integer getNoteId(){
        return this.noteId;
    }
    /** 公告号 */
    public void setNoteId(Integer noteId){
        this.noteId = noteId;
    }
    /** 公告内容 */
    public String getNoteComment(){
        return this.noteComment;
    }
    /** 公告内容 */
    public void setNoteComment(String noteComment){
        this.noteComment = noteComment;
    }
}