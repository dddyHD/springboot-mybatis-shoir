package cn.suancloud.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.suancloud.model.Resources;
import cn.suancloud.model.User;
import cn.suancloud.service.ResourcesService;
import cn.suancloud.service.UserService;

public class ShiroRealm extends AuthorizingRealm {

  @Resource
  private UserService userService;

  @Resource
  private ResourcesService resourcesService;

  /**
   * 授权
   * @param principalCollection
   * @return
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    User user = (User) SecurityUtils.getSubject().getPrincipal();
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("userId",user.getId());
    List<Resources> resourcesList = resourcesService.loadUserResources(map);
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    for (Resources resources: resourcesList){
      info.addStringPermission(resources.getRes_url());
    }
    return info;
  }

  /**
   * 认证
   * @param authenticationToken
   * @return
   * @throws AuthenticationException
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    String username = (String) authenticationToken.getPrincipal();
    User user = userService.selectByUsername(username);
    if (user==null)
      throw new UnknownAccountException();
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            user,user.getPassword(),ByteSource.Util.bytes(username),getName()
    );
    return authenticationInfo;
  }
}
