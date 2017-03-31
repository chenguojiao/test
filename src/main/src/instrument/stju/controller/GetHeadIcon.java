package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.getHeadIconJson.Headpic;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;


public class GetHeadIcon extends BaseController {
    public void api_getHeadIcon() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int id = 0;
        String code = null;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            id = jsonobj.getInt("id");

            code = jsonobj.getString("code");
        } catch (Exception e) {
            renderText("解析失败");

        }
        Record userinfo = Db.findById("userinfo", id);
        Headpic headpic = new Headpic();
        headpic.setHeadpic(userinfo.getStr("headpic"));
        Gson gson = new Gson();
        renderText(gson.toJson(headpic));


    }
}
