package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.model.jsondata.instrumentDetailJson.InstrumentDetailJson;
import instrument.stju.model.jsondata.instrumentDetailJson.PicUrlInfoJson;
import instrument.stju.model.jsondata.instrumentDetailJson.ProductInfoJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class ShowInstrumentDetail extends BaseController {
    public void api_insdetail() throws IOException{
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int ins_id = 0;

        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            ins_id = jsonobj.getInt("Ins_id");

//            code = jsonobj.getString("code");
        } catch (Exception e) {

        }
        InstrumentDetailJson instrumentJson = new InstrumentDetailJson();
        List<ProductInfoJson> Product = instrumentJson.getProduct();
        ProductInfoJson productInfo = new ProductInfoJson();
        List<PicUrlInfoJson>  Pic_url = instrumentJson.getPic_url();
        PicUrlInfoJson picUrlInfo = new PicUrlInfoJson();

        Record info = Db.findById("instrument", ins_id);
//        Insinfo ins = new Insinfo();
        String instrument_name = info.getStr("name");
        int pre_price = info.getInt("prePrice");
        int now_price = info.getInt("nowPrice");
        double freight = info.getDouble("freight");
        String location = info.getStr("location");
        String parameter1 = info.getStr("parameter");
        String parameter2 = info.getStr("parameter");
        String description = info.getStr("description");
        instrumentJson.setInstrument_name(instrument_name);
        instrumentJson.setInstrument_pre_price(pre_price);
        instrumentJson.setInstrument_now_price(now_price);
        instrumentJson.setFreight(freight);
        instrumentJson.setInstrument_location(location);
        instrumentJson.setDescription(description);
        productInfo.setProduct_Parameter(parameter1);
        productInfo.setProduct_Parameter(parameter2);
        Product.add(productInfo);

        Record insPic = Db.findById("insPic", ins_id);
        String picUrl1 = insPic.getStr("picUrl");
        String picUrl2 = insPic.getStr("picUrl");
        picUrlInfo.setIns_pic_url(picUrl1);
        picUrlInfo.setIns_pic_url(picUrl2);
        Pic_url.add(picUrlInfo);

        Gson gson = new Gson();
        renderText(gson.toJson(instrumentJson));
    }

}
