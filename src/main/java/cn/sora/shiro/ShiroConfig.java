package cn.sora.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置类
 * @author sora
 *
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean                                                                                //DefaultWebSecurityManager
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //设置登录页面
        //可以写路由也可以写jsp页面的访问路径
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置登录成功跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置未授权跳转的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        //定义过滤器
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        //LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        //放行login.html页面
        filterMap.put("/login", "anon");
        filterMap.put("/toLogin", "anon");
        //测试用---------------------------------------------------------------------
        filterMap.put("/index", "anon");
        filterMap.put("/userList", "anon");
        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到'登录页面'
        filterMap.put("/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 定义安全管理器securityManager,注入自定义的realm
     * @return
     */
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("accountUserRealm") AccountUserRealm accountUserRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(accountUserRealm);
        return manager;
    }
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("accountUserRealm") AccountUserRealm accountUserRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //关联realm
//        securityManager.setRealm(accountUserRealm);
//        return securityManager;
//    }

    /**
     * 配置shiro跟spring的关联
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * 创建Realm
     */
    @Bean(name="accountUserRealm")
    public AccountUserRealm getRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher){
        AccountUserRealm accountUserRealm = new AccountUserRealm();
        accountUserRealm.setAuthorizationCachingEnabled(false);
        accountUserRealm.setCredentialsMatcher(matcher);
        return accountUserRealm;
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    /**
     * 密码校验规则HashedCredentialsMatcher
     * 这个类是为了对密码进行编码的 ,
     * 防止密码在数据库里明码保存 , 当然在登陆认证的时候 ,
     * 这个类也负责对form里输入的密码进行编码
     * 处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    /**
     * Spring的一个bean , 由Advisor决定对哪些类的方法进行AOP代理 .
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
}

