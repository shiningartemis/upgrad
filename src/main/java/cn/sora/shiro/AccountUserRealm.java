package cn.sora.shiro;


import cn.sora.entity.AccountUser;
import cn.sora.service.AccountUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 * @author sora
 *
 */
public class AccountUserRealm extends AuthorizingRealm {

    @Autowired
    private AccountUserService accountUserService;

    /**
     * 执行授权逻辑(权限)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑(登陆)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        String password = "";
        if (token.getPassword() != null) {
            password = new String(token.getPassword());
        }

        AccountUser accountUser = accountUserService.selectByAccountName(token.getUsername());
        if(accountUser == null){
            return null;//shiro底层会抛出UnKnowAccountException
        }
        //当前realm对象的name
        String realmName = getName();
        //盐值 String.valueOf(user.getId())

        ByteSource credentialsSalt = ByteSource.Util.bytes(String.valueOf(accountUser.getId()));
        AuthenticationInfo info = new SimpleAuthenticationInfo(accountUser,accountUser.getUserPwd(),credentialsSalt,realmName);
        return info;
        //return new SimpleAuthenticationInfo(accountUser,accountUser.getUserPwd(),"");

    }
}
