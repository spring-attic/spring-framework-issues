package org.springframework.samples.mvc.data;

import java.lang.String;

privileged aspect JavaBean_Roo_JavaBean {
    
    public String JavaBean.getParam1() {
        return this.param1;
    }
    
    public void JavaBean.setParam1(String param1) {
        this.param1 = param1;
    }
    
    public String JavaBean.getParam2() {
        return this.param2;
    }
    
    public void JavaBean.setParam2(String param2) {
        this.param2 = param2;
    }
    
    public String JavaBean.getParam3() {
        return this.param3;
    }
    
    public void JavaBean.setParam3(String param3) {
        this.param3 = param3;
    }
    
}
