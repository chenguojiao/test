package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.showClassDetailJson.Class_detail;
import instrument.stju.model.jsondata.showClassDetailJson.ShowClassDetailJson;
import instrument.stju.model.jsondata.showClassDetailJson.Teacher;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 * ¿Î³ÌÏêÇé
 */
public class ShowClassDetail extends BaseController {
    public void api_classdetail() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        String Class_id = null;
        String code = null;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            Class_id = jsonobj.getString("Class_id");

            code = jsonobj.getString("code");
        } catch (Exception e) {

        }
        String sql = "select * from classTimeFeedback where id ="
                + "\'" + Class_id + "\' ";
//        System.out.println(sql);
        List<Record> classTime = Db.find(sql);
//        System.out.println(course.size());
        Record course = Db.findById("class", Class_id);
//        Insinfo ins = new Insinfo();
        String class_name = course.getStr("className");
        String class_level = course.getStr("level");
        int class_price = course.getInt("classPrice");
        int class_number = course.getInt("classNumber");
        int class_time = course.getInt("classTime");
        String class_location = course.getStr("local");
        String class_remark = course.getStr("remark");
//        int feedBackNum = course.getInt("feedbackNum");
        int feedBackNum = classTime.size();
        ShowClassDetailJson classDetailJson = new ShowClassDetailJson();
        classDetailJson.setClass_id(Integer.parseInt(Class_id));
        classDetailJson.setClass_name(class_name);
        classDetailJson.setClass_level(class_level);
        classDetailJson.setClass_price(class_price);
        classDetailJson.setClass_number(class_number);
        classDetailJson.setClass_time(class_time);
        classDetailJson.setClass_location(class_location);
        classDetailJson.setClass_remark(class_remark);
        classDetailJson.setFeedback_number(feedBackNum);

        Record teacher = Db.findById("teacher", Class_id);
        List<Teacher> Teacher = classDetailJson.getTeacher();

        Teacher teacherInfo = new Teacher();
        String teacher_name = teacher.getStr("teacherName");
        String telephone = teacher.getStr("teacherTel");
        int student_number = teacher.getInt("studentNum");
        System.out.println(teacher_name + telephone + student_number);
        teacherInfo.setTeacher_name(teacher_name);
        teacherInfo.setTeacher_telephone(telephone);
        teacherInfo.setStudent_number(student_number);
        Teacher.add(teacherInfo);

        Record class_detail = Db.findById("classDetail", Class_id);
//        List<Classdetail> classdetailList =
        List<Class_detail> Class_detail = classDetailJson.getClass_detail();
        Class_detail classdetaiInfo = new Class_detail();
        int number = class_detail.getInt("num");
        String type = class_detail.getStr("type");
        String date = class_detail.getStr("date");
        String time = class_detail.getStr("time");
        String content = class_detail.getStr("content");
        classdetaiInfo.setNum(number);
        classdetaiInfo.setType(type);
        classdetaiInfo.setDate(date);
        classdetaiInfo.setTime(time);
        classdetaiInfo.setContent(content);
        Class_detail.add(classdetaiInfo);

        Gson gson = new Gson();
        renderText(gson.toJson(classDetailJson));

    }
}
