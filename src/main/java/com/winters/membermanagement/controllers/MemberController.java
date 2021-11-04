package com.winters.membermanagement.controllers;

import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("/")
    @ResponseBody
    public String test(){
        Member member = new Member();
        member.setFirstName("Adam");
        member.setLastName("Winters");
        memberRepository.save(member);
        return "Heya";
    }

}
