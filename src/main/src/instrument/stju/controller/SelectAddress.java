package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.selectAddressjson.ContentJson;
import instrument.stju.model.jsondata.selectAddressjson.SelectAddressJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */
public class SelectAddress extends BaseController {
    public void api_selectadd() throws IOException {

        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        String user_id = null;
        String code = null;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            user_id = jsonobj.getString("User_id");


        } catch (Exception e) {

        }
        String sql = "select * from receiverAddress where userId = "
                + "\'" + user_id + "\'";
        List<Record> info = Db.find(sql);
        SelectAddressJson sJson = new SelectAddressJson();
        List<ContentJson> Content = sJson.getContent();
        ContentJson cJson = new ContentJson();
        for (int i = 0;i < info.size();i++) {
            Record record = info.get(i);
            String recipient = record.getStr("receiver");
            String telephone = record.getStr("tel");
            String address = record.getStr("address");
            cJson.setRecipient(recipient);
            cJson.setTelephone(telephone);
            cJson.setAddress(address);
            Content.add(cJson);
        }
        Gson gson = new Gson();
        renderText(gson.toJson(sJson));
    }
}
