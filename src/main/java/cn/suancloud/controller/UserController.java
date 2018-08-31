package cn.suancloud.controller;


import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.suancloud.model.User;
import cn.suancloud.service.UserService;
import cn.suancloud.util.ResponseBean;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {
  @Autowired
  private UserService userService;

  /**
   * 获取用户列表
   *
   * @return ResponseBean
   */
  @GetMapping("/")
  @RequiresPermissions(logical = Logical.OR, value = {"user.*", "user.list"})
  public ResponseBean userList() {
    userService.userList();
    userService.userList();
    return new ResponseBean(userService.userList());
  }

  /**
   * 获取用户详情
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  @RequiresPermissions(logical = Logical.OR, value = {"user.*", "user.details"})
  public ResponseEntity userDetails(@PathVariable("id") Long id) {
    return ResponseEntity.ok("");
  }

  @PostMapping("/")
  public int addUser(User user) {
    return userService.insert(user);
  }

}
