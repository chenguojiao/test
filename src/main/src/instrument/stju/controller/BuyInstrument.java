package instrument.stju.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.firm_ins_order.FirmOrder;
import instrument.stju.model.jsondata.firm_ins_order.InsOrder;
import instrument.stju.model.jsondata.firm_ins_order.ResultFirmOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/7.
 */
public class BuyInstrument extends BaseController {
    public void api_buyinstrument() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        String code = null;


        while((line = reader.readLine()) != null){
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);





       Gson gson = new Gson();
        Type type= new TypeToken<FirmOrder>(){}.getType();
        FirmOrder firmOrder = gson.fromJson(js,type);
        List<InsOrder> list = firmOrder.getOrderslist();
        double price = firmOrder.getPrice();
        String method = firmOrder.getMethod();
        int receiverAddressID = firmOrder.getReceiverAddressID();
        String message = firmOrder.getMessage();
        int ordernum = firmOrder.getOrdernum();
        String situation = firmOrder.getSituation();
        String date = firmOrder.getDate();
        int user_id = firmOrder.getUser_id();
        Record insorder = new Record().set("price",price).set("method",method).set("reveiverID",receiverAddressID);
        insorder.set("message",message).set("orderNum",ordernum).set("situation",situation).set("date",date).set("usrId",user_id);
        Db.save("insOrder",insorder);
        Db.update("insOrder", insorder);

        //int order_id = insorder.getInt("id");
       /* String sql = "select * from insorder where id >0";
        List<Record>insorders = Db.find(sql);
        Record insorder_id = insorders.get(insorders.size()-1);*/
        int order_id = insorder.getNumber("id").intValue();
        for (int i=0;i<list.size();i++){
            InsOrder insOrder = list.get(i);
            int ins_id = insOrder.getIns_id();
            String attribute = insOrder.getArtibute();
            Record order_ins = new Record().set("orderId",order_id).set("insId",ins_id).set("attribute",attribute);
            Db.save("orderIns",order_ins);
        }
        ResultFirmOrder resultFirmOrder = new ResultFirmOrder();
        resultFirmOrder.setResult("yes");
      renderText(gson.toJson(resultFirmOrder));



    }
}
