package instrument.stju.model.jsondata.showClassDetailJson;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/23.
 */
public class Student implements Serializable {
    private String Student_pic_url;

    public String getStudent_pic_url() {
        return Student_pic_url;
    }

    public void setStudent_pic_url(String student_pic_url) {
        Student_pic_url = student_pic_url;
    }
}
