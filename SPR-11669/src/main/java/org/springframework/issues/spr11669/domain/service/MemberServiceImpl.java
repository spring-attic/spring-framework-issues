package org.springframework.issues.spr11669.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.spr11669.domain.model.Member;
import org.springframework.issues.spr11669.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member create(Member member) {
        return memberRepository.save(member);
    }

}
