package instrument.stju.controller;

import com.google.gson.Gson;
import instrument.stju.model.jsondata.complaintJson.ComplaintJson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
/*
 *Õ∂ÀﬂΩ®“È
 */

public class Complaint extends BaseController {
    public void api_complaint() throws IOException {
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        String id = null;
        String code = null;


        while ((line = reader.readLine()) != null) {
            jsonstr.append(line);
        }
        reader.close();
        String js = String.valueOf(jsonstr);
        JSONObject jsonobj = null;
        try {
            jsonobj = new JSONObject(js);

            id = jsonobj.getString("User_id");

            code = jsonobj.getString("code");

        } catch (Exception e) {
            e.printStackTrace();
        }
        ComplaintJson cJson = new ComplaintJson();
        cJson.setResult("true");
        Gson gson = new Gson();
        renderText(gson.toJson(cJson));
    }
}
