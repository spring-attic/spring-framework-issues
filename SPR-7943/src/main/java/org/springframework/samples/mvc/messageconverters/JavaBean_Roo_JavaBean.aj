package org.springframework.samples.mvc.messageconverters;

import java.lang.String;

privileged aspect JavaBean_Roo_JavaBean {
    
    public String JavaBean.getFoo() {
        return this.foo;
    }
    
    public void JavaBean.setFoo(String foo) {
        this.foo = foo;
    }
    
    public String JavaBean.getFruit() {
        return this.fruit;
    }
    
    public void JavaBean.setFruit(String fruit) {
        this.fruit = fruit;
    }
    
}
