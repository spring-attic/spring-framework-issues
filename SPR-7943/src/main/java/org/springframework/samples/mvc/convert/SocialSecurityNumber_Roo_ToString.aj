package org.springframework.samples.mvc.convert;

import java.lang.String;

privileged aspect SocialSecurityNumber_Roo_ToString {
    
    public String SocialSecurityNumber.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Value: ").append(getValue());
        return sb.toString();
    }
    
}
