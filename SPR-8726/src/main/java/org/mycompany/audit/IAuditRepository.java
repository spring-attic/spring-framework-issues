package org.mycompany.audit;

import org.mycompany.audit.model.AuditMessage;

public interface IAuditRepository
{
  public void save(AuditMessage auditMessage);

  public long count();
}
