package org.springframework.issues.spr11669.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.issues.spr11669.domain.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
