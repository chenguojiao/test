package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.showreservationJson.ReservationList;
import instrument.stju.model.jsondata.showreservationJson.ShowReservationJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/5.
 */
//预约订单控制器
public class ReservationOrder extends BaseController {
    public void api_showReservationOrder(){
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = null;
        String line = null;
        int user_id = 0;
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


        }catch (Exception e) {
            System.out.println("解析json失败");
        }
        String sql = "select * from classorder where user_id = "+String.valueOf(user_id);
        List<Record> class_ides = Db.find(sql);
        ReservationList reservationList = new ReservationList();
        List<ShowReservationJson> list = reservationList.getList();
        for (int i=0;i<class_ides.size();i++){
            Record class_message = class_ides.get(i);
            ShowReservationJson showReservationJson = new ShowReservationJson();
             int class_id = class_message.getInt("class_id");
             //double class_price =class_message.getDouble("price");
             String date = class_message.getStr("date");
             int situation = class_message.getInt("situation");
            String sql2 = "select * from teacher where class_id ="+String.valueOf(class_id);
            List<Record> teachers = Db.find(sql2);
            Record teacher = teachers.get(0);
            String teacher_name = teacher.getStr("teacher_name");
            Record myclass = Db.findById("class",class_id);
            String class_pic_url = myclass.getStr("class_pic_url");
             int class_price = myclass.getInt("class_price");
             String class_name = myclass.getStr("class_name");
            int class_time = myclass.getInt("class_time");
             showReservationJson.setSituation(situation);
            showReservationJson.setClass_name(class_name);
            showReservationJson.setClass_pic_url(class_pic_url);
            showReservationJson.setClass_price(class_price);
            showReservationJson.setDate(date);
            showReservationJson.setTeacher_name(teacher_name);
            showReservationJson.setClass_time(class_time);
            list.add(showReservationJson);



        }


        Gson gson = new Gson();
        renderText(gson.toJson(reservationList));







    }
}
