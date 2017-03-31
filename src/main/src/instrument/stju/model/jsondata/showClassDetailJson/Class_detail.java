package instrument.stju.model.jsondata.showClassDetailJson;

import java.io.Serializable;

public class Class_detail implements Serializable {
    private int Num;
    private String Type;
    private String Date;
    private String Time;
    private String Content;

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
