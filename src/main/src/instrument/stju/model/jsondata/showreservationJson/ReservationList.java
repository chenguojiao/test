package instrument.stju.model.jsondata.showreservationJson;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {
    List<ShowReservationJson> list;

    public List<ShowReservationJson> getList() {
        return list;
    }

    public void setList(List<ShowReservationJson> list) {
        this.list = list;
    }

    public ReservationList() {
        list = new ArrayList<ShowReservationJson>();
    }
}
