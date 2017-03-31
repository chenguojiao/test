package instrument.stju.model.jsondata.showClassJson;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Classes implements Serializable {
    private int maxtime;
    private List<Class_Message> list;

    public int getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(int maxtime) {
        this.maxtime = maxtime;
    }

    public List<Class_Message> getList() {
        return list;
    }

    public void setList(List<Class_Message> list) {
        this.list = list;
    }

    public Classes() {
        list = new ArrayList<Class_Message>();
    }
}
