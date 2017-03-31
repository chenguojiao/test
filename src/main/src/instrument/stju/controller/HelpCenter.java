package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.helpCenterJson.HelpCenterJson;

import java.util.List;
/*
 *°ïÖúÖÐÐÄ
 */

public class HelpCenter extends BaseController {
    public void api_helpcenter() {
        HelpCenterJson hJson = new HelpCenterJson();
        String sql = "select * from instrument where id >0";
        List<Record> helpcenter = Db.find(sql);
        Record helpCenterRecord = helpcenter.get(0);
        int id = helpCenterRecord.getInt("id");
        Record helpCenter = Db.findById("helpCenter", id);
        String content = helpCenter.getStr("content");
        String about = helpCenter.getStr("about");
        hJson.setContent(content);
        hJson.setAbout(about);
        Gson gson = new Gson();
        renderText(gson.toJson(hJson));
    }
}
