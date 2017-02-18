package instrument.stju.model.jsondata.buyInsOrderJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/3.
 */
public class InsList {
    String date;
    double price;
    List<InsInfo> list ;
    String situation;
    double freigh;

    public double getFreigh() {
        return freigh;
    }

    public void setFreigh(double freigh) {
        this.freigh = freigh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<InsInfo> getList() {
        return list;
    }

    public void setList(List<InsInfo> list) {
        this.list = list;
    }
    public InsList(){
        list = new ArrayList<InsInfo>();
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
