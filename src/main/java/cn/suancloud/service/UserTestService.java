package cn.suancloud.service;

import com.github.pagehelper.PageInfo;

import cn.suancloud.model.UserTest;

public interface UserTestService {

  int addUser(UserTest user);

  PageInfo<UserTest> findAllUser(int pageNum,int pageSize);
}
