package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.deleteReceiverJson.DeleteReceiverJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/5.
 */
public class DeleteReceiverAddress extends BaseController {
    public void api_deleteAddress() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
//        int user_id = 0;
//        int receiverAddressID=0;
//        String code = null;
        int user_id = 0;
        String address = null;
        String tel = null;
        String receiver = null;


        while((line = reader.readLine()) != null){
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

//            code  = jsonobj.getString("code");
//            user_id = jsonobj.getInt("user_id");
//            receiverAddressID = jsonobj.getInt("receiverAddressID");
            user_id = jsonobj.getInt("user_id");

            address = jsonobj.getString("address");
            tel = jsonobj.getString("tel");
            receiver = jsonobj.getString("receiver");

        }catch (Exception e){
            renderText("解析失败");

        }
//        String sql = "select * from receiverAddress where address =
// "+"\'"+address+"\'"+" and userId = "+ "\'" + user_id + "\'";
        String sql = "select * from receiverAddress where address = "
                + "\'" + address + "\'" + "and userId = " + "\'"
                + user_id + "\'" + "and tel = " + "\'" + tel + "\'"
                + "and receiver = " + "\'" + receiver + "\'";
        List<Record> info = Db.find(sql);
        Record infoList = info.get(0);
        int id = infoList.getInt("id");
        Db.deleteById("receiverAddress",id);
        DeleteReceiverJson deletejson = new DeleteReceiverJson();
        deletejson.setResult("yes");
        Gson gson = new Gson();
        renderText(gson.toJson(deletejson));







    }
}
