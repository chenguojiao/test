package instrument.stju.model.jsondata.albumListJson;

//import instrument.stju.model.jsondata.albumListJson.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhiwei on 16/10/28.
 */
public class Albums {
    private List<Album> albums;

    public List<Album> getAlbums() {
        return albums;
    }

    public Albums(){
        albums = new ArrayList<Album>();
    }
}
