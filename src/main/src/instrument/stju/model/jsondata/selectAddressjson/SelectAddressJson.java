package instrument.stju.model.jsondata.selectAddressjson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */
public class SelectAddressJson {
    private List<ContentJson> Content;

    public List<ContentJson> getContent() {
        return Content;
    }

    public void setContent(List<ContentJson> Content) {

        this.Content = Content;
    }

    public SelectAddressJson() {
        Content = new ArrayList<ContentJson>();
    }


}
