package org.mycompany.audit;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated method is auditable.
 * 
 * @author mccusln
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auditable
{
  /**
   * Expression that will be used to detail an audit message. The most basic
   * expression would just be a string, such as "example audit message".
   * Parameters and return values can also be used. Parameters are expressed as
   * %p[n]% where 'n' is the parameter index. Example:
   * "The name was changed to %p1.toUpperCase()%." This would use the 1st
   * parameter of the method and apply the toUpperCase() function on the
   * parameter. Return values can also be used, and are expressed as %r%.
   * Example: "Get list returned %r.size()% results". Any combination of
   * parameters and return values are also permitted.
   * 
   * @return the auditMessage, if any
   */
  String auditMessage();

  /**
   * Action code for the audit event.
   * 
   * @return actionCode
   */
  String actionCode();

  /**
   * Principal with whom to override the audit action.
   * 
   * @return principal override
   */
  String principalOverride() default "";
}
