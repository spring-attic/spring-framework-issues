package org.mycompany.audit;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.mycompany.audit.model.AuditMessage;
import org.mycompany.audit.model.Person;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect
{
  private Log logger = LogFactory.getLog(AuditAspect.class);
  @Autowired
  private IAuditRepository auditRepository;

  @Around("auditMethods()")
  public Object audit(ProceedingJoinPoint jp) throws Throwable
  {
    Throwable exception = null;
    Object retVal = null;
    Method method = AopUtils.getMostSpecificMethod(((MethodSignature) jp
        .getSignature()).getMethod(), jp.getTarget().getClass());
    logger.debug("inside auditing advice for '" + method.getName() + "'");

    try
    {
      logger.debug("proceed with original method invocation...");
      retVal = jp.proceed();
      logger.debug("original method invocation completed for method '"
          + method.getName() + "'");
    }
    catch (Throwable e)
    {
      exception = e;
      logger.debug("original method invocation for '" + method.getName()
          + "' threw exception '" + e.getClass().getName() + "'!");
    }

    Auditable annotation = method.getAnnotation(Auditable.class);
    if (annotation != null)
    {
      AuditMessage audit = new AuditMessage();
      String actionCode = annotation.actionCode();
      String auditMessage = annotation.auditMessage();
      Person principal = null;// determinePrincipal(annotation);
      auditMessage = (exception == null ? ""
          : "The following exception occurred: " + exception.toString());

      audit.setId(UUID.randomUUID().toString());
      audit.setActionCode(actionCode);
      audit.setMessage(auditMessage);
      audit.setSuccessIndicator(exception == null);
      audit.setActionBy(principal);
      audit.setActionDate(new Date());
      logger.info("audit message=> " + audit);

      logger.debug("persisting audit...");
      if (auditRepository == null)
      {
        logger.error("<<***************BAD: audit repo is null*************>>");
      }
      auditRepository.save(audit);
      logger.debug("persistance complete!");
    }

    if (exception != null)
    {
      logger.debug("re-throwing '" + exception.getClass().getName()
          + "' exception");
      throw exception;
    }
    return retVal;
  }

  @Pointcut("@annotation(org.mycompany.audit.Auditable)")
  public void auditMethods()
  {
  }
}
