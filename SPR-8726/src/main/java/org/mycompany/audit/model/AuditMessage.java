package org.mycompany.audit.model;

import java.util.Date;

/**
 * Audit message representing audit actions
 * 
 * @author jq240d
 * 
 */
public class AuditMessage
{
  private String id;
  private String actionCode;
  private String message;
  private Person actionBy;
  private Date actionDate;
  private boolean successIndicator;

  public AuditMessage()
  {
    successIndicator = true;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getActionCode()
  {
    return actionCode;
  }

  public void setActionCode(String actionCode)
  {
    this.actionCode = actionCode;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public Person getActionBy()
  {
    return actionBy;
  }

  public void setActionBy(Person actionBy)
  {
    this.actionBy = actionBy;
  }

  public Date getActionDate()
  {
    return actionDate;
  }

  public void setActionDate(Date actionDate)
  {
    this.actionDate = actionDate;
  }

  public boolean isSuccessIndicator()
  {
    return successIndicator;
  }

  public void setSuccessIndicator(boolean successIndicator)
  {
    this.successIndicator = successIndicator;
  }

  @Override
  public String toString()
  {
    return "AuditMessage [actionBy=" + actionBy + ", actionCode=" + actionCode
        + ", actionDate=" + actionDate + ", id=" + id + ", message=" + message
        + ", successIndicator=" + successIndicator + "]";
  }

}
