package instrument.stju.model.jsondata.insAndDesJson;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhiwei on 16/10/29.
 */
public class InsList {
    private List<Inspics> inspicsList;

    public List<Inspics> getInspicsList() {
        return inspicsList;
    }

    public void setInspicsList(List<Inspics> inspicsList) {
        this.inspicsList = inspicsList;
    }
    public InsList(){
        inspicsList = new ArrayList<Inspics>();
    }
}
