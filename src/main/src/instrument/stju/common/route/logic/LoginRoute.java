package instrument.stju.common.route.logic;

import com.jfinal.config.Routes;
import instrument.stju.controller.*;


/**
 * Created by huangzhiwei on 16/10/29.
 */
public class LoginRoute extends Routes {

    public void config() {
        add("/", LoginController.class);
        add("/regist", Regist.class);
        add("/changeheadicon", Chicon.class);
        add("/feedback", FeedBack.class);
        add("/receiverAddress", ReceiverAddress.class);
        add("/deleteReceiverAddress", DeleteReceiverAddress.class);
        add("/buyInstrument", BuyInstrument.class);
        add("/uploadFile",PostFileTest.class);
        add("/login",Login.class);

    }
}
