package cn.suancloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.suancloud.dao.UserDao;
import cn.suancloud.model.User;
import cn.suancloud.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService {

  private UserDao dao;
  @Autowired
  public UserServiceImpl(UserDao dao) {
    super(dao);
    this.dao=dao;
  }

  @Override
  public User selectByUsername(String username) {
    return dao.selectByUsername(username);
  }
}
