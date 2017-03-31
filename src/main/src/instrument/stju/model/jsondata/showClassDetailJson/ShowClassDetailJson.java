package instrument.stju.model.jsondata.showClassDetailJson;

import instrument.stju.model.datamodel.Classdetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowClassDetailJson implements Serializable {
    private int Class_id;
    private String Class_name;
    private String Class_level;
    private int Class_price;
    private int Class_number;
    private int Class_time;
    private String Class_location;
    private String Class_remark;
    private int Feedback_number;
    private List<Teacher> Teacher;
    private List<Class_detail> Class_detail;

    public ShowClassDetailJson() {
        Class_detail = new ArrayList<instrument.stju.model.jsondata.showClassDetailJson.Class_detail>();
        Teacher = new ArrayList<instrument.stju.model.jsondata.showClassDetailJson.Teacher>();
    }

    public int getClass_id() {
        return Class_id;
    }

    public void setClass_id(int class_id) {
        Class_id = class_id;
    }

    public String getClass_name() {
        return Class_name;
    }

    public void setClass_name(String class_name) {
        Class_name = class_name;
    }

    public String getClass_level() {
        return Class_level;
    }

    public void setClass_level(String class_level) {
        Class_level = class_level;
    }

    public int getClass_price() {
        return Class_price;
    }

    public void setClass_price(int class_price) {
        Class_price = class_price;
    }

    public int getClass_number() {
        return Class_number;
    }

    public void setClass_number(int class_number) {
        Class_number = class_number;
    }

    public int getClass_time() {
        return Class_time;
    }

    public void setClass_time(int class_time) {
        Class_time = class_time;
    }

    public String getClass_location() {
        return Class_location;
    }

    public void setClass_location(String class_location) {
        Class_location = class_location;
    }

    public String getClass_remark() {
        return Class_remark;
    }

    public void setClass_remark(String class_remark) {
        Class_remark = class_remark;
    }

    public int getFeedback_number() {
        return Feedback_number;
    }

    public void setFeedback_number(int feedback_number) {
        Feedback_number = feedback_number;
    }

    public List<instrument.stju.model.jsondata.showClassDetailJson.Teacher> getTeacher() {
        return Teacher;
    }

    public void setTeacher(List<instrument.stju.model.jsondata.showClassDetailJson.Teacher> teacher) {
        Teacher = teacher;
    }

    public List<instrument.stju.model.jsondata.showClassDetailJson.Class_detail> getClass_detail() {
        return Class_detail;
    }

    public void setClass_detail(List<instrument.stju.model.jsondata.showClassDetailJson.Class_detail> class_detail) {
        Class_detail = class_detail;
    }
}
