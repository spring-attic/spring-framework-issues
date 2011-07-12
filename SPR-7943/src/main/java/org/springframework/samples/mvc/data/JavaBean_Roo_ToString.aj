package org.springframework.samples.mvc.data;

import java.lang.String;

privileged aspect JavaBean_Roo_ToString {
    
    public String JavaBean.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Param1: ").append(getParam1()).append(", ");
        sb.append("Param2: ").append(getParam2()).append(", ");
        sb.append("Param3: ").append(getParam3());
        return sb.toString();
    }
    
}
