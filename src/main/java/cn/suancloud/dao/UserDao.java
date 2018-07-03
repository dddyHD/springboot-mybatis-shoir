package cn.suancloud.dao;

import java.util.List;

import cn.suancloud.model.User;

public interface UserDao{
  User selectByUsername(String username);
  int insert(User entity);
  List<User> userList();
  User userDetails(Long id);
}
