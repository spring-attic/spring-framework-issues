package org.springframework.samples.mvc.validation;

import java.lang.String;

privileged aspect JavaBean_Roo_ToString {
    
    public String JavaBean.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Number: ").append(getNumber()).append(", ");
        sb.append("Date: ").append(getDate());
        return sb.toString();
    }
    
}
