package com.huawei.cse.houseapp.common;

import java.io.Serializable;
import java.util.Date;

public class BaseArea implements Serializable {
  private Long areaId;

  private Date created;

  private Long projectId;

  private String areaName;

  private Boolean enabled;

  public Long getAreaId() {
    return areaId;
  }

  public BaseArea setAreaId(Long areaId) {
    this.areaId = areaId;
    return this;
  }

  public Date getCreated() {
    return created;
  }

  public BaseArea setCreated(Date created) {
    this.created = created;
    return this;
  }

  public Long getProjectId() {
    return projectId;
  }

  public BaseArea setProjectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

  public String getAreaName() {
    return areaName;
  }

  public BaseArea setAreaName(String areaName) {
    this.areaName = areaName;
    return this;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public BaseArea setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BaseArea{");
    sb.append("areaId=").append(areaId);
    sb.append(", created=").append(created);
    sb.append(", projectId=").append(projectId);
    sb.append(", areaName='").append(areaName).append('\'');
    sb.append(", enabled=").append(enabled);
    sb.append('}');
    return sb.toString();
  }
}
