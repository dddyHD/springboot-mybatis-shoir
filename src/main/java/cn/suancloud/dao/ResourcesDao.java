package cn.suancloud.dao;

import java.util.List;
import java.util.Map;

import cn.suancloud.model.Resources;

public interface ResourcesDao extends BaseDao<Resources,Long> {
  List<Resources> loadUserResources(Map<String,Object> map);
}
