package org.springframework.issues;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBody {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyBody [name=" + name + "]";
	}

}
