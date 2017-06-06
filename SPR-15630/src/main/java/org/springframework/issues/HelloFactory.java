package org.springframework.issues;

public class HelloFactory {

  public Hello buildHello(){
    return new Hello();
  }
}
