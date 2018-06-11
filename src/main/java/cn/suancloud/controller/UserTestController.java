package cn.suancloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.suancloud.model.UserTest;
import cn.suancloud.service.UserTestService;

@RestController
@RequestMapping(value = "/usertest")
public class UserTestController {
  @Autowired
  private UserTestService userTestService;

  @PostMapping("/")
  public int addUser(UserTest user){
    return userTestService.addUser(user);
  }
  @GetMapping("/")
  public Object findAllUser(
          @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                  int pageNum,
          @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                  int pageSize){
    return userTestService.findAllUser(pageNum,pageSize);
  }

}
