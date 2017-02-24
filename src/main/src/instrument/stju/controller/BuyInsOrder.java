package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.buyInsOrderJson.InsInfo;
import instrument.stju.model.jsondata.buyInsOrderJson.InsList;
import instrument.stju.model.jsondata.buyInsOrderJson.OrderList;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/3.
 */
public class BuyInsOrder extends BaseController {
    public void api_buyinstrument() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int user_id = 1;

        while((line = reader.readLine()) != null){
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);


            user_id = jsonobj.getInt("user_id");
        }catch (Exception e){

        }


        String sql = "select * from insorder where usrId ="+String.valueOf(user_id);
        OrderList orderList = new OrderList();
        List<InsList>  insList = orderList.getOrder_list();


        List<Record> orders_id = Db.find(sql);
         for (int i =0;i<orders_id.size();i++){
             Record insOrder = orders_id.get(i);
             int order_id = insOrder.getInt("id");
             String sql1 = "select * from orderIns where orderId ="+String.valueOf(order_id);
             List<Record> ins_ids = Db.find(sql1);
             InsList infolist = new InsList();
             List<InsInfo>  info = infolist.getList();
             infolist.setDate(insOrder.getStr("date"));
             infolist.setFreigh(insOrder.getDouble("freight"));
             infolist.setPrice(insOrder.getDouble("price"));
             infolist.setSituation(insOrder.getStr("situation"));

             for (int j=0;j<ins_ids.size();j++){
                 Record order_ins = ins_ids.get(j);
                 System.out.println(order_ins.getInt("insId"));
                 Record instrument = Db.findById("instrument",order_ins.getInt("insId"));
                 // Record instrument = Db.findById("instrument",2);

                 InsInfo insInfo = new InsInfo();
                 insInfo.setName(instrument.getStr("name"));
                 insInfo.setNow_price(instrument.getInt("nowPrice"));
                 insInfo.setType(instrument.getStr("type"));
                 String sql2 = "select * from insPic where insId ="+String.valueOf(instrument.getInt("id"));
                 List<Record>  imageList = Db.find(sql2);
                 Record inspic = imageList.get(0);
                 insInfo.setPic_url(inspic.getStr("picUrl"));
                  info.add(insInfo);


             }

       insList.add(infolist);

         }
        Gson gson = new Gson();
        renderText(gson.toJson(orderList));



    }
}
