package instrument.stju.model.jsondata.showreservationJson;

/**
 * Created by huangzhiwei on 16/11/5.
 */
public class ShowReservationJson {
    String date;
    int situation;
    String class_name;
    String teacher_name;
    String class_pic_url;
    int class_time;
    int class_price;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getClass_pic_url() {
        return class_pic_url;
    }

    public void setClass_pic_url(String class_pic_url) {
        this.class_pic_url = class_pic_url;
    }


    public int getClass_time() {
        return class_time;
    }

    public void setClass_time(int class_time) {
        this.class_time = class_time;
    }

    public int getClass_price() {
        return class_price;
    }

    public void setClass_price(int class_price) {
        this.class_price = class_price;
    }
}
