package cn.suancloud.service;

public interface BaseService<E,K> {
  int insert(E entity);
  int delete(K key);
  int update(E entity);
  E select(K key);
}
