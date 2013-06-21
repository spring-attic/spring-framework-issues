package org.springframework.issues;

import org.springframework.cache.concurrent.ConcurrentMapCache;

/**
 * Description
 *
 * @author chemist
 * @since 0.0.1
 */
public class TestCache extends ConcurrentMapCache {

    public TestCache(String name) {
        super(name, true); //allow null values
    }

    @Override
    public void evict(Object key) {
        System.out.println("but evict key: "+key);
        super.evict(key);
    }


}
