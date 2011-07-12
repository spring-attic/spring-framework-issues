package org.springframework.samples.mvc.convert;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.samples.mvc.convert.NestedBean;

privileged aspect JavaBean_Roo_JavaBean {
    
    public Integer JavaBean.getPrimitive() {
        return this.primitive;
    }
    
    public void JavaBean.setPrimitive(Integer primitive) {
        this.primitive = primitive;
    }
    
    public Date JavaBean.getDate() {
        return this.date;
    }
    
    public void JavaBean.setDate(Date date) {
        this.date = date;
    }
    
    public String JavaBean.getMasked() {
        return this.masked;
    }
    
    public void JavaBean.setMasked(String masked) {
        this.masked = masked;
    }
    
    public List<Integer> JavaBean.getList() {
        return this.list;
    }
    
    public void JavaBean.setList(List<Integer> list) {
        this.list = list;
    }
    
    public List<Date> JavaBean.getFormattedList() {
        return this.formattedList;
    }
    
    public void JavaBean.setFormattedList(List<Date> formattedList) {
        this.formattedList = formattedList;
    }
    
    public Map<Integer, String> JavaBean.getMap() {
        return this.map;
    }
    
    public void JavaBean.setMap(Map<Integer, String> map) {
        this.map = map;
    }
    
    public NestedBean JavaBean.getNested() {
        return this.nested;
    }
    
    public void JavaBean.setNested(NestedBean nested) {
        this.nested = nested;
    }
    
}
