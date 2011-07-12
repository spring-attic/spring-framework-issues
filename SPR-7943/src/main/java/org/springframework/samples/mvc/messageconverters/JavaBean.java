package org.springframework.samples.mvc.messageconverters;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@XmlRootElement
public class JavaBean {
	
	private String foo = "bar";

	private String fruit = "apple";
	
}
