package cn.suancloud.dao;

import cn.suancloud.model.User;

public interface UserDao extends BaseDao<User,Long> {
  User selectByUsername(String username);
}
