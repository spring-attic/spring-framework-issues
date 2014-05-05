package atannotationbug;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import atannotationbug.AroundAdvice;
import atannotationbug.SimpleService;

import configuration.AtAnnotationBugConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AtAnnotationBugConfiguration.class)
public class AtAnnotatioBugTest {

  @Autowired
  AroundAdvice afterReturningAdvice;

  @Autowired
  SimpleService simpleService;

  @Test
  public void applicationContextWontStart() {
  }


}
