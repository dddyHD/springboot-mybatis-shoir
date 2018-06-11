package cn.suancloud.service;

import cn.suancloud.model.User;

public interface UserService extends BaseService<User,Long>{
  User selectByUsername(String username);
}
