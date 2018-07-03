package cn.suancloud.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

import cn.suancloud.model.User;
import cn.suancloud.service.UserService;
import cn.suancloud.util.JWTUtil;
import cn.suancloud.util.ResponseBean;

@RestController
public class SystemController {

  @Autowired
  UserService userService;
  @PostMapping("/login")
  public ResponseBean login(HttpServletRequest request, User user, Model model){
    User userdb = userService.selectByUsername(user.getUsername());
    if (userdb.getPassword().equals(user.getPassword())){
      return new ResponseBean(200, "Login success", JWTUtil.sign(user.getUsername(), user.getPassword()));
    }
    throw new UnauthorizedException();
  }

}
