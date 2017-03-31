package instrument.stju.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import instrument.stju.common.Interceptor.gloalInterceptor.GloalTimeInterceptor;


@Before(GloalTimeInterceptor.class)
public class BaseController extends Controller {
}
