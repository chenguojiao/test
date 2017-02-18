package instrument.stju.model.jsondata.showreservationJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/5.
 */
public class ReservationList {
    List<ShowReservationJson> list ;

    public List<ShowReservationJson> getList() {
        return list;
    }

    public void setList(List<ShowReservationJson> list) {
        this.list = list;
    }
    public ReservationList(){
        list = new ArrayList<ShowReservationJson>();
    }
}
