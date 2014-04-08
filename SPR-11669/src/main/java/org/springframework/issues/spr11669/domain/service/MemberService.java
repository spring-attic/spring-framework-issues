package org.springframework.issues.spr11669.domain.service;

import org.springframework.issues.spr11669.domain.model.Member;

public interface MemberService {
    Member create(Member member);
}
