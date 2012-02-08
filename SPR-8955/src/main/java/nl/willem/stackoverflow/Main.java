/*
 * (C) 2012 Nidera (www.nidera.com). All rights reserved.
 */
package nl.willem.stackoverflow;

import nl.willem.stackoverflow.Abstract.Concrete;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Willem Dekker
 *
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        Concrete concrete = applicationContext.getBean(Concrete.class);
        concrete.inheritedMethod();
    }

}
