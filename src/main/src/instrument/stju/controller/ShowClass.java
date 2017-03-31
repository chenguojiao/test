package instrument.stju.controller; /**
 * Created by huangzhiwei on 16/10/26.
 */

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.showClassJson.Class_Message;
import instrument.stju.model.jsondata.showClassJson.Classes;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.util.List;


/**
 * 课程fragment
 */
public class ShowClass extends BaseController {

    public void api_showclass() {


        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = null;
        String line = null;
        int id = 0;
        int maxtime = 0;
        JSONObject jsonobj = null;


        try {
            reader = this.getRequest().getReader();

            while ((line = reader.readLine()) != null) {
                jsonstr.append(line);
            }
            reader.close();
            String js = String.valueOf(jsonstr);
            jsonobj = new JSONObject(js);


            id = jsonobj.getInt("id");


            maxtime = jsonobj.getInt("maxtime");
        } catch (Exception e) {
            System.out.println("解析json失败");
        }


        Classes allclass = new Classes();
        List<Class_Message> list = allclass.getList();
        int user_id = id;

        for (int i = 0; i < 3; i++) {
            int class_id = maxtime + 1 + i;
            Record cs = Db.findById("class", class_id);
            String class_name = cs.getStr("className");
            System.out.println(class_name);
            String class_pic_url = cs.getStr("classPicUrl");
            String teacher_name = cs.getStr("teacherName");
            String level = cs.getStr("level");
            String available = "false";
            String local = cs.getStr("local");
//                String sql = "select * from userinfo where username ="
//                        + "\'" + username + "\' "
//                        + "and password = " + "\'" + password + "\'";
            String sql = "select * from classStudent where userId ="
                    + "\'" + user_id + "\'"
                    + "and classId = " + "\'" + class_id + "\'";
            List<Record> ishave = Db.find(sql);
            if (ishave.size() > 0) available = "true";
            Class_Message cm = new Class_Message();
            cm.setClass_name(class_name);
            cm.setAvailable(available);
            cm.setTeacher_name(teacher_name);
            cm.setClass_pic_url(class_pic_url);
            cm.setLevel(level);
            cm.setLocal(local);
            list.add(cm);

        }


        allclass.setMaxtime(maxtime + 3);
        //  Class_Message classMessage = new Class_Message();


        //maxtime = maxtime+3;
        Gson gson = new Gson();


        renderText(gson.toJson(allclass));


    }
}
