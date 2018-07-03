package cn.suancloud.service;

import java.util.List;

import cn.suancloud.model.User;

public interface UserService{
  int insert(User user);
  List<User> userList();
  User userDetails(Long id);
  User selectByUsername(String username);

}
