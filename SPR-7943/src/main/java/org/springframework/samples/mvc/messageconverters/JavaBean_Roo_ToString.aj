package org.springframework.samples.mvc.messageconverters;

import java.lang.String;

privileged aspect JavaBean_Roo_ToString {
    
    public String JavaBean.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Foo: ").append(getFoo()).append(", ");
        sb.append("Fruit: ").append(getFruit());
        return sb.toString();
    }
    
}
