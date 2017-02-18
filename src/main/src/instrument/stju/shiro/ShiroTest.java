package instrument.stju.shiro;

import com.jfinal.kit.PathKit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by huangzhiwei on 16/11/9.
 */
public class ShiroTest {
    public static void main(String argus[]) {
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/webapp/upload";
        System.out.println(baseModelOutputDir);
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("huang","123");
        try {


            currentUser.login(token);
            System.out.println("ok");
        }catch (AuthenticationException e) {
            System.out.println("no");
        }
    }

}
