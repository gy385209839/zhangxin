package com.itheima.domain;

import com.itheima.utils.MyDateEdit;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/29 9:23
 * @Version: 1.0
 */


public class Orders {
    private String id;
    private String orderNum;
    private String orderTimeStr;
    private Date orderTime;
    private int orderStatus;
    private String orderStatusstr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }

    public String getPayTypestr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if(peopleCount==0){
            payTypeStr="支付宝";
        }
        if(peopleCount==1){
            payTypeStr="微信";
        }
        if(peopleCount==2){
            payTypeStr="其它";
        }
        return payTypeStr;
    }

    public void setPayTypestr(String payTypestr) {
        this.payTypeStr = payTypestr;
    }

    public String getOrderStatusstr() {
        if(orderStatus==1){
            orderStatusstr="已支付";
        }
        if(orderStatus==0){
            orderStatusstr="未支付";
        }
        return orderStatusstr;
    }

    public void setOrderStatusstr(String orderStatusstr) {
        this.orderStatusstr = orderStatusstr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr = MyDateEdit.datetostr(orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
