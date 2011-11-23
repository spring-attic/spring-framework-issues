package org.mycompany.audit;

import java.util.LinkedList;
import java.util.List;

import org.mycompany.audit.model.AuditMessage;
import org.springframework.stereotype.Repository;

@Repository
public class AuditRepository implements IAuditRepository
{
  List<AuditMessage> audits = new LinkedList<AuditMessage>();

  public void save(AuditMessage auditMessage)
  {
    audits.add(auditMessage);
  }

  public long count()
  {
    return audits.size();
  }

}
