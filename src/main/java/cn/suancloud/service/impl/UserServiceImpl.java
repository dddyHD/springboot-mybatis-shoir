package cn.suancloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.suancloud.dao.UserDao;
import cn.suancloud.model.User;
import cn.suancloud.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDao dao;

  @Override
  public User selectByUsername(String username) {
    return dao.selectByUsername(username);
  }

  @Override
  public int insert(User user) {
    return dao.insert(user);
  }

  @Override
  public List<User> userList() {
    return dao.userList();
  }

  @Override
  public User userDetails(Long id) {
    return dao.userDetails(id);
  }


}
