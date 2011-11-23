package org.mycompany.audit;

import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuditAspectTests extends BaseTestClass
{
  @Autowired
  private IAuditRepository auditRepository;

  @Test
  public void testAudit()
  {
    AuditService service = new AuditService();
    // make sure call IS NOT audited
    service.unAuditedCall();
    assertThat(auditRepository.count(), CoreMatchers.is(0L));

    // make sure call IS audited
    service.auditedCall();
    assertThat(auditRepository.count(), CoreMatchers.is(1L));
  }

  class AuditService
  {
    @Auditable(actionCode = "auditedCall", auditMessage = "value returned was %r%")
    public String auditedCall()
    {
      return "current time is " + new Date();
    }

    public String unAuditedCall()
    {
      return "current time is " + new Date();
    }
  }
}
