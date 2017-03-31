package instrument.stju.model.jsondata.firm_ins_order;

import java.util.List;


public class FirmOrder {
    //    private List<InsOrder> orderslist;
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private int receiverAddressID;
    private String message;
    String method;
    double price;
    int ordernum;
    String situation;
    String date;

    int ins_id;
    String attribute;


    public int getIns_id() {
        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }

    public String getArtibute() {
        return attribute;
    }

    public void setArtibute(String artibute) {
        this.attribute = artibute;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public List<InsOrder> getOrderslist() {
//        return orderslist;
//    }

//    public void setOrderslist(List<InsOrder> orderslist) {
//        this.orderslist = orderslist;
//    }

    public int getReceiverAddressID() {
        return receiverAddressID;
    }

    public void setReceiverAddressID(int receiverAddressID) {
        this.receiverAddressID = receiverAddressID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
