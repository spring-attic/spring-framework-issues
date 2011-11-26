package org.springframework.issues;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ReproBeanInfo extends SimpleBeanInfo {

	private BeanInfo beanInfo;

	public ReproBeanInfo() throws IntrospectionException {
		this.beanInfo = Introspector.getBeanInfo(Repro.class.getSuperclass());
	}

	@Override
	public MethodDescriptor[] getMethodDescriptors() {
		MethodDescriptor[] methodDescriptors = this.beanInfo
				.getMethodDescriptors();
		// just ensuring the that order stays the same between executions
		Map<String, MethodDescriptor> signatures = new TreeMap<String, MethodDescriptor>(
				Collections.reverseOrder());
		for (MethodDescriptor methodDescriptor : methodDescriptors) {
			String signature = methodDescriptor.getMethod().toGenericString();
			if (signatures.put(signature, methodDescriptor) != null) {
				assert false;
			}
		}
		return signatures.values().toArray(
				new MethodDescriptor[signatures.size()]);
	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		PropertyDescriptor[] propertyDescriptors = this.beanInfo
				.getPropertyDescriptors();
		// just ensuring the that order stays the same between executions
		Map<String, PropertyDescriptor> propertyNames = new TreeMap<String, PropertyDescriptor>(
				Collections.reverseOrder());
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String propertyName = propertyDescriptor.getName();
			if (propertyNames.put(propertyName, propertyDescriptor) != null) {
				assert false : propertyName;
			}
		}
		return propertyNames.values().toArray(
				new PropertyDescriptor[propertyNames.size()]);
	}

}
