package cn.zoosystem.service;

import cn.zoosystem.dao.PurchaseDAO;
import cn.zoosystem.entity.PrePurchase;
import cn.zoosystem.entity.PurchaseInfo;
import cn.zoosystem.entity.User;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchaseService {

    public boolean buildPrePurchase(User user,String iphone,int dateTime,double price){
        int userId=user.getUserId();
        PurchaseDAO purchaseDAO=new PurchaseDAO();

        if(iphone!=null&&!iphone.equals("")&&(dateTime==0||dateTime==1||dateTime==2)&&price>=0)
        {
            Pattern pattern1= Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m1=pattern1.matcher(iphone);
            //手机号
            if(m1.matches()) {
                PrePurchase prePurchase = new PrePurchase(userId);
                PurchaseInfo purchaseInfo = new PurchaseInfo(userId, iphone, dateTime, new Date(), price);

                return purchaseDAO.addPrePurchase(prePurchase, purchaseInfo);
            }

        }
        return false;
    }

    public boolean concelPrePurchase(PrePurchase prePurchase)
    {
        PurchaseDAO purchaseDAO=new PurchaseDAO();
        if(purchaseDAO.queryPrePurchase(prePurchase)){
            purchaseDAO.deletePrePurchase(prePurchase);
        }
        return false;
    }

    public PurchaseInfo inquiryPrePurchaseInfomation(PrePurchase prePurchase)
    {
        PurchaseDAO purchaseDAO=new PurchaseDAO();
        PurchaseInfo purchaseInfo=new PurchaseInfo();
        purchaseInfo= purchaseDAO.queryPurchaseInfo(prePurchase);
        return purchaseInfo;
    }

    
}
