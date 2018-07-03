package cn.suancloud.dao;

import java.util.List;
import java.util.Map;

import cn.suancloud.model.Permission;

public interface PermissionDao {
  List<Permission> loadUserPermission(Map<String,Object> map);
}
