package cn.suancloud.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * create Role  Entity class
 * @author gin
 * @version 2018.6.6
 */
public class Role implements Serializable {

  private Long id;

  private String name;

  private Set<Permission> permissions = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<Permission> permissions) {
    this.permissions = permissions;
  }
}
