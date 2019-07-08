package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="pre_purchase")
public class PrePurchase implements Serializable,Cloneable{
    /** 用户id */
    private int userId ;
    /** 交易号 */
    @Id
    @GeneratedValue
    private int purchaseId ;

    public PrePurchase(){

    }

    public PrePurchase(int userId)
    {
        this.userId=userId;
    }

    /** 用户id */
    public int getUserId(){
        return this.userId;
    }
    /** 用户id */
    public void setUserId(int userId){
        this.userId = userId;
    }
    /** 交易号 */
    public int getPurchaseId(){
        return this.purchaseId;
    }
    /** 交易号 */
    public void setPurchaseId(int purchaseId){
        this.purchaseId = purchaseId;
    }
}
