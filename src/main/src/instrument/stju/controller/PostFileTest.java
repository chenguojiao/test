package instrument.stju.controller;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by huangzhiwei on 16/11/9.
 */
public class PostFileTest extends BaseController{
    public void api_without(){
        this.getFile();
    }
    public void api_have() throws IOException {
        this.getFile();
        StringBuilder jsonstr = new StringBuilder();
        BufferedReader reader = this.getRequest().getReader();
        String line = null;
        int user_id = 1;

        while((line = reader.readLine()) != null){
            jsonstr.append(line);
        }
        reader.close();
        renderText(String.valueOf(jsonstr));
    }
}
