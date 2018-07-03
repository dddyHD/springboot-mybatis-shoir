package cn.suancloud.service;

import java.util.List;
import java.util.Map;

import cn.suancloud.model.Permission;

public interface PermissionService {
  List<Permission> loadUserPermission(Map<String,Object> map);
}
