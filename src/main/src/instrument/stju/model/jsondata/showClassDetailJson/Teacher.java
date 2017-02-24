package instrument.stju.model.jsondata.showClassDetailJson;


import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/23.
 */
public class Teacher {
    private String Teacher_pic_URL;
    private String Teacher_name;
    private String Teacher_telephone;
    private int Student_number;

    public String getTeacher_pic_URL() {
        return Teacher_pic_URL;
    }

    public void setTeacher_pic_URL(String teacher_pic_URL) {
        Teacher_pic_URL = teacher_pic_URL;
    }

    public String getTeacher_name() {
        return Teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        Teacher_name = teacher_name;
    }

    public String getTeacher_telephone() {
        return Teacher_telephone;
    }

    public void setTeacher_telephone(String teacher_telephone) {
        Teacher_telephone = teacher_telephone;
    }

    public int getStudent_number() {
        return Student_number;
    }

    public void setStudent_number(int student_number) {
        Student_number = student_number;
    }
}
