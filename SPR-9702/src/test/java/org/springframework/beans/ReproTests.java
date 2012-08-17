package org.springframework.beans;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/**
 * @author scottb
 * @since Aug 16, 2012
 */
public class ReproTests {

    @Test
    public void tester() throws Exception {

        // final Class<?> c = MyBean.class;
        final Class<?> c = Vehicle.class;
        Introspector.flushCaches();
        Introspector.getBeanInfo(c);

        while (true) {
            System.out.println("test");
            new ExtendedBeanInfo(Introspector.getBeanInfo(c));
            // CachedIntrospectionResults.forClass(c);
            System.out.println("allocate");
            allocate();
        }
    }

    private final List<String> data = new ArrayList<String>();

    private final Random rand = new Random();

    private void allocate() {
        for (int i = 0; i < 10000; i++) {
            data.add(Integer.toString(rand.nextInt()));
        }
    }

}
