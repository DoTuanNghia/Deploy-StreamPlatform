package com.stream.backend.service;

import com.stream.backend.entity.Member;
import com.stream.backend.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member login(String username, String password) {
        Optional<Member> opt = memberRepository.findByUsernameAndPassword(username, password);
        return opt.orElse(null);  // login sai trả về null (cho đơn giản)
    }
}
