package cn.suancloud.service.impl;

import cn.suancloud.dao.BaseDao;
import cn.suancloud.service.BaseService;

public class BaseServiceImpl<E,K> implements BaseService<E,K> {

  BaseDao<E,K> dao;
  public BaseServiceImpl(BaseDao dao) {
    this.dao=dao;
  }

  @Override
  public int insert(E entity) {
    return dao.insert(entity);
  }

  @Override
  public int delete(K key) {
    return dao.delete(key);
  }

  @Override
  public int update(E entity) {
    return dao.update(entity);
  }

  @Override
  public E select(K key) {
    return dao.select(key);
  }
}
