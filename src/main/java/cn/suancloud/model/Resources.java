package cn.suancloud.model;

import java.io.Serializable;

/**
 * create Resources  Entity class
 * @author gin
 * @version 2018.6.6
 */
public class Resources implements Serializable {

  private Long id;

  private String name;

  private String res_url;

  private String method;

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

  public String getRes_url() {
    return res_url;
  }

  public void setRes_url(String res_url) {
    this.res_url = res_url;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }
}
