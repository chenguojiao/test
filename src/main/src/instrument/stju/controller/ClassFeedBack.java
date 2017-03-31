package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.class_time_feedbackJson.FeedBackJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
/*
 *课程反馈
 */

public class ClassFeedBack extends BaseController {
    public void api_feedBack() throws IOException {

        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int class_id = 0;
        int time_id = 0;
        String feedback = "";
        int user_id = 0;
        String date = null;

        String code = null;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            class_id = jsonobj.getInt("class_id");
            time_id = jsonobj.getInt("time_id");
            feedback = jsonobj.getString("feedback");
            user_id = jsonobj.getInt("user_id");
            date = jsonobj.getString("date");

            code = jsonobj.getString("code");
        } catch (Exception e) {
            renderText("解析失败");

        }

        Record class_time_feedback = new Record().set("classId", class_id).set("timeId", time_id).set("userId", user_id).set("feedback", feedback).set("date", date);
        Db.save("classTimeFeedback", class_time_feedback);
        FeedBackJson result = new FeedBackJson();
        result.setResult("ok");
        Gson gson = new Gson();
        renderText(gson.toJson(result));

    }
}
