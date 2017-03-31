package instrument.stju.model.jsondata.showClassJson;

import java.io.Serializable;

public class Class_Message implements Serializable {
    private String class_name;
    private String class_pic_url;
    private String teacher_name;
    private String level;
    private String local;
    private String available;

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_pic_url() {
        return class_pic_url;
    }

    public void setClass_pic_url(String class_pic_url) {
        this.class_pic_url = class_pic_url;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
