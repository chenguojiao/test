package instrument.stju.model.database;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by Administrator on 2017/2/18.
 */
public class BaseSlideShow <M extends BaseSlideShow<M>> extends Model<M> implements IBean {
    public void setId(java.lang.Integer id) {
        set("id", id);
    }

    public java.lang.Integer getId() {
        return get("id");
    }

    public void setSlideName(java.lang.String slideName) {
        set("slideName", slideName);
    }

    public java.lang.String getSlideName() {
        return get("slideName");
    }

    public void setSlideUrl(java.lang.String slideUrl) {
        set("slideUrl", slideUrl);
    }

    public java.lang.String getSlideUrl() {
        return get("slideUrl");
    }

}
