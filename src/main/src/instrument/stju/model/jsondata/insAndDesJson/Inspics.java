package instrument.stju.model.jsondata.insAndDesJson;

import instrument.stju.model.jsondata.insAndDesJson.Inspic;

import java.util.ArrayList;
import java.util.List;

public class Inspics {
    private List<Inspic> pics;
    private String des;
    private int now_price;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNow_price() {
        return now_price;
    }

    public void setNow_price(int now_price) {
        this.now_price = now_price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<Inspic> getPics() {
        return pics;

    }

    public void setPics(List<Inspic> pics) {
        this.pics = pics;
    }

    public Inspics() {
        this.pics = new ArrayList<Inspic>();
    }
}
