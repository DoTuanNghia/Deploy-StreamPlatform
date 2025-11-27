package com.stream.backend.service;

import com.stream.backend.entity.Member;
import com.stream.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    public Member login(String username, String password) {

        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Username không tồn tại"));

        if (!member.getPassword().equals(password)) {
            throw new RuntimeException("Sai mật khẩu");
        }

        return member; // trả về luôn entity (Spring Boot tự convert -> JSON)
    }
}
