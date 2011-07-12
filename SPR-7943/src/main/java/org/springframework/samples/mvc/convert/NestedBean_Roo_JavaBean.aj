package org.springframework.samples.mvc.convert;

import java.lang.String;
import java.util.List;
import java.util.Map;
import org.springframework.samples.mvc.convert.NestedBean;

privileged aspect NestedBean_Roo_JavaBean {
    
    public String NestedBean.getFoo() {
        return this.foo;
    }
    
    public void NestedBean.setFoo(String foo) {
        this.foo = foo;
    }
    
    public List<NestedBean> NestedBean.getList() {
        return this.list;
    }
    
    public void NestedBean.setList(List<NestedBean> list) {
        this.list = list;
    }
    
    public Map<String, NestedBean> NestedBean.getMap() {
        return this.map;
    }
    
    public void NestedBean.setMap(Map<String, NestedBean> map) {
        this.map = map;
    }
    
}
