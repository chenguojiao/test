package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.receiverAddress.ReveiverAddressJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/*
 *收货人地址
 */

public class ReceiverAddress extends BaseController {
    public void api_edictAddress() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int user_id = 0;
        String address = null;
        String tel = null;
        String receiver = null;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            user_id = jsonobj.getInt("user_id");

            address = jsonobj.getString("address");
            tel = jsonobj.getString("tel");
            receiver = jsonobj.getString("receiver");
        } catch (Exception e) {

        }
        ReveiverAddressJson ra = new ReveiverAddressJson();

        String sql = "select * from receiverAddress where address =" +
                "" + "\'" + address + "\'" + " and userId = " + "\'" + user_id + "\'";
        String sql2 = " and tel = " + "\'" + tel + "\'" + " and receiver =" + "\'" + receiver + "\'";
        List<Record> records = Db.find(sql + sql2);
        if (records.size() > 0) {
            Record record = records.get(0);
            ra.setResult("no");
            ra.setReceiverAddressId(record.getInt("id"));
            Gson gson = new Gson();
            renderText(gson.toJson(ra));
        } else {

            Record receiverAddress = new Record().set("userId", user_id)
                    .set("address", address).set("tel", tel).set("receiver", receiver);
            Db.save("receiverAddress", receiverAddress);
            String sql1 = "select * from receiverAddress where address =" +
                    "" + "\'" + address + "\'" + " and userId = " + "\'" + user_id + "\'";
            String sql3 = " and tel = " + "\'" + tel + "\'" + " and receiver =" + "\'" + receiver + "\'";
            List<Record> recordList = Db.find(sql1 + sql3);
            Record record = recordList.get(0);
            ra.setResult("yes");
            ra.setReceiverAddressId(record.getInt("id"));
//            ra.setReceiverAddressId(receiverAddress.getInt("id"));
            Gson gson = new Gson();
            renderText(gson.toJson(ra));
        }


    }
}
