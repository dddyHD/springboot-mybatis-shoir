package cn.suancloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.suancloud.dao.UserTestDao;
import cn.suancloud.model.UserTest;
import cn.suancloud.service.UserTestService;

@Service
public class UserTestServiceImpl implements UserTestService {
  @Autowired
  private UserTestDao userTestDao;


  @Override
  public int addUser(UserTest user) {
    return userTestDao.insert(user);
  }

  @Override
  public PageInfo<UserTest> findAllUser(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<UserTest> userDomains = userTestDao.selectUsers();
    PageInfo result = new PageInfo(userDomains);
    return result;
  }
}
