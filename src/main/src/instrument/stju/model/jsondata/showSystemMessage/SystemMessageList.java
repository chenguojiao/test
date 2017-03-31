package instrument.stju.model.jsondata.showSystemMessage;

import java.util.ArrayList;
import java.util.List;

public class SystemMessageList {
    private List<SystemMessageJson> list;

    public List<SystemMessageJson> getList() {
        return list;
    }

    public void setList(List<SystemMessageJson> list) {
        this.list = list;
    }

    public SystemMessageList() {
        list = new ArrayList<SystemMessageJson>();
    }
}
