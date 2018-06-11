package cn.suancloud.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

import cn.suancloud.model.User;

@RestController
public class System {
  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public String login(HttpServletRequest request, User user, Model model){
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
    subject.login(token);
    return "success";

  }

}
