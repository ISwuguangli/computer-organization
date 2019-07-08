package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="purchase_info")
public class PurchaseInfo implements Serializable,Cloneable{
    /** 交易号 */
    @Id
    @GeneratedValue
    private int purchaseId ;
    /** 联系手机号 */
    private String userIphone ;
    /** 预定的时间段 */
    private int datetime ;
    /** 预定成交时间 */
    private Date purchaseTime ;
    /** 票价 */
    private Double price ;

    public PurchaseInfo(){

    }
    public PurchaseInfo(int purchaseId,String userIphone,int datetime,Date purchaseTime,Double price){
        this.purchaseId=purchaseId;
        this.userIphone=userIphone;
        this.datetime=datetime;
        this.purchaseTime=purchaseTime;
        this.price=price;
    }

    public PurchaseInfo(int purchaseId,PurchaseInfo purchaseInfo)
    {
        this.purchaseId=purchaseId;
        this.userIphone=purchaseInfo.getUserIphone();
        this.datetime=purchaseInfo.getDatetime();
        this.purchaseTime=purchaseInfo.getPurchaseTime();
        this.price=purchaseInfo.price;
    }

    /** 交易号 */
    public int getPurchaseId(){
        return this.purchaseId;
    }
    /** 交易号 */
    public void setPurchaseId(int purchaseId){
        this.purchaseId = purchaseId;
    }
    /** 联系手机号 */
    public String getUserIphone(){
        return this.userIphone;
    }
    /** 联系手机号 */
    public void setUserIphone(String userIphone){
        this.userIphone = userIphone;
    }
    /** 预定的时间段 */
    public int getDatetime(){
        return this.datetime;
    }
    /** 预定的时间段 */
    public void setDatetime(int datetime){
        this.datetime = datetime;
    }
    /** 预定成交时间 */
    public Date getPurchaseTime(){ return this.purchaseTime; }
    /** 预定成交时间 */
    public void setPurchaseTime(Date purchaseTime){
        this.purchaseTime = purchaseTime;
    }
    /** 票价 */
    public Double getPrice(){
        return this.price;
    }
    /** 票价 */
    public void setPrice(Double price){
        this.price = price;
    }
}