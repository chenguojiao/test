package instrument.stju.model.jsondata.buyInsOrderJson;

/**
 * Created by huangzhiwei on 16/11/3.
 */
public class InsInfo {
    String pic_url;
    int now_price;
    String name;
    String type;

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

    public int getNow_price() {
        return now_price;
    }

    public void setNow_price(int now_price) {
        this.now_price = now_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
