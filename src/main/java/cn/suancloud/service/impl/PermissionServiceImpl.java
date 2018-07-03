package cn.suancloud.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.suancloud.model.Permission;
import cn.suancloud.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {


  @Override
  public List<Permission> loadUserPermission(Map<String, Object> map) {
    return null;
  }
}
