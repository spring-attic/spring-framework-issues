package org.springframework.samples.mvc.convert;

import java.util.List;
import java.util.Map;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class NestedBean {
	
	private String foo;

	private List<NestedBean> list;
	
	private Map<String, NestedBean> map;

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NestedBean");
        if (foo != null) {
        	sb.append(" foo=").append(foo);
        }
        if (list != null) {
        	sb.append(" list=").append(list);
        }
        if (map != null) {
        	sb.append(" map=").append(map);
        }
        return sb.toString();
    }
}