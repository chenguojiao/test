package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.classPayOrderJson.ClassPayOrderJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class ClassPayOrder extends BaseController {
    public void api_payorder() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int user_id = 1;
        int Class_id = 1;
        int Ordernum = 0;
        String Telephone = null;
        String Name = null;
        String Price = null;
        int Method = 0;
        String Date = null;
        String Course = null;
        String Situation = null;

        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            user_id = jsonobj.getInt("User_id");
            Class_id = jsonobj.getInt("Class_id");
            Ordernum = jsonobj.getInt("Ordernum");
            Telephone = jsonobj.getString("Telephone");
            Name = jsonobj.getString("Name");
            Price = jsonobj.getString("Price");
            Method = jsonobj.getInt("Method");
            Date = jsonobj.getString("Date");
            Course = jsonobj.getString("Course");
            Situation = jsonobj.getString("Situation");
        } catch (Exception e) {

        }
//        double price = Double.parseDouble(Price);
        Record info = new Record().set("userId", user_id).set("classId", Class_id)
                .set("ordernum", Ordernum).set("tel",Telephone).set("name",Name)
                .set("price",Price).set("method",Method).set("date",Date)
                .set("className",Course).set("situation",Situation);
        Db.save("classOrder", info);
//        String getid = "select * from userinfo where username =" + "\'" + username + "\'";
//        List<Record> userid = Db.find(getid);
//        int id = userid.get(0).getInt("id");
//        rjson.setId(id);
        ClassPayOrderJson cJson = new ClassPayOrderJson();
        cJson.setResult("yes");
        renderText(new Gson().toJson(cJson));
    }

    }
