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
 * 选择地址
 */
public class SelectAddress extends BaseController {
    public void api_selectadd() throws IOException {

        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int user_id = 0;
        int code = 0;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            user_id = jsonobj.getInt("userId");
            code = jsonobj.getInt("code");


        } catch (Exception e) {

        }
        String sql = "select * from receiverAddress where userId = "
                + "\'" + user_id + "\'";
        List<Record> info = Db.find(sql);
        System.out.println("id：" + user_id);
        System.out.println("长度：" + info.size());
        SelectAddressJson sJson = new SelectAddressJson();
        List<ContentJson> Content = sJson.getContent();

        for (int i = 0; i < info.size(); i++) {
            ContentJson cJson = new ContentJson();
            Record record = info.get(i);
            String recipient = record.getStr("receiver");
            String telephone = record.getStr("tel");
            String address = record.getStr("address");

            cJson.setRecipient(recipient);
            cJson.setTelephone(telephone);
            cJson.setAddress(address);
            Content.add(cJson);
            System.out.println("Content:" + Content.get(i).getAddress()
                    + Content.get(i).getRecipient());

        }
        for (int j = 0; j < Content.size(); j++) {
            System.out.println("Content:" + Content.get(j).getAddress()
                    + Content.get(j).getRecipient() + Content.get(j).getTelephone());
        }
        Gson gson = new Gson();
        renderText(gson.toJson(sJson));
    }
}
