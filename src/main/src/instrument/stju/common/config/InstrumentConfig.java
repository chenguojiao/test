package instrument.stju.common.config;


import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import instrument.stju.common.Interceptor.gloalInterceptor.GloalTimeInterceptor;
import instrument.stju.common.route.logic.LoginRoute;
import instrument.stju.common.route.showview.ShowViewRoutes;

/**
 * Created by lenovo on 2016/10/19.
 */
public class InstrumentConfig extends JFinalConfig {
    Routes routes;

    /**
     * 配置常量
     */
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/webapp/upload";
        //String baseModelOutputDir = "/root";

        me.setBaseDownloadPath(baseModelOutputDir);
        me.setBaseUploadPath(baseModelOutputDir);

        me.setMaxPostSize(1024*1025*100);



    }

    /**
     * 配置路由
     */
    public void configRoute(Routes me) {
        this.routes = me;
        //me.add("/", IndexController.class, "/index");	// 第三个参数为该Controller的视图存放路径
        //me.add("/blog", BlogController.class);			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
           me.add(new LoginRoute());
         me.add(new ShowViewRoutes());
       // me.add("/", LoginController.class);
        //me.add("/regist", Regist.class);
      //  me.add("/hello", Chicon.class);


    }

    public static C3p0Plugin createC3p0Plugin() {
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    /**
     * 配置插件
     */
    public void configPlugin(Plugins me) {
        // 配置C3p0数据库连接池插件
        C3p0Plugin C3p0Plugin = createC3p0Plugin();
        me.add(C3p0Plugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
        me.add(arp);

        // 所有配置在 MappingKit 中搞定
       // _MappingKit.mapping(arp);
    }

    /**
     * 配置全局拦截器
     */
    public void configInterceptor(Interceptors me) {
        me.addGlobalActionInterceptor(new GloalTimeInterceptor());

    }

    /**
     * 配置处理器
     */
    public void configHandler(Handlers me) {

    }

    /**
     * 建议使用 JFinal 手册推荐的方式启动项目
     * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
     */
    public static void main(String[] args) {
        JFinal.start("WebRoot", 80, "/", 5);
    }
}
