package instrument.stju.shiro; /**
 * Copyright (C) 2014 陕西威尔伯乐信息技术有限公司
 * @Package com.wellbole.web.core.realm
 * @Title: ShiroDbRealm.java
 * @Description: 基于db实现的shiro realm   
 * @author 李飞 (lifei@wellbole.com)    
 * @date 2014年9月8日  下午10:10:38  
 * @since V1.0.0
 *
 * Modification History:
 * Date         Author      Version     Description
 * -------------------------------------------------------------
 * 2014年9月8日      李飞                       V1.0.0        新建文件   
 */

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.jfinal.kit.StrKit;

import javax.management.relation.Role;


/**
 * @ClassName: ShiroDbRealm
 * @Description: 基于db实现的shiro realm 
 * @author 李飞 (lifei@wellbole.com)   
 * @date 2014年9月8日 下午10:10:38
 * @since V1.0.0
 */
public class DbRealm extends AuthorizingRealm {

    public DbRealm(){
    }

    /**
     * 认证回调函数,登录时调用.
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){

      return null;


    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    private void addResourceOfRole(Role role, SimpleAuthorizationInfo info){

    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }
}
