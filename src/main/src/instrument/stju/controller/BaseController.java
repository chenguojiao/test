package instrument.stju.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import instrument.stju.common.Interceptor.gloalInterceptor.GloalTimeInterceptor;

/**
 * Created by huangzhiwei on 16/10/30.
 */
@Before(GloalTimeInterceptor.class)
public class BaseController extends Controller {
}
