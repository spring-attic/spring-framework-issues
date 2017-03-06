package org.springframework.issues.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author mohanaraosv
 *
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackageClasses = { TraceAnnotationAspect.class, ProtectAnnotationAspect.class })
public class AspectConfig {

}
