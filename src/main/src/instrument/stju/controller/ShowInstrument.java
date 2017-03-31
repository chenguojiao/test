package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.showInstrument.InsArr;
import instrument.stju.model.jsondata.showInstrument.Insinfo;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * ÀÖÆ÷fragment
 */
public class ShowInstrument extends BaseController {
    public void api_showinstrument() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = null;
        String line = null;
        int id = 0;
        JSONObject jsonobj = null;
        String code = null;

        reader = this.getRequest().getReader();

        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        jsonobj = new JSONObject(js);

        code = jsonobj.getString("code");

        InsArr instruments = new InsArr();
        List<Insinfo> inList = instruments.getInsArr();
        //for (int i =1;i<=3;i++){
        String sql1 = "select * from instrument where id >0";
        List<Record> instrumentlist = Db.find(sql1);
        for (int i = 0; i < instrumentlist.size(); i++) {
            Record instrumentRecord = instrumentlist.get(i);
            int ins_id = instrumentRecord.getInt("id");
            Record instrument = Db.findById("instrument", ins_id);
            Insinfo ins = new Insinfo();
            String name = instrument.getStr("name");
            int pre_price = instrument.getInt("prePrice");
            int now_price = instrument.getInt("nowPrice");
            String type = instrument.getStr("type");
            String des = instrument.getStr("description");
//            String sql = "select * from insPic where insId =" + "\'" + ins_id + "\'";
            String sql = "select * from insPic where insId =" + String.valueOf(ins_id);
            List<Record> imageList = Db.find(sql);
            Record inspic = imageList.get(0);
            String pic_url = inspic.getStr("picUrl");

            ins.setId(ins_id);
            ins.setName(name);
            ins.setNow_price(now_price);
            ins.setPic_url(pic_url);
            ins.setPre_price(pre_price);
            ins.setType(type);
            System.out.println(type);
            ins.setDes(des);
            inList.add(ins);
        }
        Gson gson = new Gson();
        renderText(gson.toJson(instruments));

    }

}
