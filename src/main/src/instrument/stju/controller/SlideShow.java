package instrument.stju.controller;import com.google.gson.Gson;import com.jfinal.core.Controller;import com.jfinal.plugin.activerecord.Db;import com.jfinal.plugin.activerecord.Record;import instrument.stju.controller.BaseController;import instrument.stju.model.jsondata.showSlide.TopList;import instrument.stju.model.jsondata.showSlide.Top_image;import java.util.List;/** * Created by huangzhiwei on 16/10/22. */public class SlideShow extends BaseController {    public void api_showslide(){       /* StringBuilder jsonstr = new StringBuilder();        BufferedReader reader = this.getRequest().getReader();        String line = null;        while((line = reader.readLine()) != null){            jsonstr.append(line);        }        reader.close();        String js = String.valueOf(jsonstr);        JSONObject jsonobj = null;        try {            jsonobj = new JSONObject(js);        } catch (JSONException e) {            e.printStackTrace();        }*/        List<Record> slides = Db.find("select * from slideshow where id > 0 ");        int size = slides.size();        TopList tlist = new TopList();        List<Top_image> toplist = tlist.getTop();        for (int i=0;i<size;i++){            Record slide = slides.get(i);            Top_image top_image = new Top_image();            String slide_name = slide.getStr("slideName");//            String jump_url =slide.getStr("jumpUrl");            String slide_url = slide.getStr("slideUrl");            top_image.setClass_name(slide_name);//            top_image.setJump_url(jump_url);            top_image.setTop_image(slide_url);            toplist.add(top_image);        }          Gson gson = new Gson();          renderText(gson.toJson(tlist));   /*        String top_image[] = new String[3];        String class_name[] = new String[3];        for (int i=1;i<=3;i++){            List<Record> classes = Db.find("select * from class where id = "+String.valueOf(i));              Record cs = classes.get(0);            top_image[i-1] = cs.getStr("class_pic_url");            class_name[i-1] = cs.getStr("class_name");          }        //给出轮播图       /* String top_imageurl ="{\n" +                "\"top\":[\n" +                "{\"top_image\":\n" +                "\""+top_image[0]+"\",\n" +                "\"class_name\":\n" +                "\""+class_name[0]+"\"\n" +                " },\n" +                "{\"top_image\":\n" +                "\""+top_image[1]+"\",\n" +                "\"class_name\":\n" +                "\""+class_name[1]+"\"\n" +                " },\n" +                "{\"top_image\":\n" +                "\""+top_image[2]+"\",\n" +                "\"class_name\":\n" +                "\""+class_name[2]+"\"\n" +                " }\n" +                "]\n" +                "}";                */      //List<Top_image> top_images = new ArrayList<Top_image>();       /* Top_image tp1 = new Top_image(top_image[0],class_name[0]);        Top_image tp2 = new Top_image(top_image[1],class_name[1]);        Top_image tp3 = new Top_image(top_image[2],class_name[2]);        TopList tlist = new TopList();        List<Top_image> toplist = tlist.getTop();        toplist.add(tp1);        toplist.add(tp2);       toplist.add(tp3);        Gson gson = new Gson();        renderText(gson.toJson(tlist));        */            }        }