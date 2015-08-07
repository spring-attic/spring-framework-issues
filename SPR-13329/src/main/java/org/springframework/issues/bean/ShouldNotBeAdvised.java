package org.springframework.issues.bean;

import org.springframework.issues.annotation.Annotation1;
import org.springframework.issues.annotation.Annotation2;
import org.springframework.stereotype.Component;

// It's important that the class implements an interface with methods, as that allows the creation of a Proxy, and
// that's where where the problem is.
@Annotation1
@Annotation2
@Component
public class ShouldNotBeAdvised implements CouldBeAdvised {
    @Override
    public void doNothing() {
    }
}
