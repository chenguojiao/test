package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.loginJson.LoginJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
public class Login extends BaseController {
    public void api_login() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        String username = null;
        String password = null;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            username = jsonobj.getString("username");

            password = jsonobj.getString("password");

        } catch (Exception e) {

        }
        //sql
        String sql = "select * from userinfo where username =" + "\'" + username + "\' " + "and password = " + "\'" + password + "\'";
        List<Record> users = Db.find(sql);
        LoginJson ljson = new LoginJson();
        Gson gson = new Gson();
        if (users.size() > 0) {
//            int id = users.get(0).getInt("id");
//            Record userinfo = Db.findById("userinfo", id);
//            String name = userinfo.getStr("username");
//            String picUrl = userinfo.getStr("headpic");
//            String introduction = userinfo.getStr("intrduction");
//            String location = userinfo.getStr("location");
//            String other = userinfo.getStr("other");
            ljson.setType(0);
            ljson.setResult("true");
//            ljson.setUser_id(id);
//            ljson.setUsername(name);
//            ljson.setPic_URL(picUrl);
//            ljson.setIntroduction(introduction);
//            ljson.setLocation(location);
//            ljson.setOther(other);
//            renderText("true");
        } else {
//            renderText("false");
//            String sqlName = "select * from userinfo where username =" + "\'" + username + "\'";
//            List<Record> name = Db.find(sqlName);
//            if (name.size() > 0) {
                ljson.setType(1);
                ljson.setResult("false");
//            } else {
//                ljson.setType(1);
//                ljson.setResult("false");
//            }
        }

// if (users.size() == 0) {
//            ljson.setType(1);
//            ljson.setResult("false");
//        }
        renderText(gson.toJson(ljson));
    }
}
