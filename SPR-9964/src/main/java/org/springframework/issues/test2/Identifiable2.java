package org.springframework.issues.test2;

import java.io.Serializable;

public interface Identifiable2<T> extends Serializable
{
  public T getId();

  public void setId(T id);

}
