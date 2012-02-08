/*
 * (C) 2012 Nidera (www.nidera.com). All rights reserved.
 */
package nl.willem.stackoverflow;

import org.springframework.stereotype.Component;

/**
 * @author Willem Dekker
 *
 */
abstract class Abstract {

    public abstract void inheritedMethod();

    @Component
    static class Concrete extends Abstract {

        @Override
        public void inheritedMethod() {
            System.out.println("cool stuff going on!");
        }

    }

}
