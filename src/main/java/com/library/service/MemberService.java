package com.library.service;

import com.library.entity.member;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<member> getAllMembers() {
        return memberRepository.findAll();
    }

    public member saveMember(member member) {
        return memberRepository.save(member);
    }
}