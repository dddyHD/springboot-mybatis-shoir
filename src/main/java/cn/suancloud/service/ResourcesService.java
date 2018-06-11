package cn.suancloud.service;

import java.util.List;
import java.util.Map;

import cn.suancloud.model.Resources;

public interface ResourcesService {
  List<Resources> loadUserResources(Map<String,Object> map);
}
