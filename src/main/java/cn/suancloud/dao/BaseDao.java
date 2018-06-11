package cn.suancloud.dao;

public interface BaseDao<E,K> {
  int insert(E entity);
  int delete(K key);
  int update(E entity);
  E select(K key);
}
