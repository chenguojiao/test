package instrument.stju.model.jsondata.buyInsOrderJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhiwei on 16/11/3.
 */
public class OrderList {
    List<InsList> order_list;

    public List<InsList> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<InsList> order_list) {

        this.order_list = order_list;
    }
    public OrderList(){
        order_list = new ArrayList<InsList>();
    }
}
