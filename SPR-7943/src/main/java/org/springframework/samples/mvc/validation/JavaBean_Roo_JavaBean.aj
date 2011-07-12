package org.springframework.samples.mvc.validation;

import java.lang.Integer;
import java.util.Date;

privileged aspect JavaBean_Roo_JavaBean {
    
    public Integer JavaBean.getNumber() {
        return this.number;
    }
    
    public void JavaBean.setNumber(Integer number) {
        this.number = number;
    }
    
    public Date JavaBean.getDate() {
        return this.date;
    }
    
    public void JavaBean.setDate(Date date) {
        this.date = date;
    }
    
}
