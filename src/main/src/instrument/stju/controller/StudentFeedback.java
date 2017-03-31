package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.loginJson.LoginJson;
import instrument.stju.model.jsondata.studentFeedbackJson.StudentFeedbackJson;
import instrument.stju.model.jsondata.studentFeedbackJson.StudentsFeedBackListJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 * 学生反馈
 */
public class StudentFeedback extends BaseController {
    public void api_feedback() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int class_id = 0;
        int time_id = 0;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            class_id = jsonobj.getInt("Class_id");
            time_id = jsonobj.getInt("Time_id");

        } catch (Exception e) {
            renderText("解析失败");

        }
//        String sql = "select * from classTimeFeedback where classId ="
//                + "\'" + class_id + "\' "
//                + "and timeId = " + "\'" + time_id + "\'";
//        System.out.println(sql);
//        List<Record> feedbackInfo = Db.find(sql);
        StudentFeedbackJson sJson = new StudentFeedbackJson();
        Gson gson = new Gson();
        List<StudentsFeedBackListJson> Topic = sJson.getTopic();
        StudentsFeedBackListJson info = new StudentsFeedBackListJson();
//        Record feedback = feedbackInfo.get(0);
        Record feedbackInfo = Db.findById("classTimeFeedback", time_id);
        String date = feedbackInfo.getStr("Date");
        String content = feedbackInfo.getStr("feedback");
        String name = feedbackInfo.getStr("name");
        info.setDate(date);
        info.setName(name);
        info.setContent(content);
        Topic.add(info);

        renderText(gson.toJson(sJson));
    }

}
