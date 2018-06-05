package cn.suancloud.dao;

import java.util.List;

import cn.suancloud.model.UserTest;

public interface UserTestDao {
  int insert(UserTest record);

  List<UserTest> selectUsers();
}
