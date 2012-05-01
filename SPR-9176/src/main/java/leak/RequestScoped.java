package leak;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScoped implements BeanFactoryAware {

	@SuppressWarnings("unused")
	@Resource
	private HttpServletRequest request;

	private DefaultListableBeanFactory factory;


	public int doSomething() {
		return factory.getDependenciesForBean("scopedTarget.requestScoped").length;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.factory = (DefaultListableBeanFactory) beanFactory;
	}
}
