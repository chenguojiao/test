package instrument.stju.common.route.showview;

import com.jfinal.config.Routes;
import instrument.stju.controller.*;


/**
 * Created by huangzhiwei on 16/10/29.
 */
public class ShowViewRoutes extends Routes {
    public void config() {
       add("/showclass", ShowClass.class);
        add("/showslide", SlideShow.class);
        add("/showinstrument", ShowInstrument.class);
        add("/showalbum", ShowAlbum.class);
        add("/showInsAndDes", InsAndDes.class);
        add("/getHeadPic", GetHeadIcon.class);
        add("/buyOrder", BuyInsOrder.class);
        add("/ReservationOrder", ReservationOrder.class);
        add("showSystemMessage",ShowSystemMessage.class);
        add("/helpcenter",HelpCenter.class);
        add("/classdetail",ShowClassDetail.class);
        add("/receiverAddress",ReceiverAddress.class);
        add("/classfeedback",ClassFeedBack.class);
        add("/buyInstrument",BuyInsOrder.class);
        add("/complaint",Complaint.class);

        add("/feedback",StudentFeedback.class);
    }
}
