package instrument.stju.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import instrument.stju.Utils.ConstantData;
import instrument.stju.controller.BaseController;
import instrument.stju.model.jsondata.albumListJson.Album;
import instrument.stju.model.jsondata.albumListJson.Albums;

import java.util.List;

/**
 * Created by huangzhiwei on 16/10/28.
 *
 */
public class ShowAlbum extends BaseController {
    public void api_showalbum(){
     int Albums[] = ConstantData.AlbumTime;
        //Albums albums = new Albums();
        Albums albums = new Albums();
        List<Album> albumList = albums.getAlbums();
        for ( int i=0;i< Albums.length;i++){

            Album album =new Album();

            Record  ins_album = Db.findById("ins_album",Albums[i]);
            String album_url = ins_album.getStr("album_url");
           album.setAlbum_url(album_url);
            albumList.add(album);


        }
        Gson gson = new Gson();
       renderText(gson.toJson(albums));


    }

}
