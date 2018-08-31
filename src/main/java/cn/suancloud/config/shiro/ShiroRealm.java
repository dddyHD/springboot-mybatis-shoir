package cn.suancloud.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.suancloud.model.Permission;
import cn.suancloud.model.Role;
import cn.suancloud.model.User;
import cn.suancloud.service.PermissionService;
import cn.suancloud.service.UserService;
import cn.suancloud.util.JWTUtil;

@Service
public class ShiroRealm extends AuthorizingRealm {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private UserService userService;

  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof JWTToken;
  }

  /**
   * 授权
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    String username = JWTUtil.getUsername(principals.toString());
    User user = userService.selectByUsername(username);
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
    //存入roles
    if (user != null && user.getRoles() != null) {
      for (Role role : user.getRoles()) {
        simpleAuthorizationInfo.addRole(role.getName());
        //存入 权限
        if (role.getPermissions() != null)
          for (Permission permission : role.getPermissions())
            simpleAuthorizationInfo.addStringPermission(permission.getRes_url());
      }
    }
    return simpleAuthorizationInfo;
  }

  /**
   * 认证
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    String token = (String) authenticationToken.getCredentials();
    String username = JWTUtil.getUsername(token);
    if (username == null) {
      throw new AuthenticationException("token invalid");
    }

    User user = userService.selectByUsername(username);
    if (user == null) {
      throw new AuthenticationException("User didn't existed!");
    }
    if (!JWTUtil.verify(token, username, user.getPassword())) {
      throw new AuthenticationException("Username or password error");
    }
    return new SimpleAuthenticationInfo(token, token, "shiro_realm");
  }
}
