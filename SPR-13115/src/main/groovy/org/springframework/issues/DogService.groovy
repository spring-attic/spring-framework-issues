package org.springframework.issues

import org.springframework.stereotype.Component

@Component
class DogService {

    public String introduce(String name) {
        return dog(name).wuff()
    }

    private static Wuffing dog(String name) {
        return { "I'm the dog named $name. Wuff!".toString() } as Wuffing
    }

    private interface Wuffing {
        String wuff()
    }
}


