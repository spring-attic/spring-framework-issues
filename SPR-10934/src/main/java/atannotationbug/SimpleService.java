package atannotationbug;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

  @MyAnnotation
  public void doSomething() {
  }
  
}
