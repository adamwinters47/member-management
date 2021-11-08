package com.winters.membermanagement.services;

import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public Member getMemberById(Long id) throws Exception {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()){
            return member.get();
        } else {
            throw new Exception("No Entry found for id [" + id + "]");
        }
    }

    public List<Member> getAllMembers(){
        return (List<Member>) memberRepository.findAll();
    }

    public boolean deleteMemberById(Long id) {
        memberRepository.deleteById(id);
        return memberRepository.existsById(id);
    }
}
