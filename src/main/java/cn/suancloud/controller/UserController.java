package cn.suancloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.suancloud.model.User;
import cn.suancloud.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/")
  public int addUser(User user){
    return userService.insert(user);
  }

}
