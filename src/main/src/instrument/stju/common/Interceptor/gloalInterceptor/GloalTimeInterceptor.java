package instrument.stju.common.Interceptor.gloalInterceptor;

import com.jfinal.aop.Invocation;
import com.jfinal.aop.Interceptor;
/**
 * BlogInterceptor
 * 此拦截器仅做为示例展示，在本 demo 中并不需要
 */
public  class GloalTimeInterceptor implements Interceptor {
    public void intercept(Invocation ai) {
        long starTime=System.currentTimeMillis();
        ai.invoke();
        System.out.println("After action invoking");
        long endTime=System.currentTimeMillis();
        long Time=endTime-starTime;
        System.out.print(ai.getMethodName()+"执行时间");
        System.out.println(Time);
    }
}