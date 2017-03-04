package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.calendarJson.CalendarJson;
import instrument.stju.model.jsondata.loginJson.LoginJson;
import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Calendar extends BaseController {
    public void api_calendar() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int user_id = 1;

        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            user_id = jsonobj.getInt("User_id");
        } catch (Exception e) {

        }
        String sql1 = "select * from classOrder where userId ="
                + "\'" + user_id + "\' ";
        List<Record> users = Db.find(sql1);
        CalendarJson cJson = new CalendarJson();
        Gson gson = new Gson();
        int id = users.get(0).getInt("id");
        Record order = Db.findById("classOrder", id);
        int classId = order.getInt("classId");
        String sql2 = "select * from classDetail where classId ="
                + "\'" + classId + "\' ";
        List<Record> courseDetail = Db.find(sql2);
        int courseId = courseDetail.get(0).getInt("id");
        Record info = Db.findById("classDetail", courseId);
        String date = info.getStr("date");
        String time = info.getStr("time");
        cJson.setDate(date);
        cJson.setTime(time);

        String sql3 = "select * from class where id ="
                + "\'" + classId + "\' ";
        int class_id = courseDetail.get(0).getInt("id");
        Record courseInfo = Db.findById("class", class_id);
        String className = courseInfo.getStr("className");
        String location = courseInfo.getStr("local");
        int num = courseInfo.getInt("classTime");
        cJson.setLocation(location);
        cJson.setName(className);
        cJson.setNum(num);

        renderText(gson.toJson(cJson));
    }
}
