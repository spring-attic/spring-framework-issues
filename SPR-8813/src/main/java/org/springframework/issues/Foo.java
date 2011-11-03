package org.springframework.issues;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("foo")
public class Foo {

    String value;
    int valueCounter = 0;

    @Value("${issues.test}")
    public void setValue(String value){
        this.value = value;
        valueCounter++;
    }

    public int getValueCounter(){
        return valueCounter;
    }

}
