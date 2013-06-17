package org.springframework.util;

import java.util.Arrays;


public class MethodIdentifier{
	String methodeName;
	Class[] prameters;
	
	public MethodIdentifier(String methodeName, Class[] prameters) {
		super();
		this.methodeName = methodeName;
		this.prameters = prameters;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((methodeName == null) ? 0 : methodeName.hashCode());
		result = prime * result + Arrays.hashCode(prameters);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodIdentifier other = (MethodIdentifier) obj;
		if (methodeName == null) {
			if (other.methodeName != null)
				return false;
		} else if (!methodeName.equals(other.methodeName))
			return false;
		if (!Arrays.equals(prameters, other.prameters))
			return false;
		return true;
	}


	
	
	
}