package cn.suancloud.model;

import java.io.Serializable;

/**
 * create Role  Entity class
 * @author gin
 * @version 2018.6.6
 */
public class Role implements Serializable {

  private Long id;

  private String name;

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
}
