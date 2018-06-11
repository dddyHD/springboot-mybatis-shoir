package cn.suancloud.config.shiro;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;


import cn.suancloud.service.ResourcesService;

@Configuration
public class ShiroConfig {

  @Autowired
  private ResourcesService resourcesService;

  @Bean
  public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
    return new LifecycleBeanPostProcessor();
  }

@Bean
 public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){

    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

    shiroFilterFactoryBean.setSecurityManager(securityManager);

    // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
    shiroFilterFactoryBean.setLoginUrl("/login");

    // 登录成功后要跳转的链接
    shiroFilterFactoryBean.setSuccessUrl("/usersPage");

    //未授权界面;
    shiroFilterFactoryBean.setUnauthorizedUrl("/403");

    //拦截器.
    Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

    //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
    filterChainDefinitionMap.put("/logout", "logout");
    filterChainDefinitionMap.put("/css/**","anon");
    filterChainDefinitionMap.put("/js/**","anon");
    filterChainDefinitionMap.put("/img/**","anon");
    filterChainDefinitionMap.put("/font-awesome/**","anon");
    filterChainDefinitionMap.put("/**","authc");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilterFactoryBean;
  }

  @Bean
  public SecurityManager securityManager(){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(shiroRealm());
    return securityManager;
  }

  @Bean
  public ShiroRealm shiroRealm(){
    ShiroRealm shiroRealm = new ShiroRealm();
    return shiroRealm;
  }









}
