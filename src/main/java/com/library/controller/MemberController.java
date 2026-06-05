package com.library.controller;

import com.library.entity.member;
import com.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public member addMember(@RequestBody member member) {
        return memberService.saveMember(member);
    }
}