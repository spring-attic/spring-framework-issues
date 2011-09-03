package pl.bug;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class AnyInterceptor implements MethodInterceptor {

	private List<String> invokedBy = new ArrayList<String>();
	
	public Object invoke( MethodInvocation invocation ) throws Throwable {
		
		invokedBy.add(invocation.getThis().getClass().getName());
		
		return null;
	}
	
	
	public List<String> getInvokedBy() {
		return invokedBy;
	}

}
