package instrument.stju.model.jsondata.showInstrument;

/**
 * Created by huangzhiwei on 16/10/28.
 */
public class Insinfo {
    private String name;
    private int pre_price;
    private int now_price;
    private String type;
    private String pic_url;
    private int id;
    private  String des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPre_price() {
        return pre_price;
    }

    public void setPre_price(int pre_price) {
        this.pre_price = pre_price;
    }

    public int getNow_price() {
        return now_price;
    }

    public void setNow_price(int now_price) {
        this.now_price = now_price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


}
