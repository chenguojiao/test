package instrument.stju.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.sun.deploy.net.HttpRequest;
import instrument.stju.controller.BaseController;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by huangzhiwei on 16/10/22.
 */
public class Chicon extends BaseController {
    public void api_chheadpic() throws IOException {


        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        while((line = reader.readLine()) != null){
            jsonstr.append(line);
        }
        reader.close();


        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int id = 2;
        try {
            id = jsonobj.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String headpic = null;
        try {
            headpic = jsonobj.getString("headpic");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<Record> users = Db.find("select * from userinfo where id = "+String.valueOf(id));
        Record user = (Record) users.get(0);
        user.set("headpic",headpic);
        Db.update("userinfo",user);
        renderText("{\n" +
                "\"result\":\"yes\"\n" +
                "}");









    }

}
