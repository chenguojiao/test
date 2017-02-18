package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.showSystemMessage.SystemMessageJson;
import instrument.stju.model.jsondata.showSystemMessage.SystemMessageList;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/8.
 */
public class ShowSystemMessage extends BaseController {
    public  void api_showSystemMessage(){

       StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = null;
        String line = null;
        int user_id =0;
        String code ="";
        JSONObject jsonobj = null;




        try {
            reader = this.getRequest().getReader();

            while ((line = reader.readLine()) != null) {
                jsonstr.append(line);
            }
            reader.close();
            String js = String.valueOf(jsonstr);
            jsonobj = new JSONObject(js);
            user_id = jsonobj.getInt("user_id");
            code = jsonobj.getString("code");
        }catch (Exception e) {
            System.out.println("解析json失败");
         }

          String sql = "select * from systemmessage where id >0";
        List<Record> systemMessages = Db.find(sql);
        SystemMessageList messageList = new SystemMessageList();
        List<SystemMessageJson> list = messageList.getList();
        for (int i=0;i<systemMessages.size();i++){
            Record systemMessage = systemMessages.get(i);
            SystemMessageJson systemMessageJson = new SystemMessageJson();
            systemMessageJson.setContent(systemMessage.getStr("content"));
            systemMessageJson.setTitle(systemMessage.getStr("title"));
            systemMessageJson.setDate(systemMessage.getStr("date"));
           list.add(systemMessageJson);


        }
        Gson gson = new Gson();
        renderText(gson.toJson(messageList));





    }
}
