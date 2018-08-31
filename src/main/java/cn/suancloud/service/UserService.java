package cn.suancloud.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import cn.suancloud.model.User;
public interface UserService{
  int insert(User user);
  List<User> userList();
  User userDetails(Long id);
  User selectByUsername(String username);

}
