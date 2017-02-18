package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.RegistJson.RegistJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by huangzhiwei on 16/10/19.
 */
public class Regist extends BaseController {
    public void  api_regist() throws IOException {

        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        String username = null;
        String password = null;


        while((line = reader.readLine()) != null){
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            username = jsonobj.getString("username");

            password = jsonobj.getString("password");
        }catch (Exception e){

        }


        String sql = "select * from userinfo where username ="+"\'"+username+"\'";
       List<Record> users = Db.find(sql);
        RegistJson rjson = new RegistJson();
        Gson gson = new Gson();
       if (users.size()>0){

          rjson.setId(-1);
           rjson.setResult("no");


       }
       if (users.size()==0){
           Record user = new Record().set("username",username ).set("password", password).set("headpic","localhost");
           Db.save("userinfo",user);
           String getid = "select * from userinfo where username ="+"\'"+username+"\'";
            List<Record> userid =  Db.find(getid);
           int id =userid.get(0).getInt("id");
          rjson.setId(id);
           rjson.setResult("yes");
       }
        renderText(gson.toJson(rjson));


    }
}
