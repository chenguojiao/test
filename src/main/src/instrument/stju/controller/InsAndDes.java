package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.Utils.ConstantData;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.insAndDesJson.InsList;
import instrument.stju.model.jsondata.insAndDesJson.Inspic;
import instrument.stju.model.jsondata.insAndDesJson.Inspics;

import java.util.List;

/**
 * Created by huangzhiwei on 16/10/29.
 */
public class InsAndDes extends BaseController {
    public void api_insdes(){
     InsList insList = new InsList();
        List<Inspics> qinsList = insList.getInspicsList();
        int  PicAndDes[] = ConstantData.PicAndDes;
        for (int i =0;i<PicAndDes.length;i++){
            Inspics inspics = new Inspics();
            List<Inspic> qinspics = inspics.getPics();

            int ins_id = PicAndDes[i];
            List<Record> inspic = Db.find("select * from  inspic where ins_id ="+String.valueOf(ins_id));
            for ( int j =0; j<inspic.size();j++){
             Inspic pic_url = new Inspic();
                   pic_url.setPic_url(inspic.get(j).getStr("pic_url"));
                    qinspics.add(pic_url);
            }
            Record instrument = Db.findById("instrument",ins_id);
            inspics.setDes(instrument.getStr("description"));
            inspics.setNow_price(instrument.getInt("now_price"));
            inspics.setName(instrument.getStr("name"));

            qinsList.add(inspics);


        }

        Gson gson = new Gson();
        renderText(gson.toJson(insList));



    }
}
