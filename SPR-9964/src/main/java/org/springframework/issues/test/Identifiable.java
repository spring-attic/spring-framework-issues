package org.springframework.issues.test;

import java.io.Serializable;

public interface Identifiable extends Serializable
{
  public Long getId();

  public void setId(Long id);

}
